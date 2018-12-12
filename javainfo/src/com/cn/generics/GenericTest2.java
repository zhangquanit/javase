package com.cn.generics;
/**
 * 泛型的通配符和泛型上下限
 * ？可以接收任意类型
 *
 */
class Worker<K>{  //声明类的时候就要指定泛型参数
	private K k;  //泛型参数
	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

}
public class GenericTest2 {
   public static void main(String[] args) {
	  Worker<Integer > worker=new Worker<Integer>();
	  worker.setK(1);
	  fun(worker); //泛型类型必须一致 Integer不能使用Object接收
	  fun2(worker);//可以使用通配符? 接收任意类型
	  
	  //泛型上限    Integer是Number的子类
	  Worker2<Integer>  worker2=new Worker2<Integer>();
	  worker2.setV(3);
	  fun(worker2);
 }
     //泛型类型必须一致 Integer不能使用Object接收
   public static void fun(Worker<Integer> worker){ //必须是Integer  不能用Object
	   System.out.println(worker.getK());
   }
   //使用通配符 接收任意类型
   public static void fun2(Worker<?> worker){ 
	   System.out.println(worker.getK());
   }
   //泛型上限    只能接收Number或者Number的子类
   public static void fun(Worker2<? extends Number> worker){ 
	   System.out.println(worker.getV());
   }
 //泛型下限   只能接收Integer或者Integer的父类
   public static void fun2(Worker2<? super Integer> worker){ 
	   System.out.println(worker.getV());
   }
}
//使用泛型上限  只能接收Number或者Number的子类
class Worker2<V>{
	private V v;
	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}
	
}

	












