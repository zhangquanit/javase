package com.heima.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 张全
 */
public class Receiver implements Runnable {
	private DatagramSocket ds;

	public Receiver(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		try{
		while (true) {
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, 0, data.length);
			ds.receive(packet);

			String text = new String(packet.getData(), 0, packet.getLength());
			String ip = packet.getAddress().getHostAddress();
			System.out.println( ip+ ":"+ packet.getPort() + "......."+ text);
			if("886".equals(text)){
				System.out.println(ip+"离开聊天室");
			}
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
