package com.thread.test;

import java.util.concurrent.ArrayBlockingQueue;

/**
  
  打印16条日志  假设每条日志要打印1秒钟  一条线程就需要16秒才能打印完这些日志
 
 修改：在程序中增加4个线程去调用parseLog()方法来分别打印这16个日志对象,程序只需要运行4秒即可打印完这些日志对象。
  
  分析：要打印不乱 则方法要加synchronzed,开启4条线程去执行parseLog,由于是同步,每次执行都需要1秒,则还是需要16秒。
    现要求4条线程4秒完成,则应使用并发即4条线程同时执行。
 */
public class BlockingQueueTest {

	
	public static void main(String[] args) {
       final ArrayBlockingQueue<String> blockQueue = new ArrayBlockingQueue<String>(1);
       
        //开启4条线程打印
          for(int i=0;i<4;i++){
        	  new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						try {
							String take = blockQueue.take();
							  parseLog(take);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
          }
          
          //准备16条日志
          for(int i=1;i<=16;i++){
        	  try {
				blockQueue.put(""+i); //有线程从队列中take后才能put，循环16次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
          }
	}

	public  static  void parseLog(String log){
		System.out.println(log);
		try {
			Thread.sleep(1*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
