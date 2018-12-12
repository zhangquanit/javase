package com.heima.test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
  
  张全
 */
public class Father {
  
	public Father(){
		
	}
	
	public int  fun1(int a,int b){
		if(b==0)
			throw new RuntimeException("除数不可能为0");
		return a/b;
	}
	public void fun2()throws FileNotFoundException{
		
	}
}
