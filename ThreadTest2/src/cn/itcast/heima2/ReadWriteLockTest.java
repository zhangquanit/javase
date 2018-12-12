package cn.itcast.heima2;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *实现读与读之间的 不互斥,读与写之间的互斥。
 *多个线程去读同一数据,不会产生数据的混乱,多个线程同时去读和写同一数据,则会产生数据的混乱
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		for(int i=0;i<3;i++) //开启3个线程去读数据和写数据
		{
			new Thread(){  //读数据
				public void run(){
					while(true){
						q3.get();						
					}
				}
				
			}.start();

			new Thread(){ //写数据
				public void run(){
					while(true){
						q3.put(new Random().nextInt(10000));
					}
				}			
				
			}.start();
		}
		
	}
}

/**
 * 读与读之间不互斥,读与写之间互斥,写与写之间互斥
 * 即实现了：读中有读,写中只有写
 *
 */
class Queue3{
	private Object data = null;//共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
	ReadWriteLock rwl = new ReentrantReadWriteLock(); //一定要使用同一个对象来操作读锁和解锁
	public void get(){
		rwl.readLock().lock(); //读数据用读锁  可以由多个线程来执行
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to read data!");
			Thread.sleep((long)(Math.random()*1000));
			System.out.println(Thread.currentThread().getName() + "have read data :" + data);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.readLock().unlock();
		}
	}
	
	public void put(Object data){
        
		rwl.writeLock().lock(); //放数据用写锁 ,只能由同一个线程去执行
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to write data!");					
			Thread.sleep((long)(Math.random()*1000));
			this.data = data;		
			System.out.println(Thread.currentThread().getName() + " have write data: " + data);					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.writeLock().unlock();
		}
		
	
	}
}
