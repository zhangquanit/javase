package com.heima.io.other;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
  
  张全
 */
public class DataInputStreamDemo {

	
	public static void main(String[] args) throws IOException{
		writeData();
		readData();
	}
	public static void writeData()throws IOException{
		DataOutputStream output = new DataOutputStream(new FileOutputStream("data.txt"));
		output.writeInt(88);
//		output.writeUTF("你好");//用writeUTF写的数据 必须使用readUTF()来读
		output.flush();
		output.close();
		
	}
	public static  void readData()throws IOException{
		DataInputStream input = new DataInputStream(new FileInputStream("data.txt"));
		int number = input.readInt();
		System.out.println(number);
//		String data = input.readUTF();
//		System.out.println(data);
		input.close();
	}

}
