package com.heima.exception;

/*
如果函数上标示了异常，调用者一定要进行处理，要么try，要么throws。否则编译失败。


注意：异常的分类：

异常分：
编译时被检测的异常。
	如果程序中出现了编译时被检测的异常，那么必须声明。并要给出处理方式，否则，编译失败。
	因为该异常是被编译器识别并检查的。
	
	对于编译时被检测的异常，都可以编写针对性的处理方式，进行处理(try...catch或throws抛出去)。



运行时异常。 
	编译器并不对该种异常进行检查。
	只在运行时，对该异常进行处理。 

	对于运行时异常，通常不编写针对性的处理方式，因为该种异常的发生，会导致运算失败，无法继续。
	只能让程序停止。让调用者对代码进行修正。 比如4/0 数学上运算是错误的 也没有结果  所以应该让程序
	停止

   
	
异常都所属Excption体系。
	只不过在该体系中有一个特殊的子体系。RuntimeException。
	除了RuntimeException及其子类外，剩下的Exception和其子类都是编译时异常。



异常处理：好处：将正常流程代码和错误处理代码进行分离。增加了阅读性。



*/
class Demo3
{
	int div(int a,int b)throws ArithmeticException
	{
//		if(b==0)
//			throw new ArithmeticException("除数为零啦！搞什么东西!");
		
		return a/b;
	}
}

class ExceptionDemo3 
{
	public static void main(String[] args) 
	{
		Demo3 d = new Demo3();

		
		int x = d.div(4,0);
		System.out.println("x="+x);
	

		System.out.println("over");
//		byte[] arr = new byte[1024*1024*900];

	}
}
/*
getIndex(null,3);



如果要在函数内进行问题的体现。
并因为参数的无效值导致运算无法继续，
应该将问题封装成了对象，并对其抛出，直接结束函数。运算不要在进行。

在函数内部抛出一个问题对象(异常).使用的是一个新的关键字 throw

public int getIndex(int[] arr,int key)//throws Exception
{
	if(arr==null)
//		return 
		throw new RuntimeException("数组不存在");// 抛出异常对象，结束函数。

	//如果arr==null  则下面的运算没有意义  由于得不到结果  则应该抛出异常对象 而且调用者也没办法处理该异常	
	for(int x=0; x<arr.length; x++)
	{
		if(arr[x]==key)
			return x;
	}
	return -1;

}*/


/*
throws 和throw的区别：
throws用在函数上，void show()throws Exception{}
后面抛出的异常类，而且可以抛出多个，用逗号隔开。
throws在函数上声明异常，可以让调用者知道，并告知调用者该功能有可能有问题。
所以标示throws是让调用者可以有预先的处理方式，即try...catch 或者继续抛出。



throw用在函数内，后面抛出的是异常对象。
被封装到了函数中。用于对于某一个条件满足后，直接结束函数。


void show()throws Exception
{
	throw new Exception();
}

处理原则：
函数内抛出什么异常，函数上就标示什么异常。

1）如果函数内是运行时异常(Runtime和Runtime的子类)，函数上可以不标示。

2）如果函数内的异常被try...catch处理了。函数上可以不用标示。

特殊：函数内抛出A异常，也许函数上要标示B异常。
		这就是异常转换 。也就是说将函数的异常，转化成调用者可以处理的异常标示出去。
		

*/