package com.heima.tcp.upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 张全
 */
public class TxtServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10001);
		Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//        FileOutputStream outStream = new FileOutputStream(new File("server.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("server.txt"), true);
        String line=null;
        while((line=reader.readLine())!=null){
//        	outStream.write(line.getBytes("utf-8"));
        	printWriter.println(line);
        }
        
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.write("上传完毕".getBytes());
        
        socket.close();//关闭当前连接
        serverSocket.close();//关闭服务
        
	}
}
