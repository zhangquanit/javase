package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

	private Map<String, Object> cache = new HashMap<String, Object>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
  /**
   * 读上读锁,写数据上写锁
   * 读锁可以多个线程同时进行,因为读数据不会产生混乱,写数据只有一个线程进行,因为写数据只能同时由一个线程进行。不然多个线程
   * 操作同一数据会产生数据混乱.
   * 
   * 读数据上读锁,当发现数据会空，则上写锁,写完数据后再解写锁,重新上读锁。
   */
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public  Object getData(String key){
		rwl.readLock().lock(); //首先上读锁
		Object value = null;
		try{
			value = cache.get(key);
			if(value == null){
				rwl.readLock().unlock();  //如果没有数据则解读锁  上写锁
				rwl.writeLock().lock();  //上写锁
				try{
					if(value==null){ //再次判断是否为null,避免重复查询
						value = "aaaa";//实际失去queryDB();
					}
				}finally{
					rwl.writeLock().unlock(); //加finally保证解写锁
				}
				rwl.readLock().lock(); //重新上读锁
			}
		}finally{
			rwl.readLock().unlock();
		}
		return value;
	}
}
