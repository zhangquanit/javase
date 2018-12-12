package com.heima.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
  
  张全
  
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//1.建立TCP服务端的socket服务 必须监听一个端口(和客户端绑定的端口号一致)
		ServerSocket serverSocket = new ServerSocket(10000);//监听10000端口 端口对应进程
		//2.得到连接的客户端对象
		Socket socket = serverSocket.accept();//这是一个阻塞的方法  直到有客户端连接
		//3.使用客户端对象读取流的方法
		InputStream input = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line=null;
		while((line=reader.readLine())!=null){
			System.out.println(line);
			//给客户端发送数据
			OutputStream out = socket.getOutputStream();
			out.write("从服务端返回的数据\r\n".getBytes());
		}
		
		//4.关闭资源
		socket.close();//关闭当前连接
		serverSocket.close();//关闭服务
		
	}

}
