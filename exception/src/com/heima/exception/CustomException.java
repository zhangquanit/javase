package com.heima.exception;
/**
  
  张全
 */

/*
在编写具体项目时，有一些项目当中出现的特有问题。
这些问题java并没有对应的描述。

这时怎么办呢？

依然明确了异常思想。那么就按照面向对象的思想将项目中的特有问题也封装成对象。

还要让这个对象具备可抛性。

所以这个对象必须是异常体系中的一员。
也就是说要继承Exception

这就是传说中的：自定义异常。



*/
//在我们的项目中，除数不能为负数。
//将该问题封装成对象，必须先要对问题描述。
/*
class FuShuException extends Exception
{
	private int num;
	FuShuException()
	{
		super();
	}
	FuShuException(String message)
	{
		super(message);
	}
	FuShuException(String message,int num)
	{
		super(message);
		this.num = num;
	}
	public int getNum()
	{
		return num;
	}
}
*/

//如果这个负数异常，发生，无法进行运行，不需要调用者处理。
//因为把该异常定义为运行时异常。
class FuShuException extends RuntimeException
{
	FuShuException(String message)
	{
		super(message);
	}
}
/*
class Demo
{
	int div(int a,int b)throws FuShuException
	{
		if(b<0)
			throw new FuShuException("除数为负数啦",b);
		return a/b;
	}
}
*/
class Demo4
{
	int div(int a,int b)
	{
		if(b<0)
			throw new FuShuException("除数为负数啦");
		return a/b;
	}
}



class CustomException 
{
	public static void main(String[] args) //throws FuShuException
	{

		Demo4 d = new Demo4();
		int x = d.div(4,-9);
		System.out.println("x="+x);		
		System.out.println("over");
		/*
		Demo d = new Demo();
		try
		{
			int x = d.div(4,-9);
			System.out.println("x="+x);
		}
		catch (FuShuException e)
		{
			System.out.println(e.toString());
			System.out.println("message:"+e.getMessage());
			System.out.println("Num:"+e.getNum());
		}
		
		System.out.println("over");
		*/
	}
}

/*
class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
class Student extends Person
{
	Student(String name)
	{
		super(name);
	}
}

class Throwable
{
	private String message;
	Throwable(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return messsage;
	}
}

class Exception extends Throwable
{
	Exception(String message)
	{
		super(message);
	}
}
class FuShu extends Exception
{
	FuShu(String message)
	{
		super(message);
	}
}
*/