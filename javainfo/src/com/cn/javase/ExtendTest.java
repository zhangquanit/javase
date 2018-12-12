package com.cn.javase;
/**
 * 子类继承父类，实例化子类对象，则会默认调用父类无参构造函数，当然也可以使用super()调用父类指定的构造方法
 *final关键字
 *用fianl修饰的类，不能被继承
 *用final修饰的方法 不能被子类所覆写
 *用final修饰的变量为常量，常量不可以修改
 *
 *使用static final修饰的常量为全局常量，是所有对象共同拥有的
 *
 *super 关键字
 *使用super调用父类的属性和方法
 */
class FuLei{
	
	private String name="jack";
	public int age=22;
	public FuLei(){
		System.out.println("父类的无参构造函数");
	}
	public FuLei(String name){
		this.name=name;
		System.out.println("父类的有参构造函数");
	}
	public void setName(String name){
		this.name=name;
	}
	 String getName(){
		return this.name;
	}
}
class ZiLei extends FuLei{
	final String COUNTRY="china";
	private String sex;
	public ZiLei(){
		System.out.println("子类的无参构造函数");
	}
	public ZiLei(String sex){
		
		this.sex=sex;
		System.out.println("子类的有参构造函数");
	}
	public void fun(){
		System.out.println("父类的name属性"+getName());
		System.out.println("父类的age属性"+age);
	}

	@Override
	public String getName() {
		String name="terry";
		return name;
	}
	
}
public class ExtendTest {
   public static void main(String[] args) {
	ZiLei ziLei=new ZiLei("man");
	ziLei.fun();
	System.out.println(ziLei.COUNTRY);
	
}
}
