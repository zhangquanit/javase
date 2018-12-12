package com.heima.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender implements Runnable {
	private static final String IP = "192.168.1.255";//则广播给192.168.1整个网段的主机
	private DatagramSocket ds;

	public Sender(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		try{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;
		while ((line = reader.readLine()) != null) {

			byte[] buffer = line.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(buffer, 0,
					buffer.length, InetAddress.getByName(IP), 10000);
			ds.send(datagramPacket);
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
