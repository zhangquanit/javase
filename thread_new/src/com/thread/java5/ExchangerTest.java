package com.thread.java5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
   用于实现两个人之间的数据交换,每个人在完成一定的事务后想与对方交换数据
   第一个先拿出数据的人将一直等待第二个人拿着数据到来时，才能彼此交换数据
   
 V  exchange(V x) 
          等待另一个线程到达此交换点（除非当前线程被中断），然后将给定的对象传送给该线程，并接收该线程的对象。 
 V exchange(V x, long timeout, TimeUnit unit) 
          等待另一个线程到达此交换点（除非当前线程被中断，或者超出了指定的等待时间），然后将给定的对象传送给该线程，同时接收该线程的对象。 

 */
public class ExchangerTest {

	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "zhangquan";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}
			}	
		});
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "jack";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}				
			}	
		});		
	}

}
