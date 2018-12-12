package com.thread.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
        SynchronousQueue
  put() 直到有线程从队列中take()才能往队列中put() 否则处于阻塞状态
  take()
  
  准备10条数据  如果使用10条线程去取数据,则由于这10条线程都去抢夺数据  有可能某条线程能连续抢夺到2条数据，现
  要求10条线程都能获取到一条数据  则可以使用synchronousQueue,每条线程去获取一条即take(),同步队列才能put一条数据
  这样每条线程都能获取到一条数据。
  
  如果要求每条按顺序获取数据  则可以使用Semaphore(1)装入一个许可  每条线程获得许可前 都处于等待状态 除非有空余
  的许可  相当于同步
 */
public class SynchronousQueueTest {

	
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(1);//信号量 只有1个许可 相当于同步
         final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
           for(int i=1;i<=10;i++){
        	   new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						semaphore.acquire();//获得许可前处于阻塞状态
						String take = synchronousQueue.take();
						Test.doSome(take);
						semaphore.release();//释放许可
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}).start();
           }
          
           for(int i=1;i<=10;i++){
        	   try {
				synchronousQueue.put(""+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           }
	}

  static class Test{
	  public static void doSome(String input){
		  try {
			Thread.sleep(1*1000);
			System.out.println(Thread.currentThread().getName()+"取走 "+input);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  }
}
