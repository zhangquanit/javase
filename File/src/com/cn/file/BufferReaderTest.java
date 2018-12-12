package com.cn.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class BufferReaderTest {

	/**
	 * Buffer表示缓冲区，BufferedReader是从缓冲区中读取内容，所有输入的字节数据都将放在缓冲区中
	 * BufferedReader(Reader in) 构造方法中要求传入字符
	 *   字节流   .............> 字符流
	 *  InputStreamReader 可将字节输入流转换为字符输入流        new InputStreamReader(Reader reader);
	 *                    BufferedReader  reader =new BufferedReader(new InputStreamReader(InputStream inputStream));
	 *  OutputStreamWriter 可将字节输出流转换为字符输出流     new OutputStreamWriter(Writer writer);
	 *                    BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(OutputStream outputStream));
	 */                   
	public static void main(String[] args) throws Exception{
		
		InputStream inputStream=new FileInputStream(new File("d://terry.txt"));
		
		//利用BufferedReader读取
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(inputStream));//将字符流放入字符流缓冲区中
//        String str=null;
//		StringBuffer buffer=new StringBuffer();   //用来封装返回结果 
//		while((str=bufferReader.readLine())!=null){//一次性读取文本中的一行  以回车结束
//			buffer.append(str+"\n"); //读取一行后 就换行
//		}
//        bufferReader.close(); //一定要记得关闭强制刷新
//        System.out.println(buffer.toString());
		
		//第二种读取方式  也是会自动换行
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=inputStream.read(buffer))!=-1){
			outputStream.write(buffer, 0, len);
		}
        byte[] data=outputStream.toByteArray();
       System.out.println(new String(data));//打印结果
 //       System.out.println(data.toString()); //toString表示打印该对象
	}

}
