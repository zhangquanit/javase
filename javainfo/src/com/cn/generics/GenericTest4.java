package com.cn.generics;

import java.io.ObjectInputStream.GetField;

/**
 * 泛型方法
 *
 */
class Demo{
    //无返回值的泛型方法
	public<T> void set(T t){
		System.out.println(t);
	}
	//有返回值的泛型方法
	public <K> K get(K k){
		return k;
	}
}
public class GenericTest4 {

}
