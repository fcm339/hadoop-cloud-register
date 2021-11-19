package com.hzl.hadoop.interfacemanager.mapper;

import com.hzl.hadoop.interfacemanager.vo.InterfaceManageVO;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzl.hadoop.interfacemanager.entity.InterfaceManageEntity;

import java.util.Set;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-16 14:05:48
 */
@Mapper
public interface InterfaceManageMapper extends BaseMapper<InterfaceManageEntity> {


	Set<String> selectUrls(InterfaceManageVO interfaceManageVO);
}
