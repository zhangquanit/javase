package com.thread.old;

import com.thread.old.MultiThreadShareData.ShareData2.MyRunnable;
import com.thread.old.MultiThreadShareData.ShareData2.MyRunnable2;


/**
  
       多个线程访问共享对象和数据的方式
   3种方式:都是同过Runnable接口完成
     
 */
public class MultiThreadShareData {
	static  ShareData2 shareData2=new ShareData2();
	public static void main(String[] args) {
        //1.同一个Runnable，不同Thread
//		test1();
       
		//2.不同的匿名Runnable操作同一个对象
//		test2();
		
		//3.不同的Runnable对象  共享数据或变量作为参数传入到不同的Runnable对象中
//		test3();
	}
	
	public static void test1(){
		//1.同一个Runnable  
		ShareData shareData=new ShareData();
		new Thread(shareData).start();
		new Thread(shareData).start();
	}
	public static void test2(){
		final ShareData2 shareData2=new ShareData2();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				shareData2.decrease();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				shareData2.decrease();			
			}
		}).start();
		
	}
	public static void test3(){
		 ShareData2 shareData22 = new ShareData2(); //也可以是成员变量
		  MyRunnable runnable = new MyRunnable(shareData22);
		  MyRunnable2 runnable2 = new MyRunnable2(shareData22);
		  
		  new Thread(runnable).start();
		  new Thread(runnable2).start();
	}
   
	/**
	 * 实现Runnable接口
	 */
	static class ShareData implements Runnable{
		private int count=5;
		@Override
		public void run() {
           while(count>0){		
        		   System.out.println(count--);
        	   
           }
		}
	}
	
	/**
	 * 方式2  
	 */
	static class ShareData2 {
		private int count=5;
		public void decrease() {
           while(count>0){		
        		   System.out.println(count--);
           }
	}
		
  	/**
  	 * 方式3	
  	 */
	static class MyRunnable implements Runnable{
		private ShareData2 shareData2;
		public MyRunnable(ShareData2 shareData2){
			this.shareData2=shareData2;
		}
		@Override
		public void run() {
              shareData2.decrease();	
			
		}
	}
	static class MyRunnable2 implements Runnable{
		private ShareData2 shareData2;
		public MyRunnable2(ShareData2 shareData2){
			this.shareData2=shareData2;
		}
		@Override
		public void run() {
              shareData2.decrease();	
			
		}
	}
}
}
