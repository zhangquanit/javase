package com.cn.javase;

class Person{
	public static String USERNAME="zhangquan";
	public static final String PASSWORD="123";
	
}
class Man{
	
}
public class VariableTest {
 public static void main(String[] args) {
	 //类的成员变量是可以改变值的，常量(用final修饰的)则不可以
	System.out.println(Person.USERNAME);
	Person.USERNAME="jack";
	System.out.println(Person.USERNAME);

	System.out.println("10%2.2="+(10%2.2));
	//% 取模操作   最大作用就是让结果数据在 0-除数 之间来回循环    %2则可以用于判断奇偶数
	int i=0;
	while(true){
		i++;
		System.out.println(i%5);//则结果在0,1,2,3,4之间来回循环
		if(i==10){
			break;
		}
	}
  //递增或递减    写在后面表示 先使用变量之后 再进行自增或自减的操作
	int a=10;
	System.out.println(a++);//10  当前a的值是10，然后再加1
	System.out.println(a); //11
	int b=10;
	System.out.println(++b);//11
	System.out.println(b);  //11

   /*
    * 条件语句
    * 1. if          本身只有一种结果
    * 2. if...else   本身只有两种结果
    *  三目运算符，变相的if...else
    *  变量=条件?表达式1：表达式2
    * 3.if..else if...else if...else  多条件判断
    * 如果判断的表达式中使用的是   数据或字符，则可以使用switch() case 来代替
    */
	
  /* 循环语句
   * 1.while循环                   事先不知道循环该执行多少次的时候
   * 2.do...while循环      也是事先不知道循环该执行多少次，不过至少会执行一次循环主体
   * 3.for循环                         明确的知道了循环次数
   * 4.增强的for
   */
	
	
}
 
}
