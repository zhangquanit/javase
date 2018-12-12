package com.heima.encode;

import java.io.UnsupportedEncodingException;

/**
  
 截取指定指定长度 字节
 */
public class ByteTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="ab搞人";
		byte[] bytes = str.getBytes("utf-8");//utf-8为系统默认编码
		for(int i=0;i<bytes.length;i++){
			System.out.println("截取 "+(i+1)+"个字节的结果为:"+getStr(bytes, i+1));
		}

	}
	
	public static String getStr(byte[] bytes,int len){
        
        int count=0;
          for(int i=len-1;i>=0;i--){     
        	  if(bytes[i]<0){//中文的字节是小于0的   计算小于0的字节数 
        		  count++;
        	  }else {
				break;
			}
          }
         
          //计算移除的字节数
         if(count%3==1){
        	 return new String(bytes,0,len-1);
         }else if(count%3==2){
        	 return new String(bytes,0,len-2);
         }else 
        	 return new String(bytes,0,len);
          
              
	}
	
	
}
