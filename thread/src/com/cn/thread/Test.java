package com.cn.thread;

import java.util.Random;

/**
 * 
 * @author terry
 * @time 2012-5-10 ����8:50:36
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Business business = new Business();
         new Thread(new Runnable() {
			
			@Override
			public void run() {
              while(true){
            	  try {
					business.setData(new Random().nextInt());
				} catch (Exception e) {
					e.printStackTrace();
				}
              }
			}
		}).start();
         
         new Thread(new Runnable() {
 			
			@Override
			public void run() {
				Object data;
				try {
					data = business.getData();
					System.out.println(Thread.currentThread().getName()+" has get data->"+data);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}).start();
	
	}
static class Business{
	public Object data;
	
	public synchronized void setData(Object data)throws Exception{
		System.out.println(Thread.currentThread().getName()+" is ready to put data->"+data);
		Thread.currentThread().sleep(500);
		this.data=data;
		System.out.println(Thread.currentThread().getName()+" has put data->"+data);
	}
	public synchronized Object getData()throws Exception{
		System.out.println(Thread.currentThread().getName()+" is ready to get data->"+this.data);
		Thread.currentThread().sleep(500);
		return data;
	}
}
}
