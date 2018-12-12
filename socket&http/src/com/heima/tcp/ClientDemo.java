package com.heima.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
  
  张全
  1.建立TCP客户端的Socket服务,进行连接的建立
  2.在连接通道中,就有了socket流,该流中既有读取,又有写入
  3.关闭资源
  
  先运行服务器端  再运行客户端  ,
 */
public class ClientDemo {
	private static final String IP="192.168.1.105";
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.建立客户端socket服务
		Socket  socket=new Socket(IP, 10000);//连接192.168.0.136主机的1000端口
		//2.连接建立,socket产生,获取其中的流
		OutputStream out = socket.getOutputStream();
		//3.写入数据
		out.write("客户端发送到服务器端的数据\r\n".getBytes());//加\r\n就是为了readline读取 否则readLine读取不到换行会阻塞
		out.flush();
//		out.close();
		//接收服务端返回的数据
		InputStream input = socket.getInputStream();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		 String line=null;
		while((line=reader.readLine())!=null){//readLine方法是阻塞方法 必须读取到回车换行即"\r\n"才能读取数据
			System.out.println(line);
		}
		//4.关闭资源
		socket.close();
		
	}

}
