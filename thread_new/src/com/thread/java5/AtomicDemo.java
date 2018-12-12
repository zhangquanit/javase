package com.thread.java5;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
  java.util.concurrent.atomic中实现的原子操作类包括：
  AtomicBoolean、AtomicInteger、AtomicLong、AtomicReference。
 */
public class AtomicDemo {

	 AtomicInteger count=new AtomicInteger(5);//对基本数据，对数组中的基本数据达到数据共享的目的
	 int num=5;//普通成员变量，多线程访问该成员变量时，容易产生数据混乱
	public static void main(String[] args)throws Exception {
		final AtomicDemo atomicDemo=new AtomicDemo();
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						atomicDemo.add(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();;
		}
		
	}
	public  void add(int value)throws Exception{
		String name=Thread.currentThread().getName();
		Thread.sleep(new Random().nextInt(3*1000));
		System.out.println(name+" before  count="+count +",num="+num);
		count.addAndGet(value);
		num+=value;
		System.out.println(name+" after  count="+count +",num="+num);
	}
 
}
