package com.heima.exception;
/**
  
  张全
 */
public class MutiExceptionDemo {
	/*

	异常处理的规则：

	功能上标示了几个异常，调用者就要对几个异常进行处理。这样就可以在不同的异常发生时进行不同的处理

	注意：多catch时，父类的catch往下放(子类到父类的顺序)。


	*/
	public static void main(String[] args) // throws Exception
	{
		Demo1 d = new Demo1();
		try
		{
			int x = d.div(4,4);
			System.out.println("x="+x);
		}
		

		catch (ArithmeticException e)//Exception e = new ArithmeticException("/ by zero");
		{
			System.out.println("处理异常，被零除了");
			System.out.println("Message:"+e.getMessage());//获取异常信息，
			System.out.println("ToString:"+e.toString());//获取异常的名称和异常的信息。

			e.printStackTrace();//打印信息，名称，位置到控制台。还可以存储到文件中。
								//jvm的默认异常处理机制其实就是调用了产生的异常对象的printStackTrace方法。

								
		}
		catch(ArrayIndexOutOfBoundsException e)
		{  
			System.out.println("越界啦");
			System.out.println(e.toString());
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		System.out.println("Hello world");
	}
	}
class Demo1
{
	int div(int a,int b)throws ArithmeticException,ArrayIndexOutOfBoundsException,Exception
	{
		int[] arr = new int[a];
		System.out.println(arr[b]);
		return a/b;
	}
}
