package com.cn.generics;

/**泛型
 * 1.产生意义：为了保证数据的安全性
 * 比如现在一个方法的返回者是Object，如果该数据本来是String，而我们强制转换为Integer 则会出错
 */
class Test1{
	private Object obj;
	public Test1(Object obj){
		this.obj=obj;
	}
	public Object getObj(){
		return this.obj;
	}
}

public class GenericTest {
  public static void main(String[] args) {
	    try{
	    Test1 test1=new Test1("123"); //可以设置任何值
	    int a=(Integer)test1.getObj();//编译没有错误  因为返回值是Object类型  可以转换为任何类型
	   //运行错误 ，类型转换错误  不能将String类型转换为Integer类型。
	    }catch (Exception e) {
			System.out.println( e);
		}
	    //1.使用泛型  保证数据的安全性
	    Test2<String, Integer> test2=new Test2<String, Integer>();
	    test2.setUsername("jack");
	    test2.setPassword(123);
	   String username= test2.getUsername();
	   int password=test2.getPassword();
	   System.out.println("username="+username+",password="+password);
}
}
//泛型类
class Test2<T,K>{
  private T username;
  private K password;
public T getUsername() {
	return username;
}
public void setUsername(T username) {
	this.username = username;
}
public K getPassword() {
	return password;
}
public void setPassword(K password) {
	this.password = password;
}
  
}

