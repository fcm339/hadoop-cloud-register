package com.hzl.hadoop.activiti;

import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * description
 *
 * @author hzl 2021/06/21 1:29 PM
 */
public  class MianshiTest {

	LinkedList linkedList=new LinkedList();
	public MianshiTest(LinkedList linkedList) {
		this.linkedList = linkedList;
	}

	public MianshiTest() {

	}
	public static void main(){
		HashMap<String,Integer> hashMap =new HashMap();

		hashMap.put("1",1);
	}



	public static void mrt(){
		SonTest.parent();
	}
}
