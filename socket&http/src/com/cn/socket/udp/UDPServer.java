package com.cn.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/** 
 * 
 * @author terry
 * @time 2012-3-8 上午10:42:26
 */
public class UDPServer {
  public static void main(String[] args)throws Exception {
	  
	  
	DatagramSocket socket=new DatagramSocket(4567);
	
	/*创建空的数据包  用来接收客户端发送的数据*/
	byte[] data=new byte[1024];
	DatagramPacket packet=new DatagramPacket(data, data.length);
	/*接收数据包*/
	socket.receive(packet);
	
	String result=new String(packet.getData(),packet.getOffset(),packet.getLength());
	System.out.println("result......>"+result);
	
}
}
