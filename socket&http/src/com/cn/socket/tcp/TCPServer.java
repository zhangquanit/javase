package com.cn.socket.tcp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class TCPServer {
 public static void main(String[] args)throws Exception {
	
	/*服务端监听端口*/
	ServerSocket serverSocket=new ServerSocket(5678);
	while(true){
	/*得到客户端socket*/
	Socket socket=serverSocket.accept();
	/*得到客户端传入的数据*/
	InputStream inputStream=socket.getInputStream();
	/*将客户端数据读取到内存中 */
	ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
	int len=0;
	byte[] buffer=new byte[1024];
	while((len=inputStream.read(buffer))!=-1){
		outputStream.write(buffer, 0, len);
	}
	outputStream.flush();
	inputStream.close();
	socket.close();
	}
}
}
