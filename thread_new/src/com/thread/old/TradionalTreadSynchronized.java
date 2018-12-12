package com.thread.old;

/**
 *  
 * 线程的同步和互斥
 *  线程安全：多个线程同时操作同一个对象或同一份数据 就容易产生问题 多个线程同时执行
 *           抢占资源，抢占到资源的线程就会打断其他正在执行的线程,这样就容易造成数据混乱。
 *           所以要保证原子性即一条线程在操作某数据的时候其他线程不能操作该数据。
 * 线程的同步是为了防止多个线程访问一个数据对象时(比如某对象的成员变量),对数据造成破坏。
 * 
 * 为了保护某段同一时间只能让一条线程执行的代码或方法 ， 就可以使用Synchronzed
 * 
 * 同步代码块：
 *   synchrinzed(Object obj){ //同步对象obj 相当于钥匙 这个钥匙只能是同一个 不然起不到同步的作用,一般可以使用
 *                            this即 当前对象做为同步对象
 *            }
 * 同步方法：
 * 
 * 
 * 
 * 备注：多个线程同时调用同一对象的不同方法,如果这些方法都没有加同步,则不同线程谁能抢占CPU资源谁就能执行,
 * 导致的后果是：如果该对象的不同方法在操作同一成员变量,就很可能线程A在方法A中操作该变量时 由于线程B抢占到了CPU资源 线程B
 * 在方法B中改变了该成员变量的值,这时候线程A虽然抢占到了CPU资源继续执行方法A，但是成员变量已经将发生了改变，
 * 这样就会导致数据混乱。例如银行支付和转账。
 * 
 * 使用同步 锁对象是重点。只有使用同一个锁对象的同步方法才能达到同步的目的，比如两个线程同时调用同一对象的2个
 * 不同的同步方法,如果使用同一个锁对象则只要某一个方法在执行，则其他一个线程检测到该方法使用了同一个锁  则会等待。
 * 
 * }
 */
public class TradionalTreadSynchronized {
	public static void main(String[] args) {

		new TradionalTreadSynchronized().init();
	}

	public void init() {
		final OutPut out = new OutPut();//创建对象
		  //线程1
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.currentThread().sleep((long)Math.random()*2 * 100);
						// out.print("terry");
//						out.printSynchonzed("terry_zhang");
						out.printSynMethod("terry_zhang");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		//线程2
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.currentThread().sleep((long)Math.random()*2 * 100);
						// out.print("zhangquan");
//						out.printSynchonzed("zhangshiquan");
						out.printSynchonzed2("zhangshiquan");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// 2条线程同时操作一个对象的不同方法
		thread.start();
		thread2.start();

	}
}

class OutPut {
	//
	public void print(String name) {
		int len = name.length();

		for (int i = 0; i < len; i++) {
			System.out.print(name.charAt(i));
		}

		System.out.println();
	}

	// 1.1同步代码块 使用同一个同步对象
	Object lock = new Object();// 创建一把锁

	public void printSynchonzed(String name) {
		int len = name.length();
		// 将容易产生混乱的代码 同步
		synchronized (lock) { // 不能使用name作为同步对象 因为如果传入的name值不同 则相当于钥匙不同 达不到同步目的
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
		}

		System.out.println();
	}

	// 1.2同步代码块 使用this当前对象作为同步对象
	public void printSynchonzed2(String name) {
		int len = name.length();
		// 将容易产生混乱的代码 同步
		synchronized (this) { // 不能使用name作为同步对象 因为如果传入的name值不同 则相当于钥匙不同 达不到同步目的
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
		}

		System.out.println();
	}

	/*
	 *  2.1 同步方法 同步对象为this即当前对象
	 *     synchronized(this){
	 *      
	 *           }
	 */
	public synchronized void printSynMethod(String name) {
		int len = name.length();
		for (int i = 0; i < len; i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}

	/*
	 *  2.2 静态方法的同步 同步对象为类字节即类.class  因为静态方法只要类存在就存在了
	 *      synchronized(OutPut.class){
	 *      
	 *           }
	 *   所以就不能和  使用this同步对象的代码块或方法  达到同步 
	 */
	public static synchronized void printSynMethod2(String name) {
		int len = name.length();
		for (int i = 0; i < len; i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}

}
