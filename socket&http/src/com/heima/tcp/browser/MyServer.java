package com.heima.tcp.browser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 了解一下浏览器给到底给服务器发送了什么内容：
 * 客户端：浏览器
 * 服务器端：自定义的服务器
 * 浏览器发送的数据是：
   GET / HTTP/1.1     请求行 (请求方式 请求路径 请求协议/版本号)
   Accept: text/html, application/xhtml+xml, 
/* Accept-Language: zh-CN
   User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)
   Accept-Encoding: gzip, deflate
   Host: 192.168.1.105:9091
   Connection: Keep-Alive
 * 浏览器和服务器(比如tomcat)是不同厂商开发的,为了交互数据就必须遵守一定的协议比如http
 * 
 * 
 * 弄清楚了浏览器做的事情,那么我们也可以写一个浏览器一样功能的客户端,按照浏览器发送给服务器端的协议格式发送数据即可
 */
public class MyServer {
   //浏览器输入   http://192.168.1.105:9091
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9091);
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress().getHostAddress()+ "....connected");
		InputStream input = socket.getInputStream();
         byte[] buffer=new byte[1024];//建立一个大小1024的缓冲区
         int len=input.read(buffer);//将数据读取到缓冲区中
         System.out.println(new String(buffer,0,len));
         
         PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
         out.println("<font color='red' size='7'>welcome </font>");
         
         socket.close();
         serverSocket.close();
	}
}
