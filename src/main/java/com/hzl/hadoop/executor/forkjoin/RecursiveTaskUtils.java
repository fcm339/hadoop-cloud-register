package com.hzl.hadoop.executor.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * description
 *使用ForkJoin框架，需要创建一个ForkJoin的任务。因为ForkJoin框架为我们提供了RecursiveAction和RecursiveTask。
 * RecursiveTask在进行exec之后会使用一个result的变量进行接受返回的结果。而RecursiveAction在exec后是不会保存返回结果。
 * @author hzl 2021/09/15 9:36 PM
 */
public class RecursiveTaskUtils extends RecursiveTask<Integer> {

	//分裂参数
	private static final int segmentation = 1000;

	private int start;

	private int end;

	private int[] src;


	public RecursiveTaskUtils(int start, int end, int[] src) {
		this.start = start;
		this.end = end;
		this.src = src;
	}

	@Override
	protected Integer compute() {
		int sum=0;
		if((end-start)<=segmentation){
			for(int i=start;i<end;i++){
				sum+=src[i];
			}
			return sum;
		}else{
			//任务太大，拆分一下
			int middle = (end + start) / 2;
			System.out.println("中位数="+middle+"  end+start="+(end+start));
			RecursiveTaskUtils left = new RecursiveTaskUtils(start,middle,src);
			RecursiveTaskUtils right = new RecursiveTaskUtils(middle,end,src);
			invokeAll(left, right);
			return left.join() + right.join();
		}
	}
}
