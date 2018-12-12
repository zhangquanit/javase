package com.cn.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputStreamTest {

	/** 在IO包中，提供了两个与平台无关的数据操作流
	 *数据操作流
	 *DataInputStream  数据输入流
	 *DataOutputStream 数据输出流
	 *
	 */
	public static void main(String[] args)throws Exception {
		
		//1.写入数据
		File  file=new File("d:"+File.separator+"datainput.txt");
//		DataOutputStream outputStream=new DataOutputStream(new FileOutputStream(file));
//		 
//		String[] names={"张三","李四","王五"};
//		int[] ages={21,22,23};
//		char[] chars={'m','m','w'};
//		for(int i=0;i<names.length;i++){
//			outputStream.writeChars(names[i]); //写入字符串
//			outputStream.writeChar('\t');   // 写入分隔符
//			outputStream.writeInt(ages[i]);  // 写入年龄
//			outputStream.writeChar('\t');    
//			outputStream.writeChar(chars[i]);
//			outputStream.writeChar('\n');  //换行
//		}
//		outputStream.close();
		
		//2.读取数据
		DataInputStream inputStream=new DataInputStream(new FileInputStream(file));
		String name=null;//
		char[] temp=null;
		int age=0;
		char sex=0;
		char c=0;
		int len=0;//保存读取数据的个数
		 while(true){
			  temp=new char[200];
			  while((c=inputStream.readChar())!='\t'){
				    temp[len]=c;
				    len++;
			  }
			  name=new String(temp,0,len);
			  age=inputStream.readInt();  //读取年龄
			  inputStream.readChar();//读取\t
			  sex=inputStream.readChar(); //读取性别
			  inputStream.readChar(); //读取\n
			  System.out.printf("姓名:%s；年龄:%s；性别:%s\n", name,age,sex);
		 }
		

	}
  //
}
