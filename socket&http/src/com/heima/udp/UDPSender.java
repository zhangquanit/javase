package com.heima.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 张全 UDP的发送端： 1.通过udp的socket对象,建立socket服务 2.明确数据，并将数据封装成数据包
 * 3.使用socket服务的发送动作将数据包发送出去 4.关闭资源
 */
public class UDPSender {

	public static void main(String[] args) throws IOException {
		System.out.println("发送端  启动");

		// 1.建立udp socket服务
		// DatagramSocket ds = new DatagramSocket();
		DatagramSocket ds = new DatagramSocket(8888);// 如果指定了端口
														// 则接收端接收到的数据包中就能取得该端口
		// 2.封装数据包 关于DatagramPacket的创建 只要构造函数中有XXAddress的都表示是发送数据包 其他是接收的数据包
		String data = "hello world";
		byte[] buffrer = data.getBytes();
		DatagramPacket dataPacket = new DatagramPacket(buffrer, 0,
				buffrer.length, InetAddress.getByName("192.168.1.106"), 10000);

		// 3.发送数据包
		ds.send(dataPacket);
		// 4.关闭资源
		ds.close();

		System.out.println("发送端  结束");
	}

}
