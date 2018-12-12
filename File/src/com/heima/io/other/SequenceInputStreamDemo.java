package com.heima.io.other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
  
SequenceInputStream 
表示其他输入流的逻辑串联。它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾，
接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止
 */
public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		//数据源
       FileInputStream fis = new FileInputStream("fileoutstream.txt");
       FileInputStream fis2 = new FileInputStream("filewriterdemo.txt");
       FileInputStream fis3 = new FileInputStream("GBK.txt");
       
       //数据目的地
       FileOutputStream fos = new FileOutputStream("sequence.txt");
     
       //合并数据流  使用Vector来封装数据源
       Vector<FileInputStream> list = new Vector<FileInputStream>();
       list.add(fis);
       list.add(fis2);
       list.add(fis3);
       Enumeration<FileInputStream> elements = list.elements();
       SequenceInputStream sis = new SequenceInputStream(elements);
       byte[] buffer=new byte[1024];
       int len=0;
       while((len=sis.read(buffer))!=-1){
    	   fos.write(buffer,0,len);
       }
       fos.close();
       sis.close();
	}

}
