package com.cn.file;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomFile {

	/**
	 * RandomFile类的主要功能是完成随机读取功能，可以读取指定位置的内容
	 * 在文件中，所有的内容都是按字节存放的，都有固定的保持位置
	 * 操作模式:r只读  w只写  rw读写(如果使用此模式，如果文件不存在 则会自动创建)
	 * 写入数据    writeBytes(String str)将字符串写入字节数组中,writeInt()写入数字
	 * 读取数据   readByte()读取一个字节 ,readInt()读取数字
	 * seek(int i)指定位置读取，skipBytes(int i)跳过多少个字节
	 * 不管写入数据还是读取数据最后都记得关闭 close()
	 * 
	 * 两位整数占4个字节
	 */
	public static void main(String[] args) throws Exception{
	File  file=new File("d:"+File.separator+"test.txt");
	//写入数据
//	RandomAccessFile raf=new RandomAccessFile(file, "rw");
//	  String name=null;
//	  int age=0;
	
//	  name="zhangsan";
//	  age=21;
//	  raf.writeBytes(name);
//	  raf.writeInt(age);
//	  
//	  name="lisi";
//	  age=22;
//	  raf.writeBytes(name);
//	  raf.writeInt(age);
//	  
//	  name="wangwu";
//	  age=23;
//	  raf.writeBytes(name);
//	  raf.writeInt(age);
//    
//	  raf.close();
	  
	  //2.读取数据
	RandomAccessFile accessFile=new RandomAccessFile(file, "r");
	String name=null;
	int  age=0;
	byte[] b=new byte[8]; //用来封装name数据   zhangsan
	 for(int i=0;i<b.length;i++){
		 b[i]=accessFile.readByte();//读取第一个人的名字长度
	 }
	 name=new String(b); //byte....>string  方便打印
	 age=accessFile.readInt();
	 System.out.println("第一个人的信息:"+name+",age="+age);
	 
	 accessFile.skipBytes(8);// 第一个人读完后，跳过第二个人(lisi 22) 读取第三 个人的信息
	 
	 byte[] b2=new byte[6];// wangwu
	 for(int i=0;i<b2.length;i++){
		 b2[i]=accessFile.readByte();
	 }
	 name=new String(b2);
	 age=accessFile.readInt();
	 System.out.println("第三个人的信息:"+name+",age="+age);
	 
	 accessFile.seek(12);//跳到第二个人开始的位置读取 第二个人的信息
	 
	 byte[] b3=new byte[4];
	 for(int i=0;i<b3.length;i++){
		 b3[i]=accessFile.readByte();
	 }
	 name=new String(b3);
	 age=accessFile.readInt();
	 System.out.println("第二个人的信息:"+name+",age="+age);
	 
	}

}
