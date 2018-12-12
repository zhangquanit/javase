package com.cn.aopframework;

import java.io.InputStream;
import java.util.Collection;

public class AopFrameworkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*  实现普通类和代理类自由切换
		 * xxx=java.util.ArrayList
          #xxx=com.cn.aopframework.ProxyFactoryBean
		 */
		InputStream ips = AopFrameworkTest.class.getResourceAsStream("config.properties");
		Object bean = new BeanFactory(ips).getBean("xxx");
		System.out.println(bean.getClass().getName());//$Proxy0
		((Collection)bean).clear();//Spring中是转换为响应的javabean
	}

}
