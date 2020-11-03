package com.hzl.hadoop.gp.service.impl;

import com.hzl.hadoop.gp.constant.GpUrlConstant;
import com.hzl.hadoop.gp.repository.GpRepository;
import com.hzl.hadoop.gp.service.GpService;
import com.hzl.hadoop.gp.vo.GpVO;
import com.hzl.hadoop.gp.vo.YlVO;
import com.hzl.hadoop.gp.vo.ZXVO;
import com.hzl.hadoop.gp.yili.Convert;
import com.hzl.hadoop.util.JsonUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/10/31 5:09 PM
 */
@Service
public class GpServiceImpl implements GpService {

	GpRepository gpRepository;

	public GpServiceImpl(GpRepository gpRepository) {
		this.gpRepository = gpRepository;
	}


	@Override
	public GpVO insert(String code) {

		Convert convert = new Convert();
		//通过url获取转化后的数据
		Map<String, String> date = convert.getGpInfo(GpUrlConstant.GP_BASE_URL.concat(code), null);
		//准备对象参数
		String gpName = date.get("股票名字");
		BigDecimal currentPrice = new BigDecimal(date.get("当前价格"));
		BigDecimal initPrice = new BigDecimal(date.get("今日开盘价"));
		BigDecimal maxPrice = new BigDecimal(date.get("今日最高价"));
		BigDecimal minPirce = new BigDecimal(date.get("今日最低价"));
		BigDecimal turnover = new BigDecimal(date.get("成交金额/元"));
		BigDecimal yesterdayEndPrice = new BigDecimal(date.get("昨日收盘价"));
		Long number = Long.valueOf(date.get("成交的股票数"));
		BigDecimal num = new BigDecimal("100000000");
		//生成对象
		GpVO gpVO = GpVO.builder().gpName(gpName)
				.currentPrice(currentPrice)
				.initPrice(initPrice)
				.maxPrice(maxPrice)
				.minPirce(minPirce)
				.turnover(turnover.divide(num))
				.number(number / 100)
				.createdDate(LocalDateTime.now())
				.yesterdayEndPrice(yesterdayEndPrice)
				.build();

		if (GpUrlConstant.GP_CODE_YL.equals(code)) {
			//伊利股票,利用对象克隆
			gpRepository.insert((YlVO) JsonUtils.cloneObject(gpVO, YlVO.class));

		} else if (GpUrlConstant.GP_CODE_ZX.equals(code)) {
			//中兴股票,利用对象克隆
			gpRepository.insert((ZXVO) JsonUtils.cloneObject(gpVO, ZXVO.class));
		}

		return gpVO;

	}


}
