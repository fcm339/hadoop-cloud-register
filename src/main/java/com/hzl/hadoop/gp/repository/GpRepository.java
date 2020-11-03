package com.hzl.hadoop.gp.repository;

import com.hzl.hadoop.gp.vo.YlVO;
import com.hzl.hadoop.gp.vo.ZXVO;

/**
 * description
 *
 * @author hzl 2020/10/31 5:16 PM
 */
public interface GpRepository {
	int insert(YlVO ylVO);

	int insert(ZXVO zxvo);
}
