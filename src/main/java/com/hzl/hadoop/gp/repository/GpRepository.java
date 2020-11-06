package com.hzl.hadoop.gp.repository;

import com.hzl.hadoop.gp.vo.GpVO;
import com.hzl.hadoop.gp.vo.VolumeVO;
import com.hzl.hadoop.gp.vo.YlVO;
import com.hzl.hadoop.gp.vo.ZXVO;

import java.util.List;

/**
 * description
 *
 * @author hzl 2020/10/31 5:16 PM
 */
public interface GpRepository {
	int insert(YlVO ylVO);

	int insert(ZXVO zxvo);

	/**
	 * 获取今日最大价格波动
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	List<GpVO> selectMaxPriceVolatility(String gpCode);

	/**
	 * 获取今日最小价格波动
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	List<GpVO> selectMinPriceVolatility(String gpCode);

	/**
	 * 获取当前股票价格
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	List<GpVO> selectCurrentPriceAll(String gpCode);

	/**
	 * 收盘成交价波动
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	List<VolumeVO> queryVolume(VolumeVO volumeVO);
}
