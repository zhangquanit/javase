package com.cn.commonlibrary;
/**
 * System类
 * System类是一个与系统相关的属性和方法的集合，而且在System类中所有的属性和方法都是静态的
 *
 */
class Jack{
	private String username;
   public Jack(String username){
	   this.username=username;
   }
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	 //在对象回收前   进行一些收尾操作，比如释放内存等
	@Override
	protected void finalize() throws Throwable {
		System.out.println("对象被释放"+this);
	}
	
}
public class SystemTest {
   public static void main(String[] args) {
	System.getProperties().list(System.out);//取出系统所有的属性
	System.out.println("java.home=========="+System.getProperty("java.home"));
	Jack jack=new Jack("jack");
	jack=null;//断开引用   则会被回收
//强制性调用gc 回收对象。    实际调用的是RunTime.getRunTime().gc()，如果不手动调用，则系统也会在一定时间内自动进行回收
	 System.gc();
}
}
