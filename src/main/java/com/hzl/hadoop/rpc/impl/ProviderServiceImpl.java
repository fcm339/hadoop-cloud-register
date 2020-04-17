package com.hzl.hadoop.rpc.impl;

import com.hzl.hadoop.rpc.service.ProviderService;
//import org.apache.dubbo.config.annotation.Service;

/**
 * description
 *
 * @author hzl 2020/04/14 11:19 AM
 */
//@Service
public class ProviderServiceImpl implements ProviderService {

	@Override
	public boolean isSuccess(boolean param) {
		if (param) {
			return false;
		} else {
			return true;
		}

	}
}
