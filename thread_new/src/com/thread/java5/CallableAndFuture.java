package com.thread.java5;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池 execute(runnable) 无返回值 submit(callable);有返回值的 这个回调也是阻塞的 直到回调完成
 */
public class CallableAndFuture {
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		final int taskCount = 5;
		ThreadPoolExecutor threadPool2 = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(taskCount);

		CompletionService<Integer> completionService = new ExecutorCompletionService<>(
				threadPool2);
		for (int i = 1; i <= taskCount; i++) {
			final int task = i;
			Future<Integer> future = completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					// 执行想要的操作
					long sleepTime = new Random().nextInt(10);
//					Thread.currentThread().sleep(task * 1000);
					StringBuffer stringBuffer = new StringBuffer();
					for(int j=0;j<sleepTime*3000000;j++){
						stringBuffer.append("j+"+j);
					}
					System.out.println("task->" + task + "执行完了");
					return task;
				}
			});
			System.out.println("future.get="+future.get());
		}

		// 取出10个任务的返回结果 结果是没有顺序的 先执行完的先返回
		for (int i = 1; i <= taskCount; i++) {
			System.out.println("for-----i=" + i);
			try {
				Integer value = completionService.take().get();
				System.out.println("value=" + value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
