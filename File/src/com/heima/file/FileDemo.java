package com.heima.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Field;

/**
  
  File类的由来：
    文件形式有多种,比如图片，txt文本,MP3音乐文件
    它们都有名称,大小,创建时间,路径,等相同属性,于是就将这些不同格式文件的共同属性抽取到一个类中  叫File
 */
public class FileDemo {
	
	public static void main(String[] args) throws IOException {
		
		
		 
		 
		//在多层目录下创建文件  先创建目录  再创建文件
		String parent="D:"+File.separator+"terry/haha";
		
		File parentFile = new File(parent);
		File file = new File(parentFile,"zhangquan.txt");
        if(!parentFile.exists())
        	parentFile.mkdirs();
		file.createNewFile();
		
		//删除带内容的目录
		 deleteDir(parentFile);
  
		//判断file对象是文件或目录,必须明确它是存在的
		if(file.exists()){
			System.out.println("file:"+file.isFile());
			System.out.println("directory:"+file.isDirectory());
		}
		
		//可以改变文件名称，如果两个file对象目录不同,实现文件的移动，相当于剪切
		File file2 = new File("D:"+File.separator+"terry/rename.txt");
		file.renameTo(file2);
		
		 //文件名过滤器  在当前目录下过滤  不会在子目录中过滤
		String[] names=file2.getParentFile().list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				 System.out.println(dir+"........."+name);
				 //只过txt文件
				return name.endsWith(".txt"); //匹配规则
			}
		});
		System.out.println(names.length);
		
		//文件过滤器
		  File listFile = new File("D:"+File.separator+"terry");
		 File[] fileLists= listFile.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				//只过滤目录
				return pathname.isDirectory();
			}
		});
		 
		 System.out.println(fileLists.length);
		 
		 
		 
	}

	/**
	 * 删除一个带内容的文件夹
	 * 对应windows而言,必须要删除最里面的内容,然后从里往外删。递归操作
	 */
	public static void deleteDir(File dir){
		File[] listFiles = dir.listFiles();
		for(File file:listFiles){
			if(file.isDirectory()){
				deleteDir(file);
			} else {
				boolean success = file.delete();
				System.out.println("删除："+success);
			}
		}
		//最后删除文件夹
		System.out.println(dir+"..."+dir.delete());
	}
	
}
