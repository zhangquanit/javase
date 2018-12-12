package com.cn.generics;
/**
 * 泛型接口
 *
 */
interface Student<T>{
	public abstract T getInfo();
}
//实现类和接口都使用泛型
class StudentImpl<T> implements Student<T>{
    private T t;
	@Override
	public T getInfo() {
		// TODO Auto-generated method stub
		return t;
	}
	public void setT(T t){
		this.t=t;
	}
}
//实现类指定泛型类型
class StudentA implements Student<String>{

	@Override
	public String getInfo() {
		String info="字符串";
		return info;
	}
	
}
class StudentB implements Student<Integer>{
 
	@Override
	public Integer getInfo() {
		int i=10;
		return i;
	}
	
}
public class GenericTest3 {
 public static void main(String[] args) {
	 //实现类和接口都使用泛型类型
	 Student<String> stu=new StudentImpl<String>();
	  //实现类指定泛型类型  
	  Student<String> student=new StudentA();
	  Student<Integer> studentB=new StudentB();
	  System.out.println(student.getInfo());
	  System.out.println(studentB.getInfo());
	  
}
}
