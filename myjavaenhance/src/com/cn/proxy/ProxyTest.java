package com.cn.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProxyTest {

	/** 
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		//创建Collection的代理类     第一个参数为该类的加载器     第二个参数为该类.class
		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(clazzProxy1.getName());
		
		System.out.println("----------begin constructors list----------");
		/* 打印代理类的构造方法
		$Proxy0()
		$Proxy0(InvocationHandler,int)*/
		Constructor[] constructors = clazzProxy1.getConstructors();
		for(Constructor constructor : constructors){
			String name = constructor.getName();
			StringBuilder sBuilder = new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParams = constructor.getParameterTypes();//构造方法参数类型
			for(Class clazzParam : clazzParams){
				sBuilder.append(clazzParam.getName()).append(',');//构造方法参数名
			}
			if(clazzParams!=null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder.toString());			
		}

		System.out.println("----------begin methods list----------");
		/*打印代理类的方法
		$Proxy0()
		$Proxy0(InvocationHandler,int)*/
		Method[] methods = clazzProxy1.getMethods();
		for(Method method : methods){
			String name = method.getName();
			StringBuilder sBuilder = new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParams = method.getParameterTypes();
			for(Class clazzParam : clazzParams){
				sBuilder.append(clazzParam.getName()).append(',');
			}
			if(clazzParams!=null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder.toString());			
		}
        
		System.out.println("----------begin create instance object----------");
		
		//创建动态类的实例对象1   构造方法的参数类型为InvocationHandler
		Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
		class MyInvocationHander1 implements InvocationHandler{

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		
		}             
	   //创建动态类的实例对象2  方法参数为InvocationHandler匿名对象
		Collection proxy1 = (Collection)constructor.newInstance(new MyInvocationHander1());
		
		System.out.println(proxy1);
		//代理Collection的clear方法
		proxy1.clear();//返回为null  因为上面invoke方法返回为null

		
		             // 通过匿名内部类传入方法参数
		Collection proxy2 = (Collection)constructor.newInstance(new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				return null;
			}
			
		});
		
		/*
		 * 创建动态类的实例对象3   
		 *  接收用户输入参数     advice为添加到代理类上的功能
		 */
		final ArrayList target = new ArrayList();			
//		Collection proxy3 = (Collection)getProxy(target,new MyAdvice());
		List proxy3 = (List)getProxy(target,new MyAdvice());
	/*
	 * 调用代理类的方法
	 * 将调用内部InvocationHandler的invoke方法，将代理对象proxy3,方法add，方法参数"zxx"传入
	 * 调用invoke方法后才返回代理类的值
	 */
		proxy3.add("zxx");
		proxy3.add("lhm");
		System.out.println(proxy3.size());//调用完invoke方法后才返回2
		System.out.println(proxy3.getClass().getName());//$Proxy1  
		System.out.println(Collection.class.getName());//java.util.Collection
	}
 
	private static Object getProxy(final Object target,final Advice advice) {
		   //创建动态类的实例对象3          将创建代理类.class和实例化代理类对象合并为一个方法
		Object proxy3 = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				/*new Class[]{Collection.class},*/
				target.getClass().getInterfaces(),
				new InvocationHandler(){
				    /* 第一个参数为 代理对象  
				     * 第二个参数为代理对象的方法
				     * 第三个参数为代理对象的方法传递的参数
				     */
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
                       /*
                        * 添加到代理类上的功能  
                        * 因为每次调用代理类的的方法都会调用invoke()方法，也就会每次都调用我们添加的功能
                        * 这样就实现了面向切面编程(完成了所有代理类方法的交叉任务).
                        */
						advice.beforeMethod(method); 
						Object retVal = method.invoke(target, args);//代理操作
						advice.afterMethod(method);
						return retVal;						
						
					}
				}
				);
		return proxy3;
	
	}
}
