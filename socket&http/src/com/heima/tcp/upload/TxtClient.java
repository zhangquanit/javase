package com.heima.tcp.upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 张全
 * 上传文件
 * 上传图片等，使用数据流就行了
 */
public class TxtClient {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		// 1.建立客户端Socket服务
		Socket socket = new Socket("192.168.1.107", 10001);
		// 2.建立上传对象
		BufferedReader fileReader = new BufferedReader(new FileReader(new File(
				"文件上传.txt")));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		String line = null;
		while ((line = fileReader.readLine()) != null) {
			out.println(line);
		}
		socket.shutdownOutput();// 关闭输出流 告诉服务器端已上传完毕  表明已上传结束

		// 3.得到服务器端返回的数据
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String response = reader.readLine();
		System.out.println(response);
		// 4.关闭资源
		socket.close();
	}

}
