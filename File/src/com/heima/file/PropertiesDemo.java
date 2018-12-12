package com.heima.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
  
 */
public class PropertiesDemo {
	
	public static void main(String[] args) throws IOException {
		
	  //1.储存
		Properties properties = new  Properties();
		properties.put("name", "zhangquan");
		properties.put("age", "26");
		//以properties格式文件储存
		properties.store(new FileWriter("people.properties"), "this is a properties txt");
		//以xml文件格式储存
		properties.storeToXML(new FileOutputStream("people.xml"), "this is a properties txt", "utf-8");
		
		//2.读取
		properties=new Properties();
//		properties.load(new FileReader("people.properties"));
//		properties.load(new FileInputStream("people.properties"));
		properties.loadFromXML(new FileInputStream("people.xml"));
		String name =(String) properties.get("name");
		String age =(String) properties.get("age");
		
		System.out.println("name="+name+",age="+age);
		
		System.out.println("............列出所有的键值对...............");
		//3.列出所有的键值对
		for(Map.Entry<Object, Object> entry:properties.entrySet()){
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		System.out.println("............列出所有的属性名...............");
		//4.列出所有的属性名
		Set<String> propertiesNames = properties.stringPropertyNames();
//		Iterator<String> iterator = propertiesNames.iterator();
//		while(iterator.hasNext()){
//			String key =iterator.next();
//			System.out.println(key);
//		}
		for (String key2:propertiesNames) {
			System.out.println(key2);
		}
        //4.list()直接打印
	    properties = System.getProperties();//系统属性
		properties.list(System.out); 	//打印到控制台
		 
	}

}
