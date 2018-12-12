package cn.itcast.heima2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	/**
	 * 线程池
	 */
	public static void main(String[] args) {
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);//固定线程池
		//ExecutorService threadPool = Executors.newCachedThreadPool(); //缓存线程池 线程池中的个数不一定,如果任务过多则自动增加线程,如果任务过少,则自动收回一些线程
		ExecutorService threadPool = Executors.newSingleThreadExecutor();//单一线程池,只有一个线程
		for(int i=1;i<=10;i++){ //开启10个任务
			final int task = i;
			threadPool.execute(new Runnable(){ 
				@Override
				public void run() {
					for(int j=1;j<=10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
					
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for  task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed! ");
		//threadPool.shutdownNow(); //关闭线程池
		
		/**调度线程池*/
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
				new Runnable(){
					@Override
				public void run() {
					System.out.println("bombing!");
					
				}},
				6,
				2,
				TimeUnit.SECONDS);
	}

}
