package cn.itcast.day1;

//import static java.lang.Math.max;
import static java.lang.Math.*;
import cn.itcast.day2.AnnotationTest;

public class StaticImport {
/**
 * 静态导入
 * @param args
 */
	public static void main(String[] args){
		
		AnnotationTest.sayHello();
		int x = 1;
		try {
			x++;
		} finally {
			System.out.println("template");
		}
		System.out.println(x);
		
		
		System.out.println(max(3, 6));
		System.out.println(abs(3 - 6));
	
		
	}
	//模板代码  输入fun  则打印出下面的代码
	public void testTemplate() {
		System.out.println("这是模板代码");
	}
}
