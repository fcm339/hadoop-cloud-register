package com.hzl.hadoop.gp.mapper;

import com.hzl.cloud.config.mybatis.BaseMapperUtil;
import com.hzl.hadoop.gp.vo.GpVO;
import com.hzl.hadoop.gp.vo.YlVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description
 *
 * @author hzl 2020/11/03 12:32 PM
 */
@Mapper
public interface GpYlMapper extends BaseMapperUtil<YlVO> {
	/**
	 * 获取今日最大价格波动
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	List<YlVO> selectMaxPriceVolatility();

	/**
	 * 获取今日最小价格波动
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	List<YlVO> selectMinPriceVolatility();


	/**
	 * 获取今日价格
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	@Select("select * from  gp_yl gy where gy.created_date>CURRENT_DATE order by gy.id desc limit 1")
	List<YlVO> selectCurrentPrice();



	/**
	 * 获取当天历史价
	 *
	 * @return
	 * @author hzl 2020-11-04 9:45 AM
	 */
	@Select("select * from  gp_yl gy where gy.created_date>CURRENT_DATE order by id asc")
	List<GpVO> selectCurrentPriceAll();

}
