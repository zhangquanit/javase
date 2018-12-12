package com.cn.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/** 
 * 
 * @author terry
 * @time 2012-3-8 上午10:42:16
 */
public class UDPClient {
  public static void main(String[] args)throws Exception {
	DatagramSocket socket=new DatagramSocket(4567);
	
	/*将数据封装成数据包 */
	InetAddress address=InetAddress.getByName("192.168.56.1");
	String string="hello";
	byte[] data=string.getBytes();
	 //每一个数据包都应该指定IP,端口 ，这样才知道发送到什么服务器端口上
	DatagramPacket packet=new DatagramPacket(data, data.length, address,4567);
	/*发送数据包*/
	socket.send(packet);
}
}
