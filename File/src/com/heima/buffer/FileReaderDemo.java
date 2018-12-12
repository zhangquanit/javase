package com.heima.buffer;

import java.io.FileReader;
import java.io.IOException;

/**
  
  张全
 */
public class FileReaderDemo {

	
	public static void main(String[] args) {
		FileReader reader=null;
		try{
		 reader=new FileReader("filewriterdemo.txt");
		 
		 //1.第一种读法 一个字符一个字符的读   特点是速度慢 效率低  因为每次读取一个字符都要操作硬盘
		 int ch=0;
		 while((ch=reader.read())!=-1){
			 System.out.println((char)ch);
		 }
		 
		 //2.第二中读法  往字符数组中读  特点是速度快 读取一定字符然后一次写入   减少了对硬盘的操作
		 char[] buf=new char[1024];
		 int len=0;
		 while((len=reader.read(buf))!=-1){ //返回读取的有效个数  -1表示没有了
			 System.out.println(new String(buf,0,len));//只取数组中有效字符
		 }
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null!=reader)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
