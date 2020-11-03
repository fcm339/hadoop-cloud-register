package com.hzl.hadoop.gp.repository.impl;

import com.hzl.hadoop.exception.CommonException;
import com.hzl.hadoop.gp.mapper.GpYlMapper;
import com.hzl.hadoop.gp.mapper.GpZxMapper;
import com.hzl.hadoop.gp.repository.GpRepository;
import com.hzl.hadoop.gp.vo.YlVO;
import com.hzl.hadoop.gp.vo.ZXVO;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author hzl 2020/10/31 5:17 PM
 */
@Component
public class GpRepositoryImpl implements GpRepository {

	GpYlMapper gpYlMapper;
	GpZxMapper gpZxMapper;

	public GpRepositoryImpl(GpYlMapper gpYlMapper, GpZxMapper gpZxMapper) {
		this.gpYlMapper = gpYlMapper;
		this.gpZxMapper = gpZxMapper;
	}

	@Override
	public int insert(YlVO ylVO) {
		int i = gpYlMapper.insert(ylVO);
		if (i <= 0) {
			throw new CommonException("插入伊利股票信息失败" + ylVO.toString());
		}
		return i;
	}

	@Override
	public int insert(ZXVO zxvo) {
		int i = gpZxMapper.insert(zxvo);
		if (i <= 0) {
			throw new CommonException("插入伊利股票信息失败" + zxvo.toString());
		}
		return i;
	}

}
