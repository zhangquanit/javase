package com.heima.tcp.browser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 张全
 * 客户端：自定义浏览器
 * 服务器端：tomcat服务器
 * 模拟浏览器访问tomcat服务器
 * 
 * 请求头和请求体,或者应答头和应答体之间的分隔方式是：空行
 */
public class MyBrowser {

	/**   模拟浏览器给tomcat发送请求信息  浏览器给服务器发送的信息包括(请求行,请求头字段)
	 * GET / HTTP/1.1 请求行 (请求方式 请求路径 请求协议/版本号) 
	 * Accept: text/html,application/xhtml+xml, 
	 * Accept-Language: zh-CN User-Agent: Mozilla/5.0(compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)
	 * Accept-Encoding: gzip, deflate 
	 * Host: 192.168.1.105:9091 
	 * Connection:Keep-Alive
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket socket = new Socket("192.168.1.105", 8080);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		//请求行
		out.println("GET /myapps/1.html HTTP/1.1");
		//请求消息头
		out.println("Accept:text/html,*/*");
		out.println("Host: 192.168.1.105:8080");
		out.println("Connection: Keep-Alive");
		//请求消息头与实体信息之间以空行来分割
		out.println(); 

		//得到服务器返回的应答消息头信息。（应答行  应答头字段）
		InputStream inputStream = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int len = inputStream.read(buffer);
		System.out.println(new String(buffer, 0, len));

		socket.close();

	}
}
