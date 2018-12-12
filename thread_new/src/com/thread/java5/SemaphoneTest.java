package com.thread.java5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
  一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，
      然后再获取该许可。每个 release() 释放一个许可，从而将许可释放给一个正在阻塞的获取者。
 Semaphore(int permits) 
          创建具有给定的许可数和非公平的公平设置的 Semaphore。 只要有空余许可  线程都可随即获取
Semaphore(int permits, boolean fair) 
          创建具有给定的许可数和给定的公平设置的 Semaphore。线程只能按顺序获取许可

 */
public class SemaphoneTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();//按需求创建线程个数
		final  Semaphore sp = new Semaphore(3);//创建一个有3个许可的信号量 只要有空余许可  每个线程都可以获取
//		final Semaphore sp=new Semaphore(3,true);//创建一个有3个许可的信号量 每个线程按顺序获取许可
		for(int i=0;i<10;i++){
			Runnable runnable = new Runnable(){
					public void run(){
					try {
						sp.acquire();//获得许可  在获得许可前处于阻塞状态
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + 
							"进入，当前已有" + (3-sp.availablePermits()) + "个并发");
					try {
						Thread.sleep((long)(Math.random()*10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + 
							"即将离开");					
					sp.release(); //释放许可  将该许可归还给信号量
					//下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
					System.out.println("线程" + Thread.currentThread().getName() + 
							"已离开，当前已有" + (3-sp.availablePermits()) + "个并发");					
				}
			};
			service.execute(runnable);			
		}
	}

}
