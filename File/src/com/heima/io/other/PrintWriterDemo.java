package com.heima.io.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
  
  张全
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);//打印到控制台上  自动刷新  不然不会打印
		String line=null;
		while((line=br.readLine())!=null){
			if("over".equals(line))
				break;
//			pw.println(line);
		    
		 //如果不设置new PrintWriter(System.out,true) 自动刷新  就要手动刷新
			pw.println(line);
			pw.flush();
			
		}
		pw.close();
		br.close();
	}

}
