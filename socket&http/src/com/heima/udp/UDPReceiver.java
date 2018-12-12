package com.heima.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
  
  张全
  UDP接收方:
  1.建立udp socket服务
  2.定义一个数据包,用来存储接收到的数据
              为什么要这样做呢？因为收到的数据有很多,为了方便于获取数据
  3.接收数据
  4.获取数据包中的指定信息
  5.关闭资源
 */
public class UDPReceiver {

	public static void main(String[] args) throws IOException {
		 System.out.println("接收端  启动");
		//1.建立udp socket服务
	     DatagramSocket ds = new DatagramSocket(10000);//必须指定端口  和发送端发送的数据包中的端口一致 
	     
	     //2.定义一个数据包,用来存储接收到的数据
	     byte[] data=new byte[1024];
	     DatagramPacket dataPacket = new DatagramPacket(data, data.length);
	     //3.接收数据
	     ds.receive(dataPacket); //这是一个阻塞的方法
	     //4.获取数据包中的指定信息
	     //4.1 数据主体信息
	    System.out.println(new String(dataPacket.getData(),0,dataPacket.getLength()));
	    //4.2 数据的来源地址+端口
	    System.out.println(dataPacket.getAddress().getHostAddress()+":"+dataPacket.getPort());
	    // 5.关闭资源
	     ds.close();
	     
	     System.out.println("接收端  结束");
	}

}
