package com.thread.old;
/**

  线程的2种创建方式
 */
public class TrandionalThread {

	public static void main(String[] args) {
             run();
	}
	
	public  static void run(){
		//方式一、继承Thread
		Thread innThread = new Thread(){
			public void run() {
				System.out.println("-------run");
			};
		};
		innThread.start();
//		innThread.start(); //重复调用start 会抛异常java.lang.IllegalThreadStateException
		
		/**
		 * 二、实现Runnable，并传入Thread中
		 */
		//1、匿名Runnable
		Thread  thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
				try {
					Thread.currentThread().sleep(500);
					System.out.println(Thread.currentThread().getName()+"在运行");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		});
		thread.start();

       //2.实现Runnable接口
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				while(true){
				try {
					Thread.currentThread().sleep(500);
					System.out.println(Thread.currentThread().getName()+"在运行");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		};
		
		new Thread(runnable).start();
		
	
		/* 
		 * 三.同时覆写Runnable的run方法和Thread的run方法  则最后执行的是Thread的Run方法
		 *   开启线程,首先会检查Thread的run方法是否被覆写,如果被覆写则执行该run方法。否则
		 *   检查构造函数传入的Runnable的run方法是否被覆写
		 */
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"-》Runnable的run方法在运行");
			}
		}){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"-》Thread的run方法在运行");
			}
		};
		
		thread2.start();
	}
}
