package com.thread.old;

import java.util.Random;

/**
  ThreadLocal  线程范围的共享变量  
 内部封装了一个Map,key为当前线程,  value为共享的变量  存放的是一条线程内的共享变量
 
 ThreadLocal代表一个变量  只能存放一个数据,如果有一百个变量要共享,则应先定义一个对象来封装这一百个变量
 然后在ThreadLocal中储存这个对象。
 
 应用场景：完成线程范围内数据共享。
 */
public class ThreadLocalTest {
	//单个成员变量
	static ThreadLocal<Integer> local=new ThreadLocal<>();//存放Integer类型变量

	public static void main(String[] args) {
          for(int i=0;i<2;i++){
        	  new Thread(new Runnable() {
				
				@Override
				public void run() {
                    int data=new Random().nextInt();
                    
                    //单个变量
//                    local.set(data); 
                    System.out.println(Thread.currentThread().getName()+" put data->"+data);
                    
                    //多个变量的封装
                    MyThreadScopeData.getInstance().setAge(data);
                    MyThreadScopeData.getInstance().setName("name-"+data);
                    
                    new A().get();
                    new B().get();
				}
			}).start();
          }
	}

	static class A{
		public void get(){
			//1.单个变量
//			Integer data = local.get();
//			System.out.println(Thread.currentThread().getName()+" A get data->"+data);
			
			//2.多个变量
			int age = MyThreadScopeData.getInstance().getAge();
			String name = MyThreadScopeData.getInstance().getName();
			System.out.println(Thread.currentThread().getName()+" A getdata:(age="+age+",name="+name+")");
		}
	}
	static class B{
		public void get(){
			//1.单个变量
//			Integer data = local.get();
//			System.out.println(Thread.currentThread().getName()+" B get data->"+data);
			
			//2.多个变量
			int age = MyThreadScopeData.getInstance().getAge();
			String name = MyThreadScopeData.getInstance().getName();
			System.out.println(Thread.currentThread().getName()+" B getdata:(age="+age+",name="+name+")");
		}
		
	}
	
	/**
	 * 多个变量需要共享
	 */
	static class MyThreadScopeData{
		private static ThreadLocal<MyThreadScopeData> map=new ThreadLocal<MyThreadScopeData>();
		public static MyThreadScopeData  getInstance(){
			MyThreadScopeData instance = map.get();
			  if(instance==null){
				  instance=new MyThreadScopeData();
				  map.set(instance);//将实例与本线程绑定
				  
			  }
			  return instance;
		}
		
		
		public MyThreadScopeData(){}
		private int age;
		private String name;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
