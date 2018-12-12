package com.cn.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OneGeneric {
	
	public static void main(String[] args)throws Exception {
		/*
		 * 验证泛型只是给编译器看的。
		 */
		
		//指定只能传入Integer类型
		ArrayList<Integer> list=new ArrayList<Integer>(); 
	
		//通过反射添加数据，从而绕过编译器，也可以添加其他类型。从而证明泛型存在于编译期间
		Class classObj=list.getClass();
		classObj.getMethod("add", Object.class).invoke(list, "abc");//通过反射传入字符串
		Object value=list.get(0); //abc
		
	   //2.通配符
		
	   //3.泛型方法   8中基本变量数组类型不能使用泛型  int[].......>T[]  这是不行的
		Integer integer=add(1, 2);
		Object object=add("1", 2);
		Object object2=add(1.5, true);
		
	   swap(new String[]{"1","2","3"}, 0, 1);
//	   swap(new int[]{1,2,3}, 0, 1); //这是不行的 因为int[]数组就表示对象了，编译器是不会单独自动将int按引用对象接收
     
	   Object obj="222";
	   String string=autoConvert(obj); //前面用什么类型接收  则自动转换为给类型
	   
	   //4.通过反射获得泛型的实际类型参数   比如框架中，可以利用用户传入的参数类型然后查询后返回给用户相应的参数类型对象
	   
	   Method method=OneGeneric.class.getMethod("paramsGet", ArrayList.class);
	   Type[] types= method.getGenericParameterTypes();
	   ParameterizedType type=(ParameterizedType)types[0];
	   System.out.println(type.getRawType());//得到方法的原始参数类型
	   System.out.println(type.getActualTypeArguments()[0]);//得到方法参数中的实际类型
	  
	   
	}
	//泛型方法     必须在方法名前定义<T>
  public static <T> T add(T x,T y){//有返回值
	  return null;
  }
  public static <T> void add2(T x,T y){//无返回值
	  
  }
  public static <T> void swap(T[] a,int i,int j){//将数组中下标i和j的元素对换
	  T temp=a[i];
	  a[i]=a[j];
	  a[j]=temp;
  }
  public static <T> T autoConvert(Object obj){//按接收类型T对obj进行转换
	  return (T)obj;
  }
  
  //定义泛型类
  class Info<T,V>{
	 private T t;
	 private V v;
	 public Info(T t,V v){
		 this.t=t;
		 this.v=v;
	 }
	 public T getT(){
		 return t;
	 }
	 public V getV(){
		 return v;
	 }
  }
   //通过反射获得方法参数类型
  public static void paramsGet(ArrayList<String> list){
	  
  }
}
