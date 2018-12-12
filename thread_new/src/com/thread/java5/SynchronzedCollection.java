package com.thread.java5;

/**
  
 并发集合
  
  在java5并发库之前获得同步集合：
HashMap<String, String> map=new HashMap<String, String> ();//普通的HashMap
Map<String, String> synchronizedMap = Collections.synchronizedMap(map);//返回同步的HashMap
  Collections.synchronizedMap(map)方法其实就是将map包装了一下,将map的相关方法加上synchronzed。

  
 */
public class SynchronzedCollection {

	
	public static void main(String[] args) {

	}

}
