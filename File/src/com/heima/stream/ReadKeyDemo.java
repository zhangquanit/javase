package com.heima.stream;

import java.io.InputStream;

/**
  
   键盘录入数据
   键盘录入数据时,录入的都是字节数据
   
  系统的标准的输入设备：System.in  对应的类型是InputStream
  系统的标准的输出设备:System.out  对应的类型是PrintStream
 */
public class ReadKeyDemo {

	public static void main(String[] args) throws Exception{
    
		//获取到了标准的输入设备对象,默认是键盘
		InputStream input=System.in;
//		int ch1=input.read();//read() 阻塞式方法，没有数据录入 就等待
		
		int cc=0;
		while((cc=input.read())!=-1){
			System.out.print((char)cc);
		}
	}

}
