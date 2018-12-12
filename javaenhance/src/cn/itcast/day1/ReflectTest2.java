package cn.itcast.day1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

public class ReflectTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//直接放在工程下
		//InputStream ips = new FileInputStream("config.properties");
		
		//使用类加载器加载     使用ReflectTest2.class把ReflectTest2加载到内存中来  使用类加载器加载时  路径前不能用/ 开头
		//InputStream ips = ReflectTest2.class.getClassLoader().getResourceAsStream("cn/itcast/day1/config.properties");
		
		 //相对路径 相对于ReflectTest2所在的路径
		//InputStream ips = ReflectTest2.class.getResourceAsStream("resources/config.properties");//
		 //绝对路径
		InputStream ips = ReflectTest2.class.getResourceAsStream("/cn/itcast/day1/resources/config.properties");


		Properties props = new Properties();
		props.load(ips); //加载文件
		ips.close();
		String className = props.getProperty("className");//由key得到value
		Collection collections = (Collection)Class.forName(className).newInstance();//其实就是实列化出HashSet
		
		//Collection collections = new HashSet();
		ReflectPoint pt1 = new ReflectPoint(3,3);
		ReflectPoint pt2 = new ReflectPoint(5,5);
		ReflectPoint pt3 = new ReflectPoint(3,3);	

		collections.add(pt1);
		collections.add(pt2);
		collections.add(pt3);
		collections.add(pt1);	
		
		//pt1.y = 7;		
		//collections.remove(pt1);
		
		System.out.println(collections.size());
	}

}
