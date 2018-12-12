package com.cn.socket.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class TCPClient {
  public static void main(String[] args)throws Exception {
	  /*指定监听的主机名和端口号*/
	Socket socket=new Socket("192.168.56.1",5678);
	File file=new File("D:"+File.separator+"terry"+File.separator+"zhangquan.txt");
	FileInputStream inputStream=new FileInputStream(file);
	  /*向服务器端发送数据*/
	FileOutputStream outputStream=(FileOutputStream) socket.getOutputStream();
	byte[] buffer=new byte[1024];
	int len=0;
	while((len=inputStream.read(buffer))!=-1){
		outputStream.write(buffer, 0, len);
	}
	inputStream.close();
	outputStream.flush();
	
}
  
}
