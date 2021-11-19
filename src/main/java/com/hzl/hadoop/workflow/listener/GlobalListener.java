package com.hzl.hadoop.workflow.listener;

/**
 * description
 * 全局监听，实现自定义全局监听需要实现改抽象类
 * @author hzl 2021/11/04 9:21 AM
 */
public abstract class GlobalListener {




	/**
	 *
	 * 监听功能
	 * @param processId 流程id
	 * @author hzl 2021-11-04 9:58 AM
	 * @return
	 */

	public abstract void listener(Long processId);

}
