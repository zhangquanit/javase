package com.cn.proxy;

import java.lang.reflect.Method;

/*
 * 添加到代理类上的功能
 */
public class MyAdvice implements Advice {
	long beginTime = 0;
	public void afterMethod(Method method) {
		
		System.out.println("额外功能结束");	
		long endTime = System.currentTimeMillis();
		System.out.println(method.getName() + " running time of " + (endTime - beginTime));

	}

	public void beforeMethod(Method method) {
		
		System.out.println("额外功能开始");
		beginTime = System.currentTimeMillis();
	}

}
