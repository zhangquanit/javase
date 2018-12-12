package com.cn.thread;

public class MyThread implements Runnable {
  private String name;
  private int ticket=5;
     public MyThread(){}
	 public MyThread(String name){
		 this.name=name;
	 }
	@Override
	public void run() {
//	    for(int i=0;i<5;i++){
//	    	System.out.println("线程"+name+":运行了"+i);
//	    }
        while(ticket>0){
        	
        System.out.println("卖票"+ticket--);
        }
	}

}
