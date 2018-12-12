package com.cn.aopframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.cn.proxy.Advice;

/**
 * 专门用来创建bean
 * @author Administrator
 */
public class BeanFactory {
	Properties props = new Properties();
	public BeanFactory(InputStream ips){
		try {
			props.load(ips); //加载
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//根据名字创建bean
	public Object getBean(String name){
		String className = props.getProperty(name);//name为xxx
		Object bean = null;
		try {
			Class clazz = Class.forName(className);
			bean = clazz.newInstance();//创建对象  这要求javabean需要一个无参的构造方法 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if(bean instanceof ProxyFactoryBean){//假如该bean是代理对象
			Object proxy = null;
			ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)bean;
			try {
				 System.out.println("name="+name);       
				Advice advice = (Advice)Class.forName(props.getProperty(name + ".advice")).newInstance();
				Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
				System.out.println("advice="+advice+",target="+target);
				proxyFactoryBean.setAdvice(advice);//设置后 才能在getProxy方法中调用它们 
				proxyFactoryBean.setTarget(target);
				proxy = proxyFactoryBean.getProxy();//返回代理对象
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return proxy;
		}
		return bean;
	}
}
