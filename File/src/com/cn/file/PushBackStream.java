package com.cn.file;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class PushBackStream {

	/**  回退流
	 * 通过回退流，可以给用户第二次读的机会
	 * PushBackInputStream 字节回退流
	 * PushBackReader 字符回退流
	 * Java IO中所有的的数据都是采用顺序的读取方式，对于一个输入流来讲都是从头到尾顺序读取的，如果在输入流中某个
	 * 不需要的内容被读取进来，则只能通过程序将这些不需要的内容处理掉，为了解决这样的读取问题，在JAVA中提供了一种
	 * 回退输入流PushBackInputStream,PushBackReader,可以把读取进来的某些数据重新退回到输入流的缓冲区之中
	 * PushBackInputStream有3个read和对应的3个unread方法,
	 */
	public static void main(String[] args)throws Exception {
		String string="hello,terry";
		ByteArrayInputStream  inputStream=new ByteArrayInputStream(string.getBytes());//将字符串内容放入到内存中
		PushbackInputStream ps=new PushbackInputStream(inputStream); //将内存中的内容以回退流的方式读取
		int temp=0;                    //char型可以自动转换为int型，int型必须强制转换为char型
		while((temp=ps.read())!=-1){ //读取一个字节
			if(temp==','){   //如果读取到了 ,
				ps.unread(temp); // 放回到缓冲区之中  
				temp=ps.read(); //继续往后读
				
			}else{
				System.out.print((char)temp);
			}
			
		}
	}

}
