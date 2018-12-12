package com.thread.old;
 /**
   wait、notify的锁对象必须是同一个
  @author zhangquanit
 */
public class WaitNotifyTest {
	
   public static void main(String[] args) throws InterruptedException {
	 final Business business=new WaitNotifyTest(). new Business();
	  new Thread(new Runnable() {
			
			@Override
			public void run() {
				business.descrease();//锁对象是lock
			}
		 }).start(); 
	  new Thread(new Runnable() {
			
			@Override
			public void run() {
				business.descrease2();//锁对象是this
			}
		 }).start(); 
	   
	  Thread.sleep(2*1000);
	   new Thread(new Runnable() {
		
		@Override
		public void run() {
			business.add(); //锁对象是lock
		}
	 }).start(); 
	  
	   
   }
	public class Business{
		public int num;
		private final Object lock=new Object();
		public void add(){
			synchronized (this) {
				num+=1;
				if(num==1){
					System.out.println(Thread.currentThread().getName()+"--notify");
					notify(); //抛出异常，因为锁对象不是this
//					lock.notify();
				}
			}
		}
		public void descrease(){
			synchronized (lock) {
				if(num==0){
					try {
						
						System.out.println(Thread.currentThread().getName()+"--wait");
//						wait(); //抛出异常，因为锁对象不是this
						lock.wait();
						System.out.println(Thread.currentThread().getName()+"--wait---end");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				--num;
			}
		} 
		
		public void descrease2(){
			synchronized (this) { //锁对象是this
				if(num==0){
					try {
						
						System.out.println(Thread.currentThread().getName()+"--wait");
//						wait(); //抛出异常，因为锁对象不是this
						this.wait();
						System.out.println(Thread.currentThread().getName()+"--wait---end");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				--num;
			}
		} 
	}

}
