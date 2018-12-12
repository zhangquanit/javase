package com.heima.tcp.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
  
  张全
 */
	public class UploadTask implements Runnable{
		private Socket socket;
		public UploadTask(Socket socket){
			this.socket=socket;
		}
		@Override
		public void run() {
			
			try{
               InputStream input = socket.getInputStream();		
              FileOutputStream out = new FileOutputStream(new File("D:"+File.separator+"test\terry","zhangquan.jpg"));
               byte[] buffer=new byte[1024];
       		int len=0;
       		while((len=input.read(buffer))!=-1){
       			out.write(buffer, 0, len);
       		}
              
       		OutputStream output = socket.getOutputStream();
       		output.write("上传成功".getBytes());
       		
       		out.close();//记得关闭输出流 
       		socket.close();
			}catch (Exception e) {
			}
			
		}
	}
