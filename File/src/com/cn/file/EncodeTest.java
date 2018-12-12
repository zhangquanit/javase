package com.cn.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class EncodeTest {

/**
 * 字符编码
 * 乱码产生的根本原因：字符编码不统一
 * 
 * 在计算机世界里，任何的文字都是以指定的编码方式存在的，在JAVA程序开发 中最常见的是以下几种编码：
 * ISO8859-1，GBK(简体中文和繁体中文)/GB2312(只包含简体中文)，Unicode,UTF
 * iso8859-1编码属于单字节编码，最多只能表示0-255的字符范围，主要在英文上应用
 * GBK/GB2312：中文的国标编码，专门用来表示汉字，是双字节编码
 * unicode：java中就是使用此编码方式，也是最标准的一种编码，是使用16进制表示的编码，但此编码不兼容Iso8859-1编码
 * UTF：由于unicode不支持Iso8859-1编码，而且容易占用更多的空间，而且对于英文字母也需要使用两个字节编码，
 * 这样使用unicode不便于运输和储存，因此产生了utf编码，utf编码兼容了Iso8859-1编码，同时可以用来表示所有的语言字符
 * utf编码是不定长编码，每一个字符的长度从1-6个字节不等，一般在中文网页中使用此编码，因为这样可以节省空间。
 * 
 * 如果程序与当前系统的编码不一致，则会出现乱码，则需要进行编码，要进行编码。则需要String类的支持
 */
	public static void main(String[] args) throws Exception{
		String localEncoding=System.getProperty("file.encoding");
		System.out.println("系统默认编码:"+localEncoding);//获取当前系统编码   UTF-8
		OutputStream outputStream=new FileOutputStream(new File("d:"+File.separator+"FileTest"+File.separator+"encoding.txt"));
		String string="周星驰";
		byte[] b=string.getBytes("ISO8859-1"); //转码操作    将String内容按ISO8859-1来保存。由于系统当前编码为UTF-8，则肯定出现乱码
		outputStream.write(b);
		outputStream.close();
	}

}
