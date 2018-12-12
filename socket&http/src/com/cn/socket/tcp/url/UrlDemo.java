package com.cn.socket.tcp.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
  
  张全
  
  URLConnection封装了Socket和Http协议
 */
public class UrlDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//	 Socket socket = new Socket("192.168.1.105", 8080);
//		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//		//请求行
//		out.println("GET /myapps/1.html HTTP/1.1");
//		//请求消息头
//		out.println("Accept:text/html,*/*");
//		out.println("Host: 192.168.1.105:8080");
//		out.println("Connection: Keep-Alive");
//		//请求消息头与实体信息之间以空行来分割
//		out.println(); 
//
//		//得到服务器返回的应答消息头信息。（应答行  应答头字段）
//		InputStream inputStream = socket.getInputStream();
//		byte[] buffer = new byte[1024];
//		int len = inputStream.read(buffer);
//		System.out.println(new String(buffer, 0, len));
//
//		socket.close();
		
		//使用UrlConnection来实现
		  String path="http://192.168.1.105:8080/myapps/1.html";
		 URL url=new URL(path); //对路径解析封装  host  port  path
		  System.out.println(url.getHost());
		  System.out.println(url.getPort());
		  System.out.println(url.getProtocol());//请求协议 
		  System.out.println(url.getFile());//请求路径+请求参数   如果没有请求参数  则和getPath一样
		  System.out.println(url.getPath());//请求路径
		  System.out.println(url.getQuery());//请求参数
		 URLConnection connection = url.openConnection();//建立链接
		 
		 InputStream inputStream = connection.getInputStream();//封装了Socket的输入输出流  自动去除了响应头信息
			byte[] buffer = new byte[1024];
			int len = inputStream.read(buffer);
			System.out.println(new String(buffer, 0, len));
	}

}
