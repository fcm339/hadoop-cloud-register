package com.hzl.hadoop.util;

import com.hzl.hadoop.exception.CommonException;

import java.util.Arrays;

/**
 * description
 * 算法
 * 数组特点：有序可重复，固定大小
 *
 * @author hzl 2020/04/13 9:49 AM
 */
public class AlgorithmUtils {

	public static void main(String args[]) {
		int[] array = {1, 7, 8, 9, 3};
		int[] result;
		//调用冒泡排序
		result = bubbling(array);
		System.out.println(result);
	}

	//===============================================================================
	//  冒泡排序,1,7,8,9,3(从左往右排序，排序完成后小的在右边，大的在左边)
	//===============================================================================

	public static int[] bubbling(int[] params) {

		int size = params.length;
		if (size <= 1) {
			throw new CommonException("数组大小必须大于等于2");
		}
		//用于存储排序后的最大值
		//int[] temp = new int[size];
		for (int i = 0; i < size; i++) {
			int left = params[i];
			for (int j = i + 1; j < size; j++) {
				int right = params[j];
				System.out.println("right:" + right + "left:" + left);
				if (left < right) {
					params[i] = right;
					params[j] = left;
					left = right;
				}
			}
			System.out.println("每次外层循环结束后数组情况" + Arrays.toString(params));
		}
		return params;
	}

	//===============================================================================
	//  选择排序 1,7,8,9,3
	//===============================================================================

	public static int[] selectionSort(int[] params) {

		return params;
	}
}
