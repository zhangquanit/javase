package com.cn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *         1.对象序列化
 * 一个对象产生之后，实际上是在内存中开辟了一个存储空间，方便存储信息。
 * 对象序列化，就是把一个对象变为二进制的数据流的一种方法，通过对象序列化可以方便的实现对象的传输和存储，如果
 * 一个类的对象想被序列化，则对象所在的类必须实现java.io.Serializable接口，该接口没有任何方法，属于一个标识
 * 接口，表示具备了某种能力。
 
 serialVersionUID:在对象进行序列化和反序列化操作的时候，要考虑JDK版本的问题，如果序列化的JDK版本和反序列化的
 版本不统一则就有可能造成异常，所以在序列化操作中引入了一个serialVersionUID的常量，可以通过此常量来验证版本的
 一致性，在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较
 如果相同则认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。
 
 注意：对象中的静态成员数据，不可以被序列化、
 在序列化操作的时候，如果某个属性不希望被序列化下来，则可以直接使用transient关键字声明
 */
 class People implements Serializable{ //则该类的对象可以被序列化

	private static final long serialVersionUID = 1L;
	private transient int age; //序列化对象时不希望该属性被序列化
	private  String name; 
	public People(){}
	public People(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void SetName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return this.age;
	}
	@Override
	public String toString() {
		return "People [age=" + age + ", name=" + name + "]";
	}
	
}
 /**
   2.对象的序列化和反序列化
   要想完成对象的输入和输出，还必须依靠对象输出流(ObjectOutputStream)和对象输入流(ObjectInputStream)
   使用对象输出流输出序列化对象的步骤，有时称为序列化，而使用对象输入流读入对象的过程，有时称为反序列化
 对象序列化依靠ObjectOutputStream    writeObject(Object obj)
 对象反序列化依靠ObjectInputStream   readObject()
 到底序列化了那些东西呢？
  所有对象拥有各自的属性值，但是所有的方法是公共的，所以序列化对象的时候实际上序列化的就是属性。
  
  3. 在序列化操作的时候，如果某个属性不希望被序列化下来，则可以直接使用transient关键字声明
  private transient int age;
  
  4.序列化一组对象
  对象输出只提供了一个对象的输出操作(writeObject(Object obj))，如果现在要同时序列化多个对象的时候就可以使用
  对象数组进行操作，因为数组属于应用数据类型，所以可以直接使用Object类型进行接收。
  
  注意：对象中的静态成员数据，不可以被序列化、
  */
public class SerizableTest {


	public static void main(String[] args)throws Exception {
		//1.序列化对象
		File file=new File("d:"+File.separator+"FileTest"+File.separator+"serializable.txt");
//	    OutputStream outputStream=new FileOutputStream(file);
//		ObjectOutputStream oos=new ObjectOutputStream(outputStream);
//		oos.writeObject(new People("张全",25)); //写入对象
//		oos.close();
//		
//		//2.反序列化对象
//		
//		InputStream inputStream=new FileInputStream(file);
//		ObjectInputStream ois=new ObjectInputStream(inputStream);
//		People person=(People)ois.readObject(); //读取对象
//
//		System.out.println("姓名:"+person.getName()+";年龄："+person.getAge());
		//没使用transient关键字的结果     姓名:张全;年龄：25
		//使用transient关键字后的结果  姓名:张全;年龄：0  由此可知age属性并没有被序列化
		
	    //3.序列化一组对象
		OutputStream outputStream=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(outputStream);
		People[] persons={new People("张三", 21),new People("李四", 22),new People("王五", 23)};
		oos.writeObject(persons);
		oos.close();
		//4.反序列一组对象
		InputStream inputStream=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(inputStream);
		People[] pers=(People[])ois.readObject();
		for(People people:pers){
			System.out.println(people);
		}
	}

	
}
