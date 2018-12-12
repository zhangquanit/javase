package com.cn.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class PipedStream {

	/**
	 * 线程通信流(管道流)
	 * 管道流的主要作用就是可以进行两个线程间的通讯，分为管道输出流PipedOutputStream和管道输入流PipedInputStream
	 * 如果要想进行管道输出，则必须把输出流连在输入流之上，使用如下方法连接
	 *    public void connect(PipedInputStream snk)throws Exception
	 *  线程1...>输出流...>连接...>输入流..>线程2  
	 */
	public static void main(String[] args) {
	   Receiver receiver=new Receiver();
	   Sender sender=new Sender();
	   
	   try {
		 //把输出流连在输入流之上 有2种方式
		sender.getPos().connect(receiver.getPis());
		
		//方式2  将管道输入流作为参数传给管道输出流
//		new PipedOutputStream(new PipedInputStream());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   //使用多线程树
    new Thread(sender).start();
    new Thread(receiver).start(); 
	}
 
}

class Sender implements Runnable{
	PipedOutputStream pos=null;
  public Sender(){
	  pos=new PipedOutputStream();
  }
	@Override
	public void run() {
	String string="hello terry";
	try {
		pos.write(string.getBytes());
		pos.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	public PipedOutputStream getPos(){
		return this.pos;
	}
}

class Receiver implements Runnable{
   PipedInputStream pis;
   public Receiver(){
	   pis=new PipedInputStream();
   }
	@Override
	public void run() {
	    byte[] buffer=new byte[1024];
	    int len=0;
	    ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
	    try {
			while((len=pis.read(buffer))!=-1){
				outputStream.write(buffer, 0, len)	;
				
			}
			System.out.println("接收的内容为："+new String(outputStream.toByteArray()));
			outputStream.close();
			pis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PipedInputStream getPis(){
		return this.pis;
	}
}



