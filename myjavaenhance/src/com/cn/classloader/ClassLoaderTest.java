package com.cn.classloader;

import java.util.Date;


public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		//1.得到类加载器
		ClassLoader  loader=ClassLoaderTest.class.getClassLoader();

	    //2.类加载器的名字
		String name=loader.getClass().getName();
		System.out.println(name);
		System.out.println(System.class.getClassLoader());//null 代表是由BootStramp加载器进行加载的
		
		//类加载器的继承关系  AppClassLoader........>ExtClassLoader........>BootStrap(顶级) 加载顺序则是由顶级到低级
		while(loader!=null){
			System.out.println(loader.getClass().getName());//类加载器的名字
			loader=loader.getParent();
		}
	  System.out.println(loader);
	  
	 /*测试一：将ClassLoaderAttachment的class文件加密并保存在itcastlib文件夹下   然后再用加密后的calss文件
	 去覆盖正常的class文件,此时再加载该class文件则会出现异常,这证明我们加密成功
	  run as....>run configuration..>选择main class 即我们要调用的类，再arguments中传入参数
	 */
//    System.out.println(new ClassLoaderAttachment().toString());//有包名的类不能调用无包名的类
	  
    /* 测试二:用自定义的类加载器加载ClassLoaderAttachment   为保证让自己的类加载器加载而不让父类加载，
	  则将项目工程原来classpath即bin目录中的ClassLoaderAttachment.Class文件删除，则只能被自己的类加载
	 器加载*/
	  Class classnew=new  MyClassLoader("itcastlib").loadClass("com.cn.classloader.ClassLoaderAttachment");//用自定义的类加载器加载
	  Date date=(Date) classnew.newInstance();
	  System.out.println(date);
	}

}
