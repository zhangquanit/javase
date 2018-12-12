package com.cn.javase;

import java.io.UTFDataFormatException;
import java.util.Arrays;

/**    数组
 * 1.数组
 * 数组是一组相关数据的集合，一个数组实际上就是一连串的变量，数组按照使用可以分为一维数组，二维数组，多维数组
 * 2.数组的优点
 * 不使用数组声明100个整型变量：int i1,int i2,.........int i100.
 * 使用数组定义：int i[100]
 * 3.要使用java数组，必须经过两个步骤：
 *    1）声明数组                                           数据类型  数组名=null                 int[] i=null; //声明一个数组 数组名保存在栈内存中
 *    2）分配内存给该数组                       数组名=new 数据类型[长度]             i=new int[3];//为数组开辟空间
 * 4.数组是引用数据类型，引用传递的就是一个内存的使用权，一块内存空间，可能有多个人同时使用。
 * 通过new关键字开辟堆内存空间，之后将此堆内存空间的使用权交给了对应的栈内存空间，而且一个堆内存空间可以同时
 * 被多个栈内存空间引用。
 */
public class ArrayTest {
	
   public static void main(String[] args) {
	   
	   //1.求数组的最大值和最小值
     int[] arr={1,3,12,435,34,23,12,34,121,2,324234};
     int max=arr[0];
     int min=arr[0];
     
     for(int i=1;i<arr.length;i++){
    	 max=max>arr[i]?max:arr[i];
    	 min=min<arr[i]?min:arr[i];
     }
     System.out.println("max="+max+" ,min="+min);
     
     //2.数组的排序
    
     for(int i=1;i<arr.length;i++){
    	 for(int j=0;j<arr.length;j++){
    		 if(arr[i]>arr[j]){
    			 int temp=arr[i];
    			arr[i]=arr[j] ;
    			arr[j]=temp;
    		 }
    	 }
     }
     for (int i:arr) {
		System.out.print(i+" ");
	}
   
     System.out.println();
     //3.二维数组的打印
   int[][] arr2={{1,2,3},{4,5,6},{7,8,9}};
   for(int i=0;i<arr2.length;i++){
	   for(int j=0;j<arr2[i].length;j++){
		   System.out.println(arr2[i][j]);
	   }
   }
   //4.字符型数组  可以直接打印
   char[] ch={'a','b','c','d'};
   System.out.println(ch);
   //5.通过引用传递改变该char型数组的值
   replaceChar(ch); 
   System.out.println(ch); 
   
   //6.数组的排序    java.util.Arrays.sort(); 正序排序
   int[] ii={1,2,32,23,43,12,2,3,1,32};
   Arrays.sort(ii);
   for(int i:ii){
	   System.out.print(i+" ");
   }
   System.out.println();
   //7.数组的拷贝 System.arrayCopy()
   int[] src={1,2,3,4,5,6,7,8};
   int[] target={11,12,13,14,15};
   System.arraycopy(src, 0, target, 0, 3);
   for(int i:target){
	   System.out.print(i+" ");//1 2 3 14 15 
   }   
   System.out.println();
   
   //8.Java新特性对数组的支持         可变参数和foreach
   Object[] objects=getArray(1,"terry",'男');
   for(Object obj:objects){
	   System.out.print(obj+" ");
   }
}
   public static char[] replaceChar(char[] cha){
	   cha[1]='e';
	   return cha;
   }
   //可变参数
   public static Object[] getArray(Object...args){
	   Object[] objects=null;
	   if(args.length==0){
		   return null;
	   }else{
		   objects=new Object[args.length];
		   for(int i=0;i<args.length;i++){
			   objects[i]=args[i];
		   }
	   }
	   return objects;
   }
}
