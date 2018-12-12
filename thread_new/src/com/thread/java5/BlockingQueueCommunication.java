package com.thread.java5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
      利用2个阻塞队列实现2条线程的互斥
 * thread1：queue1.put() queue2.take()
 * thread2：queue2.put() queue1.take();
 * 
 */
public class BlockingQueueCommunication {

	public static void main(String[] args) {
		
		final Business business = new Business();
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
					
						for(int i=1;i<=10;i++){
							business.sub(i);
						}
						
					}
				}
		).start();
		
		for(int i=1;i<=10;i++){
			business.main(i);
		}
		
	}

	 static class Business {
		 
		   //2个阻塞队列实现2条线程的互斥  
		  BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);//固定1个长度
		  BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);//固定1个长度
		  
		  //代码块   在创建对象时执行   比其他调用方法前先执行
		  {  

			  try {
				  System.out.println("xxxxxdfsdsafdsa");
				queue2.put(1);   //提前往queue2中放入数据
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		  
		  public  void sub(int i){
			  	try {
					queue1.put(1);//直到queue1取走数据前处于阻塞
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int j=1;j<=10;j++){
					System.out.println("sub thread sequece of " + j + ",loop of " + i);
				}
				try {
					queue2.take();//如果queue2中没有数据可取 则阻塞
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		  }
		  
		  public  void main(int i){
			  	try {
					queue2.put(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				for(int j=1;j<=10;j++){
					System.out.println("main thread sequece of " + j + ",loop of " + i);
				}
				try {
					queue1.take();//如果queue1中没有数据可取 则阻塞
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		  }
	  }

}
