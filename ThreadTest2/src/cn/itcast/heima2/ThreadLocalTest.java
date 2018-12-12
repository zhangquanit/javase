package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * ThreadLocal
 *    ThreadLocal<T>  :T代表存放的数据类型
 * 存放与本线程有关的数据,set设置,get取值
 *一个TheadLocal代表一个变量,所以其中只能存放一个数据,有两个变量都要线程范围内共享,则要定义两个ThreadLocal对象。
 *如果有多个变量需要线程范围内(同一个线程内)的共享,则需要创建一个实体bean
 */
public class ThreadLocalTest {

	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					x.set(data);
/*					MyThreadScopeData myData = new MyThreadScopeData();
					myData.setName("name" + data);
					myData.setAge(data);
					myThreadScopeData.set(myData);*/
					MyThreadScopeData.getThreadInstance().setName("name" + data);
					MyThreadScopeData.getThreadInstance().setAge(data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			int data = x.get();
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + data);
/*			MyThreadScopeData myData = myThreadScopeData.get();;
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " getMyData: " + myData.getName() + "," +
					myData.getAge());*/
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " getMyData: " + myData.getName() + "," +
					myData.getAge());
		}
	}
	
	static class B{
		public void get(){
			int data = x.get();			
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + data);
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " getMyData: " + myData.getName() + "," +
					myData.getAge());			
		}		
	}
}

class MyThreadScopeData{
	private MyThreadScopeData(){}
	public static /*synchronized*/ MyThreadScopeData getThreadInstance(){
		MyThreadScopeData instance = map.get();
		if(instance == null){
			instance = new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	//private static MyThreadScopeData instance = null;//new MyThreadScopeData();
	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

/**
 * 简易案例
 */

/*public class ThreadLocalTest {
	private static int data;
	private static ThreadLocal<Integer> mThreadLocal=new ThreadLocal<Integer>();

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int data=new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+"存放数据"+data);
					mThreadLocal.set(data);
					new A().get();
					new B().get();
				}
			}).start();
		}

	}

	static class A{
		public void get(){
			System.out.println("A从线程："+Thread.currentThread().getName()+"取出数据"+mThreadLocal.get()); 
		}
	}
	
	static class B{
		public void get(){
			System.out.println("B从线程："+Thread.currentThread().getName()+"取出数据"+mThreadLocal.get()); 
		}
	}
}*/
























