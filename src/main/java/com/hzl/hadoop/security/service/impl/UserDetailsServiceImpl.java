package com.hzl.hadoop.security.service.impl;


import com.hzl.hadoop.exception.CommonException;
import com.hzl.hadoop.security.dataobject.SysUser;
import com.hzl.hadoop.security.service.MyUserDetailsService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * description
 * 自定义用户信息获取方式
 * @author hzl 2021/09/09 5:06 PM
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	MyUserDetailsService myUserDetailsService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser=myUserDetailsService.selectUserByUserName(username);
		if(ObjectUtils.isEmpty(sysUser)){
			//用户名不存在
			return null;
		}
		//AuthorityUtils.commaSeparatedStringToAuthorityList设置用户角色，该方法可以将逗号分隔的字符串转换为权限集合。参考https://www.cnblogs.com/bug9/p/11383485.html
		// @PreAuthorize("hasRole('user')") //只允许user角色访问
		return new User(username, sysUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
	}
}
