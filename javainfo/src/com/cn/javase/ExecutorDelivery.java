package com.cn.javase;

import java.util.concurrent.Executor;
 /**
   
  @author zhangquanit
 */
public class ExecutorDelivery {
	public static void main(String[] args) {
		new ExecutorDelivery().test();
	}
	public void test(){
		MyHandler myHandler = new MyHandler();
		MyExecutor myExecutor = new MyExecutor(myHandler);
		myExecutor.execute(new MyRunnable());
	}
	public class MyExecutor implements Executor{
		private MyHandler handler;
        public MyExecutor(MyHandler handler){
        	this.handler=handler;
        }
		@Override
		public void execute(Runnable command) {
			System.out.println("execute");
			handler.post(command);	
		}
		
	}
	public class MyHandler {
		public void post(Runnable run){
			System.out.println("post");
			run.run();
		}
	}
	public class MyRunnable implements Runnable{

		@Override
		public void run() {
			System.out.println("run");
		}
		
	}

}
