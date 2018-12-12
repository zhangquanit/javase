package com.thread.java5;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
   读写锁
   要实现互斥的代码应放在同一个类中,即使用同一个同步监视对象。上锁的目的就是为了保证数据的完整性。
Lock和ReadWriteLock的区别：
	Lock锁住的代码不管是读或写都只有一个线程才能执行,ReadWriteLock针对读和写提供了不同的锁,
	如果对同一数据要进行读和写的操作，如果使用synchroize关键字则针对读的操作会减低性能,
	然而读是不会产生数据混乱的,所以使用了读写锁后,即不会产生数据的混乱,又提高了性能。
	
分析：如果使用的是读写锁
1.写数据时只能由一条线程去写 不会产生数据混乱
Thread-5 be ready to write data->1683
Thread-5 have write data: 1683
2.读数据时可以多条线程同时去读  因为这个数据都是一样的 不会混乱 与synchronzed相比 效率更高
Thread-4 be ready to read data->1683
Thread-2 be ready to read data->1683
Thread-0 be ready to read data->1683
Thread-4 have read data :1683
Thread-2 have read data :1683
Thread-0 have read data :1683

Thread-3 be ready to write data->7611
Thread-3 have write data: 7611
Thread-1 be ready to write data->6734
Thread-1 have write data: 6734

  如果使用的是Lock，则不管是读或写都只有一个线程才能执行
Thread-0 be ready to read data->7288
Thread-0 have read data :7288

Thread-1 be ready to write data->6394
Thread-1 have write data: 6394

Thread-1 be ready to write data->4958
Thread-1 have write data: 4958

Thread-0 be ready to read data->7867
Thread-0 have read data :7867

 API实例

 class CachedData {
   Object data;
   volatile boolean cacheValid;
   ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
  //  假如多个线程同时操纵processCachedData();
   void processCachedData() {
     rwl.readLock().lock();
     if (!cacheValid) {
        // Must release read lock before acquiring write lock
        rwl.readLock().unlock();
        rwl.writeLock().lock();
        //重新检查 因为如果有多个线程执行到这里,当第一个线程上了写锁后 其他线程不能进入 当第
        一个线程执行完XX操作后 释放写锁上读锁   刚才其他等待的线程也先上写锁 然后也去执行XX操作 
        这样就造成了重复XX操作， 所以要重新检查一下cacheValid  以免重复操作
        // Recheck state because another thread might have acquired
        //   write lock and changed state before we did. 重新检查状态 因为有可能之前已经有其他线程获得过了写锁  改变了数据
        if (!cacheValid) { 
          data = ...
          cacheValid = true;
        }
            锁降级 :先获取写入锁，然后获取读取锁，最后释放写入锁。但是，从读取锁升级到写入锁是不可能的
        rwl.readLock().lock(); 
        rwl.writeLock().unlock(); // Unlock write, still hold read
     }

     use(data);
     rwl.readLock().unlock();
   }
 }
 在使用某些种类的 Collection 时，可以使用 ReentrantReadWriteLock 来提高并发性。通常，在预期 collection 很大，
 读取者线程访问它的次数多于写入者线程，并且 entail 操作的开销高于同步开销时，这很值得一试。例如，
 以下是一个使用 TreeMap 的类，预期它很大，并且能被同时访问。 
class RWDictionary {
    private final Map<String, Data> m = new TreeMap<String, Data>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Data get(String key) {
        r.lock();
        try { return m.get(key); }
        finally { r.unlock(); }
    }
    public String[] allKeys() {
        r.lock();
        try { return m.keySet().toArray(); }
        finally { r.unlock(); }
    }
    public Data put(String key, Data value) {
        w.lock();
        try { return m.put(key, value); }
        finally { w.unlock(); }
    }
    public void clear() {
        w.lock();
        try { m.clear(); }
        finally { w.unlock(); }
    }
 }
 */
public class ReadAndWriteLock {

	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		//开启3个线程读数据  3个线程写数据
//		for(int i=1;i<=3;i++) 
//		{
			new Thread(){  
				public void run(){
					while(true){
						q3.get();						
					}
				}
				
			}.start();

			new Thread(){ 
				public void run(){
					while(true){
						q3.put(new Random().nextInt(10000));
					}
				}			
				
			}.start();
//		}
		
	}
}



class Queue3{
	private Object data = null;//共享数据,只能有一个线程能写该数据，但可以有多个线程同时读该数据
	ReadWriteLock rwl = new ReentrantReadWriteLock(); 
	Lock lock=new ReentrantLock();
	
	public void get(){
//		rwl.readLock().lock(); //读数据上读锁
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to read data->"+data);
			Thread.sleep((long)(Math.random()*1000));
			System.out.println(Thread.currentThread().getName() + " have read data :" + data);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
//			rwl.readLock().unlock();
			lock.unlock();
		}
	}
	
	public void put(Object data){
        
//		rwl.writeLock().lock(); //写数据上写锁
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to write data->"+data);					
			Thread.sleep((long)(Math.random()*1000));
			this.data = data;		
			System.out.println(Thread.currentThread().getName() + " have write data: " + data);					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
//			rwl.writeLock().unlock();
			lock.unlock();
		}
		
	
	}
}
