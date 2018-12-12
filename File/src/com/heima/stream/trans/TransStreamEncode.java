package com.heima.stream.trans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
  
     转换流的编码表
     
     中文..(编码).....>字节.....(解码)....>字符
 */
public class TransStreamEncode {

	public static void main(String[] args) throws IOException{
		//该类对于字符串操作使用的是默认的编码表,通常指的是所在系统的编码表 
		                                          //简体中文版的操作系统默认的就是GBK
		FileWriter fw = new FileWriter("GBK.txt");
		/*
		 * 写入过程：将 你好 去字符编码表比如GBK中去查找  查到对应的二进制数据  然后写入到文件中,
		 * 我们用记事本打开文件  之所以显示的是中文你好   是由于记事本对二进制数据进行了解码(默认码表)
		 */
		fw.write("你好");
		
		fw.close();
		
	  /*
	   * 2.按指定字符编码进行写入  
	   * FileWriter是使用本机默认的码表  如果要想指定码表  这时候就需要转换流来完成
	   * OutputStreamWriter 
	   * 字符流：字节流+编码表      文件中最终存放的都是字节  文件大小就是字节大小
	   * 
	   * 转换流：字节流+指定的编码
	   * 为了操作本地系统编码的数据方便，提供了一个子类
	   *   FileReader
	   *   FileWriter
	   * 这两个流对象特点在于：字节流+本地默认码表(简体中文版-GBK)
	   *  InputstreamReader :字节流+指定编码表。对数据进行解码
	   *          ----FileReader:字节流+本地默认码表，方便于对默认编码的文件进行操作
	   *  OutputStreamWriter:字节流+指定编码表。对数据进行编码 
	   *         ----FileWriter:字节流+本地默认码表，方便于对默认编码的文件进行操作
	   *         
	   * 总结：所以涉及指定编码  则必须使用转换流
	   * 
	   * java对字符使用的是unicode码表(任何字符都是2个字节)   比如  a....>97
	   */
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("UTF8.txt"), "utf-8"));
		/*
		 * 将内容以utf-8形式进行字符->字节的转换  即去utf-8码表中差得对应的字节  然后写入到文件中
		 * 拥记事本打开文件  记事本检查到字节头中有utf-8的标记 所以进行了UTF-8的解码 (文件另存为  下面就有编码格式) 
		 */
		bw.write("我好");
		bw.close();
		
		char c='a';
		System.out.println((int)c);
		
		
		//                 读取  ..................解码
		
		FileReader fr = new FileReader("GBK.txt"); //使用本地系统编码进行解码
		char[] buffer=new char[100];
		int len=fr.read(buffer);
		String txt = new String(buffer,0,len);
		System.out.println(txt);
		
		/**
		 * 按指定编码  进行解码
		 * 解码过程：读取文件  文件中的字节流然后按指定编码进行解码  即把字节去指定码表中查找得到指定字符
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("UTF8.txt"),"utf-8"));
		                    //用utf-8编码(中文3个字节)写入的数据  用GBK(中文2个字节)解码  则会产生乱码  即“你好”6个字节读取到3个字符
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("UTF8.txt"),"GBK"));
		 String line=null;
		 while((line=br.readLine())!=null){
			 System.out.println(line);
		 }
		
		
		
		
		
		
		
		
		
		
	}
}
