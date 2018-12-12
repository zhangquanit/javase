package com.cn.nio;

import java.nio.IntBuffer;
 /**
   
  @author 张全
 */
public class IntBufferTest {

	public static void main(String[] args) {
		int capacity=10;
		IntBuffer buffer = IntBuffer.allocate(capacity);
		System.out.println("pos="+buffer.position()+",limit="+buffer.limit()+",capacity="+buffer.capacity());
	}
}
