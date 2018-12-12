package com.cn.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.SequenceInputStream;

public class SequenceStreamTest {

	/**
	 * SequenceInputStream
	 * 合并流的主要功能，就是将两个文件的内容合并成一个文件
	 */
	public static void main(String[] args)throws Exception {
	InputStream s1=new FileInputStream(new File("d://FileTest/a.txt"));
	InputStream s2=new FileInputStream(new File("d://FileTest/b.txt"));
	 OutputStream outputStream=new FileOutputStream(new File("d://FileTest/ab.txt"));
	 
	 SequenceInputStream  sis=new SequenceInputStream(s1, s2);//将输入流s1,s2合并在一起
	 int len=0;
	 byte[] buffer=new byte[1024];
	  while((len=sis.read(buffer))!=-1){
		  outputStream.write(buffer, 0, len);
	  }
	   outputStream.close();
	   sis.close();
	   s2.close();
	   s1.close();
  
	   
	}

}
