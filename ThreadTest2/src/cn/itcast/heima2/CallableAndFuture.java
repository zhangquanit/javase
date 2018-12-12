package cn.itcast.heima2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**    线程执行任务,并可以得到任务的返回结果
 * 普通的线程没有返回结果,使用线程池的submit方法可以得到返回值。其实是一个Futrue对象
 */
public class CallableAndFuture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService threadPool =  Executors.newSingleThreadExecutor();
		Future<String> future =  //Future的类型由Callable决定
			threadPool.submit(
				new Callable<String>() { //返回值为String类型
					public String call() throws Exception {
						Thread.sleep(2000);
						return "hello"; //返回值   交给Future
					};
				}
		);
		System.out.println("等待结果");
		try {
			System.out.println("拿到结果：" + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**完成的服务*/
		ExecutorService threadPool2 =  Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
		for(int i=1;i<=10;i++){
			final int seq = i;
			completionService.submit(new Callable<Integer>() {//CompletionService提交一组Callable任务。
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return seq;
				}
			});
		}
		//因为线程池中有10个线程,而且提交了10个任务,则可以得到10个返回结果
		for(int i=0;i<10;i++){
			try {
				System.out.println(
						completionService.take().get()); //返回结果
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}
		}
	}
	

}
