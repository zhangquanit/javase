package com.cn.javase;

/**
 * String
 * 1.一个字符串就是一个匿名对象，字符串的内容一旦声明则不可改变
 *   字符串内容的改变，改变的是内存地址的引用关系,所以应避免如下操作
 *   String string ="";
	for(int i=0;i<100;i++){
		string+=i; //这样的操作要断开-连接引用100次才可以完成，这样的操作性能很低应避免使用。
		            应使用StringBuffer或StringBuilder完成
	}
	  System.out.println(string);
 */

public class StringTest {
	public static void main(String[] args) {
		  String str="hello";
		  String str2="hello";
		  
		  System.out.println(""+(str==str2));//true
		  str=str+"world"; //已经开辟了3个堆内存空间  hello  world   helloworld 最后指向的是helloworld
		  System.out.println(""+(str=="helloworld"));
		  
		  //对象的引用关系
		  Father father=new Father("父亲", 50);
		  Father child=new Father("儿子", 20);
		  Book book=new Book("JAVA编程", "22.5");
		  father.setChild(child);//父亲有一个儿子
		  child.setBook(book);  // 儿子有一本书
		 System.out.println(father.getChild().getBook()); 

	         
	}  
}
class Father{
	public String name;
	public int age;
	public Father child; //自己对自己的引用
	public Book book;    //对其他类的引用
	public Father(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Father getChild() {
		return child;
	}
	public void setChild(Father child) {
		this.child = child;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Father [name=" + name + ", age=" + age + "]";
	}
	
}
class Book{
	public String bookName;
	public String bookTitle;
	
	
	public Book(String bookName, String bookTitle) {
		super();
		this.bookName = bookName;
		this.bookTitle = bookTitle;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookTitle=" + bookTitle + "]";
	}
	
}

