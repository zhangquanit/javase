package com.heima.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
  
 readLine()方法原理：底层最终还是使用的read方法,先将字符读取到BufferedReader内部的数组中.
 如果读取到\r\n或者\n 类似这种换行的标记,就将前面读取的字符拼接成字符串的形式返回。
 */
public class BufferedReaderDemo {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("buffereddemo.txt");
			// 1.自定义缓冲区
			// char[] buff=new char[1024];
			// int len=0;
			// while((len=fr.read(buff))!=-1){
			// System.out.println(new String(buff,0,len));
			// }

			// 2.BuferedReader
			 br = new BufferedReader(fr);
			 String line;
			//每次读取一行  注意：这个方法是阻塞的 如果没有读取到内容 则会阻塞
			 while((line=br.readLine())!=null){
				 System.out.println(line);
			 }
            
			br.close();//缓冲区的关闭动作 其实就是关闭流的动作即fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
