package com.heima.io.other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
  
  张全
  字节数组输入流和字节数组输出流：维护了一个byte[]数组
  特点：操作内存 不需要关闭流
  
 */
public class ByteArrayStreamDemo {
 
	public static void main(String[] args){
		
		String  data="hello,terry";
		ByteArrayInputStream bais = new ByteArrayInputStream(data.getBytes());
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		//由于字节数组本身就维护了一个byte[]数组  所以没有必须再创建字节数组
		  int ch=0;
		 while((ch=bais.read())!=-1){
			 output.write(ch);
		 }
	   System.out.println(output.toString());
		
		
	}
	
}
