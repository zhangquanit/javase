package com.cn.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

class Person{
	public String username;
	public String password;
	private int age;
	
	public String string="ball";
	public String string2="basketball";
	public String string3="terry";
	public int[] nums={1,2,3,4};
	public Person(){}
	public Person(String username,String password){
		this.username=username;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [username=" + username + ", password=" + password
				+ ", age=" + age + "]";
	}
	public int[] getNums() {
		return nums;
	}
	public void setNums(int[] nums) {
		this.nums = nums;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
public class OneFlect {
  public static void main(String[] args) throws Exception{
/*
 * 访问私有的   decaled	  
 */
	  
   Class perClass=Person.class;
   
   //1.Constructor
/*  Constructor<Person>[] constructors= perClass.getConstructors();//得到所有的构造方法
  Constructor<Person> constructor=perClass.getConstructor(String.class,String.class);//得到指定参数类型的构造方法
  Person person= constructor.newInstance("terry","man"); //创建实例
  Person person2=(Person)perClass.newInstance();//利用Class的newInstance()方法
  System.out.println(constructor.getModifiers());//得到构造方法的修饰符
   System.out.println(person.getUsername()+","+person.getPassword());*/
   
   //.2 Field   
   /*Field[] field=perClass.getFields(); 
   Field field2=perClass.getField("username");
   Field field3=perClass.getDeclaredField("age"); //访问私有属性
    field3.setAccessible(true);  //设置为可访问
    System.out.println(field3.getName());//得到变量名
    System.out.println(field2+","+field3);//public java.lang.String com.cn.reflect.Person.username
    
    Person person=new Person("terry", "1999");
    person.setAge(23);
   
    String username=(String)field2.get(person);//得到指定字段类型的值
    int age=(Integer)field3.get(person); //或者 int age2= field3.getInt(person);
    
    System.out.println("username="+username+",age="+age);*/
    
   //练习  将Person类中所有String类型字段的值中的b改成a
   Person person=new Person();
    changeValue(person);
    System.out.println(person.string+":"+person.string2+":"+person.string3);

    
    //3. Method
/*   Method[] methods=perClass.getMethods();
   Method method=perClass.getMethod("setUsername", String.class);//调用指定方法，后面参数表示传入的参数类型
   method.invoke(person, "jack");//调用方法 并传递方法参数
  System.out.println( person.getUsername());
  
  Method method2=perClass.getMethod("setNums", int[].class);//调用指定方法，后面参数表示传入的参数类型
    method2.invoke(person, new Object[]{new int[]{1,2,3}});//调用方法 并传递方法参数
    method2.invoke(person, (Object)new int[]{1,2,3});
    
  System.out.println(person.getNums().length);*/
  
   //4.数组的反射  传入任何对象都可以打印  如果是数组就逐个打印 如果是单个对象就直接打印   
/*    String string="134";
    Person person2=new Person("terry","woman");
    String[] strs={"a","b","c"};
    printObj(string);
    printObj(person2);
    printObj(strs);
    */
    //5.HashSet和Hashcode
    Collection collection=new HashSet<Person>();
    Person per1=new Person("terry","111");
    Person per2=new Person("jack","222");
    Person per3=new Person("tom","333");
    Person per4=new Person("terry","111");
    collection.add(per1);
    collection.add(per2);
    collection.add(per3);
    collection.add(per4);
    
   per1.password="222"; //改变参与hashcode计算的字段 对象修改后的哈希值就与最初储存进HashSet集合中时的哈希值就不同了
   collection.remove(per1);//并没有remoce掉
    System.out.println(collection.size());//如果Person类实现了hashcode  则相同的对象不能插入HashSet中
    
    
}
    
  

	public static void changeValue(Object obj)throws Exception {
		Field[] field = obj.getClass().getDeclaredFields();
		for (Field field2 : field) {

			if (field2.getType().getName().equals("java.lang.String")) {
				String string = (String) field2.get(obj);// 取值
				if (string != null) {
					string = string.replace("b", "a");
					field2.set(obj, string); // 给该对象设置

				}
			}
		}

	}

	//数组的反射
 public static void printObj(Object obj){
	 Class cla=obj.getClass();
	 if(cla.isArray()){ //如果是数组
		int len= Array.getLength(obj);
		 for(int i=0;i<len;i++){
			 System.out.println(Array.get(obj, i));
		 }
	 }else{ //如果只是单个对象
		 System.out.println(obj);
	 }
 }

}












