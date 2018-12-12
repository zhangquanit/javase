package com.cn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 1.了解java IO支持的三种压缩格式:ZIP,JAR,GZ
 * 在java中为了减少传输时的数据量，也提供了专门的压缩流，可以将文件或文件夹压缩成ZIP,JAR,GZIP等文件形式。
 * ZIP是一种常见的压缩形式，在JAVA中要想实现ZIP的压缩需要导入java.util.zip包，可以使用此包中的ZipFile,
 * ZipInputStream,ZipOutputStream,ZipEntry几个类完成操作。
 * JAR及GZIP文件格式的压缩输入，输出流
 *  在JAVA IO中，不仅可以实现ZIP压缩格式的输入，输出，也可以实现JAR及GZIP文件格式的压缩：
 *   1）JAR压缩的支持类保存在java.util.jar包中，常用类有如下几个：
 *      Jar压缩输出流，JarOutputStream
 *      Jar压缩输入流    JarInputStream
 *      Jar文件                   JarFile
 *      Jar实体                   JarEntry(在每一个压缩文件中都存在多个子文件，每一个子文件在java中就使用ZipEntry表示
 *                             在实例化ZipEntry的时候，要设置名称，此名称实际上就是压缩文件中的每一个元素的名称)
 *    2）GZIP是用于Linuix系统的文件压缩，在Linux中经常会使用到*.gz的文件，就是GZIP格式，GZIP压缩的支持类
 *      保存在java.util.zip包中，常用类有如下几个：
 *       GZIP压缩输出流 ：GZIPOutputStream
 *       GZIP压缩输入流：GZIPInputStream
 * 2.掌握ZipOutputStream,ZipFile,ZipInputStream三个类的使用
 * 
 */
public class ZIPStream {


   public static void main(String[] args)throws Exception {
	  //1.完成一个文件的压缩
//	  File file=new File("d:"+File.separator+"FileTest/a.txt");
//	  FileInputStream inputStream=new FileInputStream(file);
//	  ZipOutputStream outputStream=new ZipOutputStream(new FileOutputStream("D://FileTest/test.zip"));
//	  outputStream.setComment("测试zip");】
//	  outputStream.putNextEntry(new ZipEntry(file.getName()));
//	  int len=0;
//	  byte[] buffer=new byte[1024];
//	  while((len=inputStream.read(buffer))!=-1){
//		  outputStream.write(buffer, 0, len);
//	  }
//	  outputStream.close();
//	  inputStream.close();
	   
	   
	  //2.压缩文件夹
//	   File file=new File("d:"+File.separator+"FileTest/test");
//	   FileInputStream inputStream=null;
//	   ZipOutputStream	outputStream=new ZipOutputStream(new FileOutputStream("D://FileTest/testdir.zip"));
//		  outputStream.setComment("测试zip");
//		  if(file.isDirectory()){
//			  File[] files=file.listFiles();
//			  for(File file2:files){
//				  inputStream=new FileInputStream(file2);
//				  outputStream.putNextEntry(new ZipEntry(file.getName()+File.separator+file2.getName()));
//				  int len=0;
//				  byte[] buffer=new byte[1024];
//				  while((len=inputStream.read(buffer))!=-1){
//					  outputStream.write(buffer, 0, len);
//				  }
//				 
//				  inputStream.close();
//			  }
//			  outputStream.close();
//		  }
		  
	   
	   /*
	    * 3.ZipFile 在java中，每一个压缩文件都可以使用ZipFile表示。还可以使用ZipFile根据压缩后的文件名称找到
	    * 每一个压缩文件中的ZipEntry并将其进行解压操作   
	    */
//	   File file=new File("d:"+File.separator+"FileTest/serializable.zip");//找到压缩文件
//	    //定义解压缩文件名称
//FileOutputStream outputStrem=new FileOutputStream(new File("d:"+File.separator+"FileTest/test.txt"));
//	   ZipFile zipFile=new ZipFile(file);//实例化ZipFile对象
//	   ZipEntry zipEntry=zipFile.getEntry("serializable.txt");//得到一个压缩文件,该文件是存在ZIP中的
//	   InputStream inputStream=zipFile.getInputStream(zipEntry);//得到一个压缩实体的输入流 
//	   int len=0;
//	   byte[] buffer=new byte[1024];
//	   while((len=inputStream.read(buffer))!=-1){
//		   outputStrem.write(buffer, 0, len);
//	   }
//	    outputStrem.close();
//	    inputStream.close();
//注意：以上操作有一个问题，必须知道压缩文件中的每一个压缩实体的名称才可以进行加压操作	
	   
	   
	   //4.解压带有文件夹的压缩文件
	   File file=new File("d:"+File.separator+"FileTest/testdir.zip");
	   ZipFile zipFile=new ZipFile(file);
	   ZipInputStream zipInputStream=new ZipInputStream(new FileInputStream(file));
	   ZipEntry entry=null;
	   File outFile=null;
	   InputStream inputStream=null;
	   OutputStream outputStream=null;
	   while((entry=zipInputStream.getNextEntry())!=null){
		   System.out.println("解压缩"+entry.getName()+"文件");
		   outFile=new File("d:"+File.separator+"FileTest/"+entry.getName());//输入文件
		   if(!outFile.getParentFile().exists()){//如果输出文件夹不存在
			   outFile.getParentFile().mkdir(); //就创建文件夹
		   }
		   if(!outFile.exists()){ //如果输出文件不存在
			   outFile.createNewFile();// 创建输出文件
		   }
		   inputStream=zipFile.getInputStream(entry);//得到每一 个实体的输入流
		   outputStream=new FileOutputStream(outFile);//实例化文件输出流 
		   int len=0;
		   byte[] buffer=new byte[1024];
		   while((len=inputStream.read(buffer))!=-1){
			   outputStream.write(buffer, 0, len);
		   }
		   inputStream.close();
		   outputStream.close();
	   }
}

}
