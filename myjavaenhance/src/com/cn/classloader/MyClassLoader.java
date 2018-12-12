package com.cn.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader extends ClassLoader{

	/** 自定义类加载器  
	 * 继承ClassLoader 并覆盖findClass方法
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String srcPath = args[0]; //源文件路径
		String destDir = args[1]; //目标文件夹
		FileInputStream fis = new FileInputStream(srcPath);
		String destFileName = srcPath.substring(srcPath.lastIndexOf('\\')+1);//保存文件名
		String destPath = destDir + "\\" + destFileName;
		FileOutputStream fos = new FileOutputStream(destPath);
		cypher(fis,fos);
		fis.close();
		fos.close();
	}
	//加密
	private static void cypher(InputStream ips ,OutputStream ops) throws Exception{
		int b = -1;
		while((b=ips.read())!=-1){
			ops.write(b ^ 0xff);
		}
	}

	private String classDir;

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("-------findClass");
		String classFileName = classDir + "\\"  + name.substring(name.lastIndexOf('.')+1) + ".class";
		try {
			FileInputStream fis = new FileInputStream(classFileName);
			ByteArrayOutputStream  bos = new ByteArrayOutputStream();
			cypher(fis,bos);
			fis.close();
			byte[] bytes = bos.toByteArray();
			return defineClass(bytes, 0, bytes.length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public MyClassLoader(){
		
	}
	
	public MyClassLoader(String classDir){
		this.classDir = classDir;
	}
}
