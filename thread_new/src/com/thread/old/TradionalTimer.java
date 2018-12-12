package com.thread.old;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


/**
  
                                          定时器
  Timer
  TimerTask:一个TimerTask只能被定时操作一次  即如果被Scedule后  就不能再被Schedule
  
  用途：
    1.定时xx秒后执行
    2.延迟XX秒后执行  然后每隔YY秒执行一次
    3.在XX和YY秒间隔执行
    4.在指定时间执行 第2个参数为Date 
       timer.schedule(task, firstTime, period) 比如每天的12点 或者周一到周5的12点去执行  周6,周日不执行
 */
public class TradionalTimer {
	 public static Timer timer;
	 static int count;
	public static void main(String[] args) throws Exception{
		final  Timer timer = new Timer();
		
		 
		TimerTask task=new TimerTask() {
			
			@Override
			public void run() {
				 System.out.println("test");
			}
		};
		
		timer.schedule(task, 500, 1000);
		
		/*
		 * 实现交替执行
		 * 比如2秒执行一个任务 然后4秒执行一个任务
		 * 实现方式一：使用同一Timer
		 * 实现方式二：使用2个timer交替执行
		 */
		
		 //方式1 2秒执行一个task  4秒后再执行一个task  同一个TimerTask的匿名对象
//		class MyTimerTask extends TimerTask{
//			@Override
//			public void run() {
//				count=(count+1)%2;
//				System.out.println("...bombing");
//				timer.schedule(new MyTimerTask(), 2000+2000*count);//2秒和4秒间隔执行
//			}
//		}
//		timer.schedule(new MyTimerTask(), 2*1000);//2秒后执行
		
		
		
		
		  //方式2
//		  timer=new Timer();
//		  timer.schedule(new MyTimerTaskA(), 2*1000);
		  
		  
		  
		  
		  
//		while(true){
//			Thread.sleep(1*1000);
//			System.out.println(Calendar.getInstance().get(Calendar.SECOND));//打印秒数
//		}
		
	}
	static class MyTimerTaskB extends TimerTask{

			@Override
			public void run() {
				System.out.println("..bombing");
				timer.schedule(new MyTimerTaskA(), 2*1000);//2秒后执行TaskA
			}
		}
	static  class MyTimerTaskA extends TimerTask{

			@Override
			public void run() {
				System.out.println("..bombing");
				timer.schedule(new MyTimerTaskB(), 4*1000);//4秒后执行TaskB
			}
		}

}
