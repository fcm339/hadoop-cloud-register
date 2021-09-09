package com.hzl.hadoop.security.service;

import com.hzl.hadoop.security.dataobject.SysUser;
import com.hzl.hadoop.security.vo.SysUserVO;

/**
 * description
 *
 * @author hzl 2021/09/09 5:06 PM
 */
public interface MyUserDetailsService {

	SysUser selectUser(SysUser sysUser);

	SysUser selectUserByUserName(String username);

	Boolean register(SysUserVO sysUserVO);
}
