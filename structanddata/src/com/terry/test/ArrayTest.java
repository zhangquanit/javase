package com.terry.test;


/**
 * @author 张全
 */
public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DiGuiTest.test(5);
	}

	static class DiGuiTest {
		/*
		 *  aaaaaaaa i=5
			aaaaaaaa i=4
			aaaaaaaa i=3
			aaaaaaaa i=2
			aaaaaaaa i=1
			bbbbbbbb i=0
			bbbbbbbb i=1
			bbbbbbbb i=2
			bbbbbbbb i=3
			bbbbbbbb i=4
		 */
		public static void test(int i){
			if(i>0){
				System.out.println("aaaaaaaa i="+i);
				test(--i);
				System.out.println("bbbbbbbb i="+i);
			}
		}
	}
}
