package com.heima.exception;

/*
异常：不正常。
		是程序在运行过程中发生的不正常情况：异常

           1.将异常信息封装成对象
就是程序运行中出现的问题。对于java而言，万物皆对象，java问题也封装成了对象。
因为问题中包含着问题的名称，问题的信息，问题出现的位置等内容。
包含的内容很多都是问题内部的内容。所以为了方便于对问题的操作，
就将这些内容都封装到一个实体当中。
这就是将问题封装成对象的原因。 

           2.共性向上抽取形成体系
问题有很多种,而且问题中有共性内容。
就不断的向上抽取，就形成了异常体系。
而体系中，有可以处理问题，也有不需要针对性处理的问题。

所以分成两大派。
两大派中也有很多子类，意味着，java对一些已知的问题都进行描述，和对象的封装。

Throwable
	|--Exception ：通常都是对可以进行针对性处理的问题的描述。由程序代码引起 		
	|--Error:如果程序中出现error，一般不编写针对性的处理代码。
				因为error都是jvm抛出的。不是程序代码引起的

技巧：异常或者错误它们的子类名的后缀名都是父类名,这样就容易区分异常和错误。
      xxxException    xxxError

特点：
对于Throwable体系中的成员，都有一个特有特点：可以被两个关键字所操作，一个是throws一个是throw
这样就体现了这个体系的特点：无论该体系中的类，或者该类的对象，都具备可抛性。


什么时候用try,什么时候throws 抛出异常
  自己能处理就try....catch
  不能处理的就抛出去


*/
class Demo
{

	/*
	 * 4.当认为开发的功能容易出现问题。那么可以对出现的问题在函数上声明。
	 * 方便于调用者在使用该功能是进行预先的处理 
	 * 声明问题，需要使用一个关键字 throws 异常类名
	 * 
	 * throws 抛出异常 ，强制调用者进行处理,因为调用者只关心该方法的功能,而不关注该方法内部细节,所以不应该
	 * 在方法内部处理, 让调用者根据需要去处理
	 */
	
	int div(int a,int b)throws Exception
	{
		return a/b;
	}
}

class ExceptionDemo 
{
	public static void main(String[] args)// throws Exception
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,0);
			System.out.println("x="+x);
		}
		catch (Exception e)
		{   //异常处理
			System.out.println("处理异常，被零除了");
			
			
			e.printStackTrace();//打印信息，名称，位置到控制台。还可以存储到文件中。
			//jvm的默认异常处理机制其实就是调用了产生的异常对象的printStackTrace方法。

		}
		
	
		System.out.println("Hello World!");
	}
}
/*
java除了提供了throws将异常抛出以外，还提供了一种针对性的异常的处理方式。
try catch finally

格式：
try
{
	需要被检测的代码。
}
catch(异常类 变量)
{
	异常处理的代码。
}
finally
{
	一定会被执行的代码；
}
*/
