package com.heima.io.other;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
       PrintStream
  对于OutputStream字节流的write()和print();
  如果需要保证数据原样性的时候，可以使用print方法。使用打印流。
 */
public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
      PrintStream out = System.out;
      out.println("fdfd");
      
      out=new PrintStream("printstreamdemo.txt");
      out.print(97); //会将整数转成字符串。
      out.println(); //换行符
      out.write(97);//会将整数的4个字节中的最低一个字节写出。  文件中则存的是a
      
      //比如  
      FileOutputStream fos = new FileOutputStream("printoutstreamdemo.txt");
//      fos.write(97); //文件中写入的是a  如果就想往文件中写入97   则可以使用打印流
      out=new PrintStream(fos);
      out.print(97);
      
      
      fos.close();
      out.close();
      
	}

}
