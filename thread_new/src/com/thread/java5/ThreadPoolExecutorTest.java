package com.thread.java5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 /**
   
  @author zhangquanit
 */
public class ThreadPoolExecutorTest {
	 public static void main(String[] args) {  
		 /**
		  * 从执行结果可以看出，当线程池中线程的数目大于5时，便将任务放入任务缓存队列里面，
		  * 当任务缓存队列满了之后，便创建新的线程。
		  * 如果上面程序中，将for循环中改成执行20个任务，就会抛出任务拒绝异常了。
		  * 不过在java doc中，并不提倡我们直接使用ThreadPoolExecutor，而是使用Executors类中提供的几个静态方法来创建线程池：
			Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
			Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
			Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池
		  */
         ThreadPoolExecutor executor = new ThreadPoolExecutor(
        		 5, 10, 
        		 200, TimeUnit.MILLISECONDS,
                 new ArrayBlockingQueue<Runnable>(5)
        		 );
          
         for(int i=1;i<=15;i++){
        	 //创建task
             MyTask myTask = new ThreadPoolExecutorTest().new MyTask(i);
             //执行task
             executor.execute(myTask);
             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
         }
         executor.shutdown();
     }
	 class MyTask implements Runnable {
		    private int taskNum;
		     
		    public MyTask(int num) {
		        this.taskNum = num;
		    }
		     
		    @Override
		    public void run() {
		        System.out.println("正在执行task "+taskNum);
		        try {
		            Thread.currentThread().sleep(4000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        System.out.println("task "+taskNum+"执行完毕");
		    }
		}
}
