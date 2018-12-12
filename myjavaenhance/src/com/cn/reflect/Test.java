package com.cn.reflect;
 /**
   
  @author 张全
 */
public class Test {

	public static void main(String[] args) {
		test(1,2,3);
		test(new int[]{1,2,3});
	}
	public static void test(int...args){
		int length = args.length;
		for(int i=0;i<length;i++){
			int j = args[i];
			System.out.println(j);
		}
	}
}
