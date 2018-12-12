package com.heima.encode;

import java.io.UnsupportedEncodingException;

/**

  编码解码：
涉及到字符串和字节直接的转换。
编码表：
iso8859-1
GBK
UTF-8
编码：字符串--字节。 String类中的getBytes();
解码：字节--字符串。String类中的构造函数。

 Integer.toBinaryString(i&255)//int.....二进制字符串
 Integer.toHexString(i&255)  //int.....十六进制字符串
 */
public class EncodeTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
	//本地安装系统是UTF-8编码    一般的简体中文系统都是GBK
	
		//你好 UTF-8：-28,-67,-96,-27,-91,-67      一个汉字3个字节 
	    //你好 GBK：-60,-29,-70,-61                      一个汉字2个字节
		
		//编码
		String name="你好";
//		byte[] bytes = name.getBytes(); //使用本地系统码表 编码
		byte[] bytes=name.getBytes("utf-8"); //使用指定码表 编码
		System.out.println("2个中文汉字的字节数："+bytes.length);
		printBytes(bytes);
		
		
		//解码
//		name= new String(bytes); //使用本地系统码表  解码
		name= new String(bytes,"ISO8859-1"); //使用指定码表  解码
		System.out.println(name); //乱码
		
		//解码出错了怎么办?
		//可以将所谓的乱码 重新进行解码码表的编码(这里是ISO8859-1),为了获取对应的原码(对应的数字)
		byte[] bytes2 = name.getBytes("ISO8859-1"); //乱码后重新编码 获取对应的原码
		printBytes(bytes2);
		
	    name=new String(bytes2,"UTF-8"); //按指定编码解码
	    System.out.println(name);
		
		
	System.out.println("xxxxxxxxxxxxxxxxxxxxxxx分割符xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");	
	
	/**
	 * 乱码经验：
	 *    如果查出来的是 中文乱码  一般都是用的gbk去解码的
	 *    如果查出来的是 未知字符  比如？？？  则一般都是用的utf-8去解码
	 *    
	 *    如果要解中文  则只能使用UTF-8或GBK  因为只有UTF-8或GBK才能识别中文
	 *   
	 *   编码(码表1)....解码(码表2)...产生乱码...编码(码表2)...解码(码表1)
	 *   
	 */
	
	
	
	/*  UTF-8码表的未知编码区域
	 你好：
	  -71,-2,-32,-74,    GBK码表编码后的字节
            ���                         UTF-8编码失败
       -17,-65,-67,-17,-65,-67,-17,-65,-67,  UTF-8编码  找到的是UTF-8码表中的字节   和GBK码表中的原始字节不一样
            锟斤拷锟�      用UTF-8编码后的字节来解码   造成乱码
    
       谢谢：
      -48,-69,-48,-69,
      лл                 GBK解码后的字节在UTF-8码表中能找到对应的字符 лл
     -48,-69,-48,-69,    UTF-8 将лл 还原为字节  这些字节和GBK解码后的字节一样
         谢谢
         
     总结：不能使用UTF-8去解码GBK,UTF-8解码不成功则会去未知区域找未知字符代替  编码回来找到的还是那些未知区域的原码 再用GBK去解
        这些未知区域的原码  就会出错。
        
             因为GBK和UTF-8都是多字节的  都可以表示中文
             而用ISO8859-1不会出错   原因是ISO8859-1是单字节的,不能表示中文 
             
        但是可以用GBK去解码UTF-8编码的字节,出现乱码 然后再用GBK编码回去，
       UTF-8编码...GBK解码....GBK编码......UTF-8解码          可以实现
       GBK编码.....UTF-8解码..UTF-8编码....GBK解码             不可以实现  UTF-8的未知区域
	 */
	String str="哈哈";
	 byte[] b1=str.getBytes("GBK");
	 printBytes(b1);
	 
	 str=new String(b1,"UTF-8");
	 System.out.println("utf-8解码:"+str);
	 
	 b1=str.getBytes("UTF-8");
	 printBytes(b1);
	 
	 str=new String(b1,"gbk");
	 System.out.println(str);
	   
	}
public static void printBytes(byte[] bytes){
	for(byte b:bytes){
		System.out.print(b+",");
	}
	System.out.println();
}
}
