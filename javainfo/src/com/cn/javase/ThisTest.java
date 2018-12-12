package com.cn.javase;

/**
 * This关键字
 * this.属性，this.方法()实际上都表示当前的对象中的属性或当前对象调用的方法
 * this的核心：表示当前对象，当前正在操作本方法的对象称为当前对象。
 * 使用this可以调用其他构造方法，但是此语句必须放在构造方法的首行。
 *
 * Static 关键字
 * 如果非static的属性和方法，这样 每个对象都占有各自的内容。如果现在希望一个属性被所有对象共同拥有，则可以将
 * 其声明为static类型。一旦改变其值，则其他对象的static属性内容也全部改变。
 * 每一个对象都拥有各自的堆栈空间，堆内存空间中保存每个对象的各自的属性，但是所有的static属性是保存在全局数据
 * 区之中，所有的对象指向全局数据区中的一个内容，所以当一个对象修改之后，所有对象的内容将全部变化。
 *  Java中的内存区域：
 * 栈内存：可以保存对象的名称
 * 堆内存：保存每个对象的具体属性
 * 全局数据区：保存static类型的属性
 * 全局代码区：保存所有方法的定义
 * 
 * 在static方法中只能访问static的声明的属性和方法。
 * 
 * Java中的代码块：
 * 普通代码块：方法语句块
 * 构造块 ：直接定义在类中的语句块，优先于构造方法执行    每实例化对象一次，就调用一次
 * 静态代码块：static{ }   优先于构造块执行，只会执行一次，主要功能就是为静态属性初始化
 * 同步代码块：
 */
public class ThisTest {
   
    public static void main(String[] args) {
    	
    	StaticTest staticTest=new StaticTest();
    	StaticTest staticTest2=new StaticTest();
    	StaticTest staticTest3=new StaticTest();
    	System.out.println(staticTest2.USERNAME);
    	staticTest.USERNAME="terry";          //一个对象修改静态属性  则其他对象引用的静态属性值也随着改变
    	System.out.println(staticTest2.USERNAME);
    	System.out.println(staticTest2.USERNAME);
    	
    	// 测试代码块
    	new StaticStatement().test();
	}
}
class StaticTest{
	public static String USERNAME="jack";
	public static int count=0;
	public StaticTest(){
		count++;
		System.out.println("第"+count+"对象");
	}
	
}
class StaticStatement{
	public static String PASSWORD;
	static{
		PASSWORD="123";
		System.out.println("静态代码块............1");
	}
	{
		System.out.println("代码块.................2");
	}
	public StaticStatement(){
		System.out.println("构造方法................3");
	}
	public void test(){
		System.out.println("普通代码块..............4");
	}
}