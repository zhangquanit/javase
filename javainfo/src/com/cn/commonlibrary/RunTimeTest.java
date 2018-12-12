package com.cn.commonlibrary;

/**
 * RunTime类
 * 运行时，是一个封装了JVM进程的类，每一个JAVA程序实际上都是启动了一个JVM进程，那么每一个JVM进程都是对应
 * 这一个RunTime实例，此实例是由JVM为其实例化的。
 * Runtime类本身就是单态设计的一种应用，因为在整个	JVM中只存在一个RunTime类的对象，可以使用Runtime类取得
 * JVM的系统信息，或者使用GC方法释放掉垃圾空间，还可以使用此类运行本机程序。
 * 
 * 可以使用RunTime类运行本机的可执行程序。例如打开 记事本
 */

public class RunTimeTest {
    public static void main(String[] args)throws Exception {
		Runtime runtime=Runtime.getRuntime();
		Process process= runtime.exec("notepad.exe"); //打开记事本
		Thread.sleep(5*1000); //5秒后自动关闭该记事本
		process.destroy();//结束该记事本进程
		 
	}
}
