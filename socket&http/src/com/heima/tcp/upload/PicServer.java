package com.heima.tcp.upload;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
  
  张全
 */
public class PicServer {

	public static void main(String[] args) throws IOException {
     ServerSocket serverSocket=new ServerSocket(10003);
     new Thread(new UploadTask(serverSocket.accept())).start();
	}

	
	
}
