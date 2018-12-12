package com.thread.java5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
  
    线程池
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		 //创建一个固定大小的线程池
//		  newFixedThreadPool(3);
		  
         //缓存线程池 线程个数不一定,任务多就增加线程
//         newCachedThreadPool();
		  
         //创建单一线程池 线程死了马上又会创建  始终保持拥有一个线程
//         newSingleThreadExecutor();
         
         //循环执行5个任务  但同时只有3个任务被执行  因为线程池中只有3条线程
          
		  //定時
         schedulePool();
        
	}
	
	
	private static void schedulePool(){
		 
        //用线程池启动定时器   指定线程数为3  则可以同时执行3个任务
        final ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(3);
//        final ScheduledExecutorService schedulePool=Executors.newSingleThreadScheduledExecutor();
        //执行任务一
        for(int i=1;i<=5;i++){
        	final int task=i;
        	schedulePool.schedule(new Runnable() {
    			@Override
    			public void run() {
    				for(int j=1;j<=2;j++){
    					try {
    						Thread.currentThread().sleep(500);
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
    					System.out.println(Thread.currentThread().getName()+" is looping of "+j+" of task "+task);
    				}
  
    			}
    		}, 5, TimeUnit.SECONDS);
//			schedulePool.shutdown();//关闭则不能schedule task
        }
        
        //延迟initialDelay 以后每隔period执行command
//        schedulePool.scheduleAtFixedRate(command, initialDelay, period, unit);
	}
	
	private static void newFixedThreadPool(int size){
	       ExecutorService threadPool = Executors.newFixedThreadPool(size);	//包含3条线程
	       doTask(threadPool);
	}
	private static void newCachedThreadPool(){
	       ExecutorService threadPool = Executors.newCachedThreadPool();
	       doTask(threadPool);
	}
	private static void newSingleThreadExecutor(){
	       ExecutorService threadPool = Executors.newSingleThreadExecutor();
	       doTask(threadPool);
	}
	private static void doTask(ExecutorService threadPool){
	    for(int i=1;i<=5;i++){
       	 final int  task=i;
        threadPool.execute(new Runnable() {
			
			@Override
			public void run() {
               for(int j=1;j<=2;j++){
               	try {
						Thread.currentThread().sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
               	System.out.println(Thread.currentThread().getName()+" is looping of "+j+" of task "+task);
               }
			}
		});
        }
	  //当线程池中没有任务了才关闭
//        threadPool.shutdown();
        //不管还有没有任务没执行完  立即关闭
//        threadPool.shutdownNow();
	}

}
