package com.thread.java5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
  
    锁
 与传统的synchronzed相比 更加面向对象
 */
public class LockTest {

	
	public static void main(String[] args) {
      new LockTest().init();
	}
	public  void init() {
		final OutPut out = new OutPut();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.currentThread().sleep(2 * 100);
						out.print("terry_zhang");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		//线程2
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.currentThread().sleep(2 * 100);
						out.print2("zhangshiquan");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// 2条线程同时操作一个对象
		thread.start();
		thread2.start();

	}
	
	static class OutPut {
		Lock lock=new ReentrantLock();
		public void print(String name) {
			int len = name.length();
			
			lock.lock();//上锁
			try{
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}finally{
				//不管程序出现异常还是什么  一定要解锁。
				lock.unlock();
				
			}
			
		}
		//为了不打断print()方法的执行  使用同一个锁对象 
		private void print2(String name){
	      int len = name.length();
			
			lock.lock();//上锁
			try{
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}finally{
				//不管程序出现异常还是什么  一定要解锁。
				lock.unlock();
				
			}
		}
		
	}
}
