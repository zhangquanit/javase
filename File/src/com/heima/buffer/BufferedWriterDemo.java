package com.heima.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
字符流的缓冲区:
  在字符流的读写过程中,如果定义了char类型的数组,可以提高读写效率
  为了便于提高效率和操作,字符流提供了缓冲区对象,将数组进行了封装。
  对外提供了更为方便的方法来操作
 
  这两个对象是：
   BufferedReader
   BufferedWriter
  
  作用：它们的出现是给流提高读写效率的。
  使用了装饰模式,即对原有Writer或Reader中功能的增强
      装饰模式和继承的比较：
      装饰模式：能
      继承：

 */
public class BufferedWriterDemo {

	public static void main(String[] args) {
		FileWriter  fw=null;
		 BufferedWriter bw =null;
		try{
	    fw=new FileWriter("buffereddemo.txt");
	    
	    //1.FileWriter的默认实现
//	    fw.write("abcd");
//	    fw.write("\r\n efgh");
//	    fw.flush();
	    
	    //2.通过BufferedWriter来实现   维护了一个char[]数组 用来缓存数据
	    bw = new BufferedWriter(fw);
	    bw.write("abcd");
	    bw.newLine();//写入一个回车换行
	    bw.write("xxxx");
	    bw.flush();
	    
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    if(fw!=null)
					fw.close();
			    if(bw!=null)
			    	bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
