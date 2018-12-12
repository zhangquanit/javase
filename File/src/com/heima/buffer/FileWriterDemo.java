package com.heima.buffer;

import java.io.FileWriter;
import java.io.IOException;

/**
  
  张全
  
 */
public class FileWriterDemo {

	public static void main(String[] args)  {
       /**
        * 第一步 创建一个字符输出流对象。FileWriter
        * 目的在于明确数据储存的目的地
        * 运行时,会在指定目的下创建指定名称的文件。
        * 如果文件已经存在,则会覆盖。
        */
		FileWriter writer=null;
		try{
//		 writer=new FileWriter("filewriterdemo.txt");
		 writer=new FileWriter("filewriterdemo.txt",true);//可以续写
		
		//使用Writer类中的方法，write(string),写入数据
		writer.write("haha");//这个数据写入到流中,其实就是写入到了缓冲区中。
		
		String LINE_SEPARATOR=System.getProperty("line.separtor");//本地系统换行符  和系统无关  在window下表示\r\n 在linux下\n
		writer.write("abcd"+LINE_SEPARATOR+"efgh");
		//对缓冲区中的数据进行刷新
		writer.flush();
		
		}catch (IOException e) {
			throw new RuntimeException("写入失败");
		}finally{
			//关闭：close由2个动作组成，1.先刷新缓冲区，就调用了一次flush,2.再关闭资源
			try {
				if(null!=writer)
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
  //关于异常的处理,在try中进行读写操作,然后在finally中关闭资源。
}
