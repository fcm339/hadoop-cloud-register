package com.hzl.hadoop.gp.service.impl;

import com.hzl.hadoop.gp.constant.GpUrlConstant;
import com.hzl.hadoop.gp.repository.GpRepository;
import com.hzl.hadoop.gp.service.GpService;
import com.hzl.hadoop.gp.vo.GpVO;
import com.hzl.hadoop.gp.vo.VolumeVO;
import com.hzl.hadoop.gp.vo.YlVO;
import com.hzl.hadoop.gp.vo.ZXVO;
import com.hzl.hadoop.gp.yili.Convert;
import com.hzl.hadoop.util.JsonUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
		//生成对象
		GpVO gpVO = new GpVO();
		//初始化对象参数
		gpVO.init(date);
		gpVO.setGpCode(code);

		if (GpUrlConstant.GP_CODE_YL.equals(code)) {
			//伊利股票,利用对象克隆
			gpRepository.insert((YlVO) JsonUtils.cloneObject(gpVO, YlVO.class));

		} else if (GpUrlConstant.GP_CODE_ZX.equals(code)) {
			//中兴股票,利用对象克隆
			gpRepository.insert((ZXVO) JsonUtils.cloneObject(gpVO, ZXVO.class));
		}

		return gpVO;

	}

	@Override
	public List<VolumeVO> queryVolume(VolumeVO volumeVO) {
		return gpRepository.queryVolume(volumeVO);
	}


}
