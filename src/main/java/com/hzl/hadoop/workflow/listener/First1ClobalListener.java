package com.hzl.hadoop.workflow.listener;

/**
 * description
 *
 * @author hzl 2021/11/04 10:29 AM
 */
public class First1ClobalListener extends GlobalListener {

	@Override
	public void listener(Long processId) {
		System.out.println(2L);
	}
}
