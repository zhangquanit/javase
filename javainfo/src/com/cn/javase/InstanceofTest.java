package com.cn.javase;
/**
 * 使用instanceof判断一个对象是否是某个类的实例
 * 在对象向下转型之前最好使用instanceof关键字去验证
 *
 */
class TestA{
	public String username;
	public void fun1(){
		System.out.println("TestA中的fun1方法");
	}
}
class TestB extends TestA{

	@Override
	public void fun1() {
	System.out.println("TestB中的fun1方法");
	}
	public void fun2(){
	System.out.println("TestB中的fun2方法");
	}
}
public class InstanceofTest {
    public static void main(String[] args) {
	  TestA testA=new TestB();//通过子类实例化的父类对象  即是父类实例又是子类实例
	  System.out.println(testA instanceof TestA); //true
	  System.out.println(testA instanceof TestB); //true
	  
	  TestA testA2=new TestA();//父类实例化的对象只是自身的实例
	  System.out.println(testA2 instanceof TestA);//true
	  System.out.println(testA2 instanceof TestB);//false
	  
	  TestB testB=new TestB(); //子类实例化的对象即是父类实例 又是自身实例
	  System.out.println(testB instanceof TestA);//true
	  System.out.println(testB instanceof TestB);//true
	  
	  System.out.println(testB);//getClass().getName() + "@" + Integer.toHexString(hashCode());
	  
	  String str="this is a test";
	  System.out.println(str.toString());// public String toString() {return this;}
	  
	  
    }
}

