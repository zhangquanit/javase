package com.cn.thread;

public class OneThread {

	/** 线程初步
	 * @param args
	 */
	public static void main(String[] args) {
     //1.实例化3个对象,实际上只是开启了3条不同的线程,没有达到资源共享的目的
//		new ThreadTest().start();
//		new ThreadTest().start();
//		new ThreadTest().start();
	   
	 //2.同一线程对象调用多次start()并没有开启多个线程,实际上只有第一次的start会执行。
/*		ThreadTest thread=new ThreadTest();
		thread.start();
		thread.start();
		thread.start();*/
	 //3.实现Runnable接口达到资源共享的目的
		
/*		 ThreadTest2 thread=new ThreadTest2();
	   new Thread(thread).start();
	   new Thread(thread).start();
	   new Thread(thread).start();*/
		
	 //选择同步代码块和同步方法
		 ThreadTest3 thread=new ThreadTest3();
		 new Thread(thread).start(); //开启第一个线程
		 thread.tockenStr="method";  //改变监视对象, 
		 new Thread(thread).start(); //开启第二个线程
		 
    //结果：2个线程都只会执行sale(),而没有根据改变监视对象而去执行同步代码块
		 
	}

	
}
class ThreadTest extends Thread{
	int tickets=10;

	@Override
	public void run() {
		while(true){
			if(tickets>0){
			System.out.println(Thread.currentThread().getName()+"在运行，tickets="+tickets--);	
			}
		}
		
	}
}

/**
 * 同步代码块和同步方法
 * @author zhangquan
 *
 */
class ThreadTest2 implements Runnable{
	int tickets=10;
	String tockenStr=new String("");
	@Override
	public void run() {
		
		
		while(true){
//			if(tickets>0){
//			System.out.println(Thread.currentThread().getName()+"在运行，tickets="+tickets--);	
//			}
			
		/*
		 * 同步代码块,使用tockenStr作为监视对象,注意该监视对象只能放在run方法外面,不然多个线程会执行多次
		 * 这样就不能使用同一个监视对象,达不到同步的目的
		 */
			synchronized (tockenStr) {
				if(tickets>0){
					System.out.println(Thread.currentThread().getName()+"在运行，tickets="+tickets--);	
					}
			}
		}
 
	}
	
   //同步方法  使用this作为监视对象
	public synchronized void sale() {
		if (tickets > 0) {
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
		    System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName()
					+ "在运行，tickets=" + tickets--);
		}
	}
}


/**
 * 调用同步方法和同步代码块
 * @author zhangquan
 *
 */
class ThreadTest3 implements Runnable{
	int tickets = 10;
	String tockenStr = new String("");

	@Override
	public void run() {

		if (tockenStr.equals("method")) {
			while (true) {
				sale();
			}

		} else {
			while (true) {

				synchronized (tockenStr) {
					if (tickets > 0) {
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							System.out.println(e);
						}
						System.out.println(Thread.currentThread().getName()
								+ "在运行，tickets=" + tickets--);
					}
				}
			}
		}
	}

	 //同步方法     使用this作为监视对象
	public synchronized void sale() {
		if (tickets > 0) {

			try {
				Thread.sleep(10);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.print("sale()");
			System.out.println(Thread.currentThread().getName()
					+ "在运行，tickets=" + tickets--);
		}
	}
	
	 /**
	  * 需要考虑线程同步的方法
	  */
 public char[] data=new char[100];
 int index=0;

 public void push(char c){
	 data[index]=c;
	 index++; //如果同时有两条线程执行index++，则会造成数据错误
 }
}




