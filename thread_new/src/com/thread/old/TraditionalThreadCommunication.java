package com.thread.old;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程的通信
 * 
 * 子线程循环10次，接着主线程循环50次,接着又回到子线程循环10次,接着再回到主线程循环50次, 如此循环30次。
 * 
 * wait和notify必须在synchronzed中使用,而且必须使用同一个监视对象
 */
public class TraditionalThreadCommunication {

	public static void main(String[] args) {

     
//		// 1.创建子线程
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 1; i <= 30; i++) {
//					synchronized (TraditionalThreadCommunication.class) {
//						for (int j = 1; j <= 10; j++) {
//							System.out.print("sub thread run at " + j
//									+ " of sequence " + i);
//						}
//					}
//				}
//
//			}
//		}).start();
//
//		// 2 主线程循环
//		for (int i = 1; i <= 30; i++) {
//			synchronized (TraditionalThreadCommunication.class) {
//				for (int j = 1; j <= 10; j++) {
//					System.out.print("main thread run at " + j
//							+ " of sequence " + i);
//				}
//			}
//		}
		
		//2.拆分业务 
		
		final Business business=new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 30; i++) {
					business.sub(i);//子线程循环10次
				}
			}
		}).start();
		
		for (int i = 1; i <= 30; i++) {
			business.main(i);//主线程循环50次
		}
	}

	/**
	 * 要用到共同数据(包括同步锁)的若干方法应该归在同一个类身上,这种设计正好体现了高类聚和程序的健壮性
	 * 同步和互斥都是放在同一个类中
	 */
	static class Business{
		private boolean bShouldSub=true;//默认让子线程先执行
		//子线程执行10次
		public synchronized void sub(int i){
			while(!bShouldSub){ //如果主线程在运行  则等待
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.print("sub thread run at " + j
						+ " of sequence " + i);
			}
			bShouldSub=false;//子线程运行完了 应该让主线程运行
			this.notify(); //唤醒正在等待的线程 即主线程
		}
		
		//主线程执行50次
		public synchronized void main(int i){
			while(bShouldSub){ //如果子线程在运行  则等待
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for (int j = 1; j <= 50; j++) {
				System.out.print("main thread run at " + j
						+ " of sequence " + i);
			}
			bShouldSub=true;//主线程运行完了 应该让子线程执行
			this.notify();
		}
	}
}
