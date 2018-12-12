package com.cn.javase;
/**
 * 面向对象
 *1.三大特征：
 *  封装：对外部不可见 ，可以保护程序中的某些内容
 *  继承：扩展类的功能
 *  多态：方法的重载，对象的多态性
 *2.类是引用数据类型，理解其栈内存和堆内存的引用关系
 *   Person person=null; //对象的声明  将该对象名保存在栈内存中
 *   person=new Person();//通过new实例化对象，在堆中开辟空间，所有的内容都是默认值(成员属性)
 *   对象是保存在栈内存中，属性是保存在堆内存之中的。在程序中所有的方法都是保存在全局代码区之中的，此区中
 *   的内容是所有对象共享的。
 *3.对象间的引用传递：实际上传递的就是堆内存空间的使用权
 *   Person1 per1=new Person1();
 *   Person1 per2=new Person1();
 *   per2=per1;将per1的堆内存空间使用权给per2，则per2和per1共享同一堆内存空间中的数据(name,age)
 *   因为per2改变了指向，所以其原本的内存空间就没有任何栈的引用，则这样的内存就被称为垃圾。等待垃圾收集机制
 *   进行回收GC
 *4.封装的实现：用private修饰属性和方法，使用set设置和get取值，在set方法中可以加入验证
 *5.构造方法
 *  只要有对象实例化，则会调用构造方法  每个类中都有至少一个构造方法
 *  构造方法的主要目的是为类中的  属性初始化。
 *  
 *  匿名对象：在JAVA中如果一个对象只使用一次，则就可以将其定义成匿名对象
 *  所谓的匿名对象就是比之前的对象少了栈内存空间的引用。只开辟了堆内存空间
 */
class Person1{
	public String name;
	public int age;
	public void tell(){
		System.out.println("name="+name+",age="+age);
	}
}
public class OOB {
  public static void main(String[] args) {
	Person1 per1=new Person1();
	per1.name="jack";
	per1.age=22;
	Person1 per2=new Person1();
	per2=per1; //将per1的堆内存空间使用权给per2，则per2和per1共享同一堆内存空间中的数据(name,age)
	per2.tell();
	
	per2.name="terry"; //改变per2的值，那么per1的值也会改变
	per1.tell();
}
}
