package cn.itcast.heima2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程锁,可以替换synchronize的功能,更加面向对象
 *
 */
public class LockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LockTest().init();
	}
	
	private void init(){
		final Outputer outputer = new Outputer();
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
					outputer.output("zhangxiaoxiang");
				}
				
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("lihuoming");
				}
				
			}
		}).start();
		
	}

	static class Outputer{
		Lock lock = new ReentrantLock(); //创建一把锁
		public void output(String name){
			int len = name.length();
			lock.lock();   //上锁   则其他线程无法执行下面的代码
			try{
				for(int i=0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}finally{ //使用finally,如果出现异常 保证解锁,让其他线程也可以进入,要不然一旦线程在锁期间出现异常,其他线程就无法执行了。
				lock.unlock(); //解锁
			}
		}
		
		public synchronized void output2(String name){
			int len = name.length();
			for(int i=0;i<len;i++){
					System.out.print(name.charAt(i));
			}
			System.out.println();
		}
		
		public static synchronized void output3(String name){
			int len = name.length();
			for(int i=0;i<len;i++){
					System.out.print(name.charAt(i));
			}
			System.out.println();
		}	
	}
}
