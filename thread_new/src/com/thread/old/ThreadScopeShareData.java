package com.thread.old;

import java.util.HashMap;
import java.util.Random;

/**
 * 线程范围内的共享变量
  1.多个线程同时访问成员变量  数据混乱
  2.建立Map  将当前线程作为key,变量作为value  这样就不会混乱
 */
public class ThreadScopeShareData {
  private static int data; //成员变量
  private static HashMap<Thread, Integer> map=new HashMap<>();//线程范围内数据共享
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 for(int i=0;i<2;i++){
			 new Thread(new Runnable() {
				@Override
				public void run() {
					 //线程范围内数据共享  A,B模块共享变量data
					int data=new Random().nextInt();
					map.put(Thread.currentThread(),data);
					System.out.println(Thread.currentThread().getName()+" put data:"+data);
					new A().get();
					new B().get();
				}
			}).start();
		 }
	}

	static class A{
		public void get(){
			int data=map.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+" A  get data->"+data);
		}
	}
	static class B{
		public void get(){
			int data=map.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+" B  get data->"+data);
		}
	}
}
