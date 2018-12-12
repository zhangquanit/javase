package com.terry.data;
/**
 利用栈实现单词逆序
 */
public class WordReverse {
	char[] array;
    int maxSize=100;
    int top=-1;
	 public WordReverse(){
		 array=new char[maxSize];
		 top=-1;
	 }
	 public WordReverse(int max){
		 array=new char[max];
		 maxSize=max;
		 top=-1;
	 }
	 //1.压入数据
	 public void push(char value){
		 array[++top]=value;//等价于 top+=1;array[top]=value;
	 }
	 //2.弹出数据
	 public char  pop(){
		 return array[top--];//返回array[top],然后top-=1;
	 }
	 //3.访问栈顶数据
	 public char peek(){
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
	 
	 /**
	  * 实现单词等逆序
	  */
	 public String doReverse(String word){
		 WordReverse wordReverse=new WordReverse(word.length());
		 for(int i=0;i<wordReverse.maxSize;i++){
			 wordReverse.push(word.charAt(i));
		 }
		 
		 String result="";
		 if(!wordReverse.isEmpty()){
		 for(int j=0;j<wordReverse.maxSize;j++){
			 result+=wordReverse.pop();
		 }
		 }
		 
		 return result;
	 }
	 
	 /**
	  * 测试
	  * @param args
	  */
	 public static void main(String[] args) {
		 String word="terry";
		WordReverse reverse=new WordReverse();
		System.out.println(reverse.doReverse(word));
	}
}
