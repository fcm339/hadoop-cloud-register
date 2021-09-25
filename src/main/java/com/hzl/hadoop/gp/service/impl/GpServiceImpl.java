package com.hzl.hadoop.gp.service.impl;

import com.hzl.hadoop.constant.DataConstant;
import com.hzl.hadoop.gp.constant.GpUrlConstant;
import com.hzl.hadoop.gp.repository.GpRepository;
import com.hzl.hadoop.gp.service.GpService;
import com.hzl.hadoop.gp.vo.*;
import com.hzl.hadoop.gp.yili.Convert;
import com.hzl.hadoop.util.JsonUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author hzl 2020/10/31 5:09 PM
 */
@Service
public class GpServiceImpl implements GpService {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataConstant.DATESIM);

	GpRepository gpRepository;

	public GpServiceImpl(GpRepository gpRepository) {
		this.gpRepository = gpRepository;
	}


	@Override
	public GpVO insert(String code) {

		Convert convert = new Convert();
		//通过url获取转化后的数据
		Map<String, String> date = convert.getGpInfo(GpUrlConstant.GP_BASE_URL.concat(code), null);
		//生成对象
		GpVO gpVO = new GpVO();
		//初始化对象参数
		gpVO.init(date);
		gpVO.setGpCode(code);

		if (GpUrlConstant.GP_CODE_YL.equals(code)) {
			//伊利股票,利用对象克隆
			gpRepository.insert(JsonUtils.cloneObject(gpVO, YlVO.class));

		} else if (GpUrlConstant.GP_CODE_ZX.equals(code)) {
			//中兴股票,利用对象克隆
			gpRepository.insert(JsonUtils.cloneObject(gpVO, ZXVO.class));
		} else {
			gpRepository.insert(JsonUtils.cloneObject(gpVO, ZXVO.class));
		}

		return gpVO;

	}

	@Override
	public MaxMinHtmlVO queryVolume(VolumeVO volumeVO) {
		List<VolumeVO> volumeVOS = gpRepository.queryVolume(volumeVO);
		List<EndPriceVO> endPrice = volumeVOS.stream().map(a -> EndPriceVO.builder().series("收盘价/元(需除10)").x(a.getDate()).y(a.getCurrentPrice().doubleValue()*10).build()).collect(Collectors.toList());
		List<EndPriceVO> number = volumeVOS.stream().map(a -> EndPriceVO.builder().series("成交额/万手").x(a.getDate()).y(Double.valueOf(a.getNumber())).build()).collect(Collectors.toList());
		List<EndPriceVO> turnover = volumeVOS.stream().map(a -> EndPriceVO.builder().series("成交额/亿元").x(a.getDate()).y(a.getTurnover().doubleValue()).build()).collect(Collectors.toList());
		List<EndPriceVO> forecast = volumeVOS.stream().map(a -> EndPriceVO.builder().series("预估价格/元(需除10)").x(a.getDate()).y(((a.getTurnover().doubleValue()*100*10)/a.getNumber())).build()).collect(Collectors.toList());
		List<EndPriceVO> forecastPercent = volumeVOS.stream().map(a -> EndPriceVO.builder().series("(预估价格-收盘价格)/收盘价格").x(a.getDate()).y(((((a.getTurnover().doubleValue()*100)/a.getNumber())-a.getCurrentPrice().doubleValue())/(a.getCurrentPrice().doubleValue()*100))*1000000).build()).collect(Collectors.toList());
		//根据成交额和


		List<EndPriceVO> all = new ArrayList<>();
		all.addAll(endPrice);
		all.addAll(number);
		all.addAll(turnover);
		all.addAll(forecast);
		all.addAll(forecastPercent);
		all.sort(Comparator.comparing(EndPriceVO::getX));
		MaxMinHtmlVO maxMinHtmlVO = MaxMinHtmlVO.builder().data(JsonUtils.objectToString(all)).build();
		return maxMinHtmlVO;
	}

//	public static void main(String args[]){
//		BigDecimal bg = new BigDecimal(2.562);
//		double f1 = bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
//		System.out.println(f1);
//	}

}
