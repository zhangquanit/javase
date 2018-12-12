package cn.itcast.day2;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import cn.itcast.day1.ReflectPoint;

public class GenericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//1.没有指定参数，可添加任何类型的参数
		ArrayList collection1 = new ArrayList();
		collection1.add(1);
		collection1.add(1L);
		collection1.add("abc");
		//int i = (Integer)collection1.get(1);
		
		//2、指定参数类型
		ArrayList<String> collection2 = new ArrayList<String>();
		//collection2.add(1);
		//collection2.add(1L);
		collection2.add("abc");
		String element = collection2.get(0);	
		
		
		//3、泛型是给编译器看的  编译完成后就会丢掉该泛型标示，通过反射传入字符串(跳过编译器检查)
		ArrayList<Integer> collection3 = new ArrayList<Integer>();
		System.out.println(collection3.getClass() == collection2.getClass());
		//collection3.add("abc");
		collection3.getClass().getMethod("add", Object.class).invoke(collection3, "abc");
		System.out.println(collection3.get(0));
		
		printCollection(collection3);
		
		//Class<Number> x = String.class.asSubclass(Number.class);
		Class<?> y;
		Class<String> x ;//Class.forName("java.lang.String");
		
		//基本数据类型的自动装箱
		add(3,5);
		Number x1 = add(3.5,3);//Float Integer的最大交集类型是Number
		Object x2 = add(3,"abc");//Integer String的最大交集类型只能是Object
		
		//只有引用类型才能作为泛型方法的参数,基本数据类型可以自动装箱成对应的类类型比如int->Integer
		swap(new String[]{"abc","xyz","itcast"},1,2);
		//swap(new int[]{1,3,5,4,5},3,4);//int[]数组本身就是一个对象了  这时不会自动装箱成Integer
//		Integer[] ii=new int[]{1};//int[]数组对象不能用Integer[]数组对象接收
		
		Object obj = "abc";
		String x3 = autoConvert(obj);
		
		copy1(new Vector<String>(),new String[10]);
		copy2(new Date[10],new String[10]);		
//		copy1(new Vector<Date>(),new String[10]);
		
		GenericDao<ReflectPoint> dao = new GenericDao<ReflectPoint>();
		dao.add(new ReflectPoint(3,3));		
		//String s = dao.findById(1);
		
		//Vector<Date> v1 = new Vector<Date>();
		Method applyMethod = GenericTest.class.getMethod("applyVector", Vector.class);
		Type[] types = applyMethod.getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType)types[0];
		System.out.println(pType.getRawType());
		System.out.println(pType.getActualTypeArguments()[0]);
	}
	
	public static void applyVector(Vector<Date> v1){
		
	}

	
	private static <T> void fillArray(T[] a,T obj){
		for(int i=0;i<a.length;i++){
			a[i] = obj;
		}
	}
	private static <T> T autoConvert(Object obj){
		return (T)obj;
	}
	private static <T> void swap(T[] a,int i,int j){
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static <T> T add(T x,T y){
		return null;
	}
	
	/**
	 * 通配符接收任意类型的参数
	 * @param collection
	 */
	public static void printCollection(Collection<?> collection){
//		collection.add(1);//编译报错，add方法指定了参数类型，而通配符?不能指定具体参数类型
		System.out.println(collection.size());
		for(Object obj : collection){
			System.out.println(obj);
		}
	}
	
	public static <T> void printCollection2(Collection<T> collection){
//		collection.add(1);
		System.out.println(collection.size());
		for(T t : collection){
			System.out.println(t);
		}

	}
	
	
	public static <T> void copy1(Collection<T> dest,T[] src){
		for(T t:src){
			dest.add(t);
		}
	}
	
	/**
	 * 无返回值的泛型方法，泛型参数可以是不同的类型，比如copy(new Date[]{},new String[]{})
	 * @param dest
	 * @param src
	 */
	public static <T> void copy2(T[] dest,T[] src){
		for(int i=0;i<src.length;i++){
			dest[i]=src[i];
		}
	}	
}
