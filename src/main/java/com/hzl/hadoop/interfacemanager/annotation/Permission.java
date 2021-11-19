package com.hzl.hadoop.interfacemanager.annotation;

import java.lang.annotation.*;

/**
 * description
 * 　1.CONSTRUCTOR:用于描述构造器
 * 　　　　2.FIELD:用于描述域
 * 　　　　3.LOCAL_VARIABLE:用于描述局部变量
 * 　　　　4.METHOD:用于描述方法
 * 　　　　5.PACKAGE:用于描述包
 * 　　　　6.PARAMETER:用于描述参数
 * 　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 * 参考：https://blog.csdn.net/qq_18671415/article/details/111866229
 * <p>
 * 该注解可以作用到类上和方法上，方法上的可以覆盖类上的
 *
 * @author hzl 2021/11/16 2:54 PM
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
	boolean isLogin() default true;

	long tenantId() default 1;
}
