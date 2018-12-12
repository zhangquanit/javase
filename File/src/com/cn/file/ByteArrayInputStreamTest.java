package com.cn.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayInputStreamTest {

	/**
	 * FileInputStream，FileOutputStream，FileReader，FileWriter，输出输入都是从文件中来的，当然，也可以将
	 * 输出的位置设置在内存之上，此时就要使用ByteArrayInputStream，ByteArrayOutputStream来完成输入，输出功能了。
	 * ByteArrayInputStream 
	 * ByteArrayOutputStream
	 */
	public static void main(String[] args)throws Exception {
	String  sting="hello,terry";
	InputStream inputStream=new ByteArrayInputStream(sting.getBytes());//内存输入流
	ByteArrayOutputStream outputStream=new ByteArrayOutputStream();//内存输出流 
	int len=0;
	byte[] buffer=new byte[1024];
	  while((len=inputStream.read(buffer))!=-1){
		  outputStream.write(buffer, 0, len);
	  }
       outputStream.close();
       byte[] data=outputStream.toByteArray();
       System.out.println(new String(data));
	}

}
