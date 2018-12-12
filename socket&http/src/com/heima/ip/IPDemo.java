package com.heima.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 张全
 */
public class IPDemo {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws Exception {
		/*1.获取本机IP*/
//		 InetAddress inetAddress = InetAddress.getLocalHost();
		InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
		/*获取主机名*/
		String ip = inetAddress.getHostName();
		/*获取IP地址*/
		String host = inetAddress.getHostAddress();
		/*检测2秒是否可连接*/
		boolean reachable = inetAddress.isReachable(2 * 1000);
		
		System.out.println(ip);
		System.out.println(host);
		System.out.println(reachable);

	}

}
