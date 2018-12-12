package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内的数据共享
 * 主要是针对静态对象。因为多个线程操作的可能是同一个数据,任何一个线程修改数据都会引起数据的变化,导致原来线程取出来的数据不
 * 正确。如果是自己线程内的数据则不存在这种问题。
 * 
 * 应用案例：数据库事务的原子性,转账(转入和转出)
 */
public class ThreadScopeShareData {

	private static int data = 0;
	 /*同步过map保存数据*/
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			int data = threadData.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}
	}
	
	static class B{
		public void get(){
			int data = threadData.get(Thread.currentThread());			
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}		
	}
}

/**
 *                错误的案例
 * 线程1给data赋值后,这时候模块A,模块B还来不及取值,线程2就将data的值改变了，这时候模块A,模块B取出来的
 * 值就是线程2赋值的,而不是线程1赋值的。
 */
/*public class ThreadScopeShareData {

	private static int data = 0;
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					 data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}
	}
	
	static class B{
		public void get(){
		
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}		
	}
}*/

