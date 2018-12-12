package com.heima.io.other;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
  
  张全
 */
public class PipedStreamDemo {
	
	public static void main(String[] args)throws Exception {
		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		//链接方式1
//		PipedOutputStream output = new PipedOutputStream(input);
		//连接方式2
		input.connect(output);
		new Thread(new Sender(output)).start();
		new Thread(new Receiver(input)).start();
		
	}

}
class Sender implements Runnable{
   PipedOutputStream outputStream;
	public Sender( PipedOutputStream outputStream){
		this.outputStream=outputStream;
	}
	@Override
	public void run() {
		
		try{
		 byte[] data="hello 管道流".getBytes();
		 outputStream.write(data, 0, data.length);
		 outputStream.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


class Receiver implements Runnable{
	PipedInputStream inputStream;
  public Receiver(PipedInputStream inputStream){
	  this.inputStream=inputStream;
  }
	@Override
	public void run() {
		
		try{
			byte[] data=new byte[1024];
			int len = inputStream.read(data);
			String result = new String(data,0,len);
			System.out.println(result);
			
			inputStream.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
