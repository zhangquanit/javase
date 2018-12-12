package com.terry.data;

import javax.swing.text.TabableView;

/**
  
 递归
 方法调用方法自己
 */
public class DiGui {
	
	public static void main(String[] args) {
//		test(0);
		System.out.println("xxxxxxxxxxxxxxx不使用递归完成xxxxxxxxxxxxxxxxxxx");
		SanJiaoTest test=new SanJiaoTest();
		System.out.println(test.sanjiao(1));
		System.out.println(test.sanjiao(2));
		System.out.println(test.sanjiao(3));
		System.out.println(test.sanjiao(4));
		System.out.println("xxxxxxxxxxxxxxx使用递归完成xxxxxxxxxxxxxxxxxxx");
		System.out.println(test.recursive(1)); 
		System.out.println(test.recursive(2)); 
		System.out.println(test.recursive(3)); 
		System.out.println(test.recursive(4)); 
		
		System.out.println("xxxxxxxxxxxxxxxxxxxFibonacci数列xxxxxxxxxxxxxxxxxxxxx");
		FibonacciTest fibonacciTest=new FibonacciTest();
		System.out.println(fibonacciTest.fibonacci(1));
		System.out.println(fibonacciTest.fibonacci(2));
		System.out.println(fibonacciTest.fibonacci(3));
		System.out.println(fibonacciTest.fibonacci(4));
	}
	
	/**
	 * 递归的执行顺序
	 *  hello world==0
		hello world==1
		hello world==2
		hello world==3
		hello world==4
		hello java==5
		hello java==4
		hello java==3
		hello java==2
		hello java==1
	 */
	public static void test(int i){
		if(i<5){
			System.out.println("hello world=="+i);
			test(++i);  //调用自己  当无法再调用自己时  再逐渐回调
			System.out.println("hello java=="+i);
		}
	}
	
	/**
	 * 三角数字
	 * 核心：数列中的第一项为1，第n项由n-1项加n得到
	 * 1 3 6 10 15
	 */
	static class SanJiaoTest{
		
		//1,3,6,10
		public  int sanjiao(int i){
			int total=0;
			while(i>0){
				total=total+i;
				i--;
			}
			return total;
		}
		/**
		 * 使用递归完成
		 */
		public int recursive(int n){
		  if(n==1){
			  return 1;
		  }else{
			  return n+recursive(--n);
		  }
		}
		
	}
	
	/**
	 * Fibonacci数列
	 * 核心：第1,2项为1,第n项由n-1项加n-2项得到
	 * 
	 */
	static class FibonacciTest{
		public int fibonacci(int n){
			if(n==1||n==2){
				return 1;
			}else{
				return fibonacci(n-1)+fibonacci(n-2);
			}
		}
	}
	
}
