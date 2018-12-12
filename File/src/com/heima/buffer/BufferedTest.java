package com.heima.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
  使用缓冲区对象完成文件的复制
 */
public class BufferedTest {

	public static void main(String[] args) {
		BufferedReader br=null;
		BufferedWriter bw=null;
		  try{
			   br = new BufferedReader(new FileReader("buffereddemo.txt"));
			   bw = new BufferedWriter(new FileWriter("buffereddemo_copy.txt"));
			  
			   String line=null;
			   while((line=br.readLine())!=null){
				   bw.write(line); //读取一行的数据 然后写入  本身是不带换行的
				   bw.newLine();//每读取一行数据 都写入一个换行
			   }
			   bw.flush();
		  }catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
			 if(br!=null)
				 br.close();
			 if(bw!=null)
				 bw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
