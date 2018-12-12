package com.cn.thread;
/**
 * 同步：就是指多个操作在同一时间段内只能有一个线程进行，其他线程要等待该线程运行完后才可以继续运行
 * 要解决资源共享的同步操作问题，可以使用同步代码块及同步代码方法两种方式实现。
 * 1.同步代码块
 *    synchronized(同步对象){
 *         需要同步的代码
 *        }
 *2.同步方法
 *  public synchronized void fun(){
 *     
 *     }
 */
class Run implements Runnable{
 int ticket=5;
	@Override
	public void run() {
		 synchronized (this) {
		 while(ticket>0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				System.out.println("售票数:"+ticket--);
			}
		 }
		
	}
	
}
public class SynchronizedTest {
	public static void main(String[] args) {
		 Run  run=new Run();
	     new Thread(run).start();
	     new Thread(run).start();
	     new Thread(run).start();
	}
     
}
