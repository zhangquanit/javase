package com.cn.thread;

public class MainTest {
	
	public static void main(String[] args)throws Exception {
    MyThread target=new MyThread();
    new Thread(target).run();
    new Thread(target).run();
    new Thread(target).run();
		
	Thread thread=new Thread();
	thread.join(); //线程强制执行
	thread.isAlive();  //线程是否在运行
	thread.isInterrupted();//该线程是否被中断
	thread.yield();     //线程的礼让  暂时让其他线程运行
	thread.interrupt();//一个线程可以中断其他线程的运行状态
	thread.sleep(1000); //线程的休眠
	thread.setDaemon(true);//线程在后台运行 
	thread.setPriority(8);//设置线程的优先级  1-10  数值越大 优先级越高 越优先执行
	/**
	 * 后台线程
	 * 在Java程序中，只要前台有一个线程在运行，则整个java进程都不会消失，所以此时可以设置一个后台线程，
	 * 这样即使后台进程结束了，此后台线程依然会继续执行。要想实现这样的操作，直接使用setDamen()方法即可
	 */
		
	}

}
