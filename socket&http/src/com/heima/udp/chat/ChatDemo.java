package com.heima.udp.chat;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
  
  张全
  完成一个多线程的群聊程序
  一个线程发送数据  一个线程接收数据
  一般一个网段可以使用的主机IP为192.168.1.1——192.168.1.254
  192.168.1.0 表示192.168.1这个网段 
  192.168.1.255  255表示192.168.1这个网段的广播    可以发送给192.168.1整个网段的主机即1-254,因此往192.168.1.255发送信息
                         则192.168.1整个网段的主机都可以接收到。
 */
public class ChatDemo {
	public static void main(String[] args) throws SocketException {
		DatagramSocket sender = new DatagramSocket();
		DatagramSocket receiver = new DatagramSocket(10000);
		Thread thread1=new Thread(new Sender(sender));
		Thread thread2=new Thread(new Receiver(receiver));
		thread1.start();
		thread2.start();
		
	}

}
