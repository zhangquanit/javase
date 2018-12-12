package com.terry.data;
/**
 栈
 栈只允许访问一个数据项,也就是最后插入的数据项,只有移除了这个数据项才能够访问倒数第2个插入的数据项
 也就是先进后出的顺序/后进先出
 好比往一个盒子里放东西,最先放的东西只有最后才能拿出来
 */
public class StackTest {
    int[] array;
    int maxSize=100;
    int top=-1;
	 public StackTest(){
		 array=new int[maxSize];
		 top=-1;
	 }
	 //1.压入数据
	 public void push(int value){
		 array[++top]=value;//等价于 top+=1;array[top]=value;
	 }
	 //2.弹出数据
	 public int  pop(){
		 return array[top--];//返回array[top],然后top-=1;
	 }
	 //3.访问栈顶数据
	 public int peek(){
		 return array[top];
	 }
	 //4.栈是否为空
	 public boolean isEmpty(){
		 return top==-1;
	 }
	 //5.栈是否满了
	 public boolean isFull(){
		 return top==maxSize-1;
	 }
}


