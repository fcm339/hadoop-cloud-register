package com.hzl.hadoop.exception;

import com.hzl.hadoop.constant.ExceptionCode;
import lombok.Data;

/**
 * description
 * 自定义异常
 * @author hzl 2020/01/02 8:46 PM
 */
@Data
public class CommonException extends RuntimeException{
	private String code;
	private String msg;

	public CommonException(String msg) {
		super(msg);
		this.code= ExceptionCode.ERROR;
		this.msg = msg;
	}
}
