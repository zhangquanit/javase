package com.cn.file;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class SystemTest {

	/**
	 * System系统类对IO的支持
	 * System.out 对于系统标准输出，一般是显示器   FileOutputStream是定位在文件里，而System.out是定位在屏幕上
	 * System.err 错误信息输出, 如果程序中出现了错误的话，则直接使用System.err进行打印即可
	 * System.in  对应着标准输入 ，一般是键盘
	 */
	public static void main(String[] args) throws Exception{
		// 1.System.out
		OutputStream outputStream=System.out; //此时的输出流是在屏幕上
//		String string="hello,terry";
//		outputStream.write(string.getBytes());//向屏幕上输出
//		outputStream.close();
		
	  //2.System.err  如果程序中出现了错误的话，则直接使用System.err进行打印即可
		
		try{
		System.out.println(Integer.parseInt("hello"));
		}catch (Exception e) {
			System.err.println(e); //使用System.out打印结果是一样的。
		} 
 //注意：System.out和System.err的区别：System.out是希望用户看到的，而System.err是不希望用户看见的
		
	 //3.System.in 实际上就是一个键盘的输入流，其本身是InputStream类型的对象，	

	}

}
