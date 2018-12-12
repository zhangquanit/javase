package com.cn.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {

	/**
	 * 打印流
	 * 在整个IO包中，打印流是输出信息最方便的类，主要包括字节打印流(PrintStream)和字符打印流(PrintWriter)，
	 * 打印流提供了非常方便的打印功能，可以打印任何的数据类型，例如：小数，整数，字符串等等。
	 */
	public static void main(String[] args) throws Exception{
		PrintStream printStream=new PrintStream(new FileOutputStream(new File("d:"+File.separator+"terry.txt")));
        
//		  printStream.print(true);
//        printStream.println("hello world!");
//        printStream.close(); //关闭
        
        //2.格式化输出 printf(String format,Object... args)第一个参数表示输出格式
		String name="terry";
		char  c='男';
		int  age=20;
		printStream.printf("姓名:%s,性别:%s,年龄:%s", name,c,age);//就是用name,c,age等去代替前面的%s
		printStream.close();
       

	}

}
