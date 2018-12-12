package com.cn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ReaderandWriter {

	/**
	 * 字符流和字节流
	 * JAVA中的IO操作也是有相应步骤的，以文件操作为例，主要的操作流程如下：
	 *  1）使用File类打开一个文件
	 *  2）通过字节流或字符流的子类，指定输出的位置
	 *  3）进行读/写操作‘
	 *  4）关闭输入/输出
	 * IO操作属于资源操作，对于资源操作，操作的最后必须关闭，否则就有可能出现未知的错误。
	 *                       字节流：
	 * OutputStream ,InputStream
	 * OutputStream是整个IO包中字节输出流的最大父类，该类是抽象类，所以要想使用该类的话，需要通过实现该类的
	 * 子类实例化OutPutStream
	 * public abstract class OutputStream extends Object  implements Closeable, Flushable
	 * Closeable表示可以关闭的操作，因为程序运行到最后肯定要关闭 该接口中只有close()方法，所以接口表示一种规范
	 * Flushable表示刷新，清空内存中的数据  该接口中只有flush方法 
	 * 对于OutPutStream 写入数据，如果文件不存在则会为用户自动创建新文件。默认情况下，新写入的数据会覆盖原来
	 * 的数据，那么如果现在要想执行追加的功能，则必须设置追加的操作，
	 * public FileOutputStream(File file,boolean append)throws FileNotFoundException
	 * 将append的值设置为true，则表示在文件的末尾追加内容
	 * 对于InputStream读取数据，文件必须存在，否则会报FileNotFoundException
	 * 
	 *                       字符流
	 *Writer ，Reader
	 *FileWriter同FileOutPutStream，向文件中写入数据，文件如果不存在则自动创建文件，只不过这里直接写入char型
	 *或String型数据，同样，默认写入的数据或覆盖原来的，如果要想追加到末尾，new FileWriter(File file,boolean append); 
	 *append设置为true，
	 *
	 *字符流和字节流的区别：
	 *字节流：字节流操作的时候本身是不会用到缓冲区(内存)的，是与文件本身直接操作的 ,不必close()照样也可以写入数据
	 *字符流：字符流在操作的时候是使用到缓冲区的。所以必须要手动调用 flush()刷新方法或close()强制性的刷新缓冲区
	 * 
	 * FileReader是InputStreamReader的子类，FileWriter是OutputStreamWriter的子类，所以不管操作的是字符流还是
	 * 字节流，文件中保存的永远是字节
	 */
	public static void main(String[] args) throws Exception{
		File file=new File("d:"+File.separator+"test.txt");
	InputStream inputStream=new FileInputStream(file);
	 OutputStream outputStream=new FileOutputStream(new File("d://zhang.txt"));
	 byte[] b=new byte[1024];
	  int len=0;
	  while((len=inputStream.read(b))!=-1){
		  outputStream.write(b, 0, len);
	  }
       outputStream.close();
    
	}

}
