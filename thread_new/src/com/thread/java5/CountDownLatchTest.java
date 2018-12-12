package com.thread.java5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
  计数器
CountDownLatch(int count) 构造一个用给定计数初始化的 CountDownLatch。
  
countDown() 将计数减1  计数到达0时 释放所有等待的线程
getCount()  返回当前计数。
await()     使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
await(long timeout, TimeUnit unit) 
                   使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。
 
 */
public class CountDownLatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1);//计数为1
		final CountDownLatch cdAnswer = new CountDownLatch(3);//计数为3		
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable(){
					public void run(){
					try {
						System.out.println("线程" + Thread.currentThread().getName() + 
								"正准备接受命令");						
						cdOrder.await(); //cdOrder计数为0前处于等待
						System.out.println("线程" + Thread.currentThread().getName() + 
						"已接受命令");								
						Thread.sleep((long)(Math.random()*10000));	
						System.out.println("线程" + Thread.currentThread().getName() + 
								"回应命令处理结果");						
						cdAnswer.countDown();//将cdAnswer的计数减1   3条线程则减3 初始化为3  则最后为0 唤醒等待的线程						
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}
			};
			service.execute(runnable);
		}		
		
		//在主线程 改变计数器的计数
		try {
			Thread.sleep((long)(Math.random()*10000));
		
			System.out.println("线程" + Thread.currentThread().getName() + 
					"即将发布命令");						
			cdOrder.countDown(); //将cdOrder的计数减1  初始化为1  则变为0  唤醒正在等待的线程
			System.out.println("线程" + Thread.currentThread().getName() + 
			"已发送命令，正在等待结果");	
			cdAnswer.await();//等待cdAnswer 的计数变为0
			System.out.println("线程" + Thread.currentThread().getName() + 
			"已收到所有响应结果");	
		} catch (Exception e) {
			e.printStackTrace();
		}				
		service.shutdown();


	}

}
