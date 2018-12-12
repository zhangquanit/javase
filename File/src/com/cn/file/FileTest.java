package com.cn.file;

import java.awt.print.Printable;
import java.io.File;
import java.lang.reflect.Field;

public class FileTest {

	/**
	 *File类只是针对文件本身进行操作(创建 删除 读取路径等)    不能对其内容进行操作
	 *File类的删除操作前  应按判断文件是否存在  文件不存在的话 是要自己创建的
	 */
	public static void main(String[] args) {
//		File file=new File("D://");
	 //方法一：list()	列出所有的文件名 不管是文件夹名还是文件名   比如 zhangquan.jpg
//	String[] str=file.list();
//	  for(String string:str){
//		  System.out.println(string);
//	  }
	//方法二：listFiles 列出所有的文件名带路径的   比如 D:\zhangquan.jpg
//	File[] files= file.listFiles();
//	    for(File file2:files){
//	    	System.out.println(file2);
//	    }
	//方法三，打印文件夹下所有内容
//     print(file); 
    
	  File file=new File("D:"+File.separator+"Media");
	  System.out.println(file.getName());
	  System.out.println(file.getAbsolutePath());
	  System.out.println(file.getPath());
	  System.out.println(file.getParent());
	  System.out.println(file.isFile()+"   "+file.isDirectory());
	}
public static void print(File file){
	if(file!=null){
		if(file.isDirectory()){
			  File[] files=file.listFiles();
			  if(files!=null){
				   for(File file2:files){
					  print(file2) ;
				   }
			  }
		}else{
			System.out.println(file);
		}
	}
 }
}


