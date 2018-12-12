package com.heima.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
   
 */
public class FileOutputStremDemo {

	public static void main(String[] args) {
		FileOutputStream fos=null;
        try {
			 fos = new FileOutputStream("fileoutstream.txt");
			 fos.write("hello".getBytes());
			 
			 fos.close(); //关闭资源  不会刷新
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
