package com.thread.java5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
  Condition

 */
public class ConditionCommunation {

	public static void main(String[] args) {
		
	final ConditionTest conditionTest=new ConditionTest();

			new Thread(new Runnable() {
				@Override
				public void run() {
					 for(int i=1;i<=0;i++){
				      conditionTest.sub(i);	
				    
					 }
				}
			}).start();
		
		  
		
      //主线程
	    for(int i=1;i<=10;i++){
	    	
	    	   conditionTest.main(i);
	    	  
	    }

	}
	
	
	static class ConditionTest{
		private boolean shouldSub=true;
		
		  //1.线程的互斥
//			public synchronized void sub(int i){
//			for(int j=1;j<=10;j++){
//				System.out.println("sub is looping at sequence:"+i+" of "+j);
//			}
//		}
//		public synchronized void main(int i){
//			for(int j=1;j<=10;j++){
//				System.out.println(" main  is looping at sequence:"+i+" of "+j);	
//			}
//		}
		
		 //2.线程的通信 wait和notify

//		public synchronized void sub(int i){
//			while(!shouldSub){
//				 try {
//					this.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			for(int j=1;j<=10;j++){
//			System.out.println("sub is looping at sequence:"+i+" of "+j);
//			}
//			shouldSub=false;
//			this.notify();
//		}
//		public synchronized void main(int i){
//			while(shouldSub){
//				 try {
//					this.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			for(int j=1;j<=10;j++){
//			System.out.println(" main  is looping at sequence:"+i+" of "+j);	
//			}
//			 this.notify();
//			 shouldSub=true;
//		}
		
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
	  public  void sub(int i){
		  lock.lock();
		  try{
			  while(!shouldSub){
				  try {
					condition.await();//等待  注意不要使用wait 这是Object类中的方法
				} catch (Exception e) {
					e.printStackTrace();
				}
			  }
				for(int j=1;j<=10;j++){
					System.out.println("sub thread sequence of " + j + ",loop of " + i);
				}
			  shouldSub = false;
			  condition.signal();//唤醒
		  }finally{
			  lock.unlock();
		  }
	  }
	  
	  public  void main(int i){
		  lock.lock();
		  try{
			 while(shouldSub){
			  		try {
						condition.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
			  	}
				for(int j=1;j<=10;j++){
					System.out.println("main thread sequence of " + j + ",loop of " + i);
				}
				shouldSub = true;
				condition.signal();
	  }finally{
		  lock.unlock();
	  }
  }
	}

}
