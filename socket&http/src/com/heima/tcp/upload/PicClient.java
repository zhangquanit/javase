package com.heima.tcp.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
  
  张全
 */
public class PicClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.1.107", 10003);
		FileInputStream inputStream = new FileInputStream(new File("D:\\test","zhangquan.jpg"));
		OutputStream out = socket.getOutputStream();
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=inputStream.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		socket.shutdownOutput();
		
		InputStream input = socket.getInputStream();
		byte[] response=new byte[1024];
		input.read(response);
		System.out.println(new String(response));
		
		socket.close();
		
	}

}
