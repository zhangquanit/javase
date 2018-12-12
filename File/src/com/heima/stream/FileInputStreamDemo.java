package com.heima.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 张全
 */
public class FileInputStreamDemo {


	public static void main(String[] args)throws IOException {
//          read();
//		  copyPic();
		copyPicByBuffer();
	}
	//读取文本文件
	public static void read(){
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("fileoutstream.txt");
			System.out.println("字节数=" + fis.available());// 注意这个方法对文件内容少时适用
															// 如果文件大就不建议适用了
			int len = 0;
			byte[] buff = new byte[1024];
			while ((len = fis.read(buff)) != -1) {
				System.out.println(new String(buff, 0, len));
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//读取图片
	public static void copyPic()throws IOException{
	   FileInputStream fis = new FileInputStream("zhangquan.jpg");
	   FileOutputStream fos = new FileOutputStream("zhangquan_copy.jpg");
	   int len = 0;
		byte[] buff = new byte[1024];
		while ((len = fis.read(buff)) != -1) {
			fos.write(buff, 0, len);
		}
		fos.close();
		fis.close();
	}
	
	//使用缓冲区读取图片  封装对字节数组的操作
		public static void copyPicByBuffer()throws IOException{
		   BufferedInputStream bis = new BufferedInputStream(new FileInputStream("zhangquan.jpg"));
		   BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("zhangquan_copy_buffer.jpg"));
		   int len = 0; 
			while ((len = bis.read()) != -1) { //读取一个字节 ，封装了缓冲字节数组
				bos.write(len);
			}
			bos.flush();
			bos.close();//关闭前会调用flush刷新缓冲数据
			bis.close();
		}
		
}
