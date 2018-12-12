package com.terry.test;
/**
  
  张全

 */
public class MyQueueTest <E>{
  private Object[] arr;
  private int insert=-1;
  private int take=0;
  private int elements;
  private int size;
  public MyQueueTest(int size){
	  arr=new Object[size];
	  this.size=size;
  }
  public void add(E e){
	  arr[++insert]=e;
	  elements++;
  }
  public E take(){
	  E element=(E)arr[take++];
	  elements--;
	  return element;
  }
  
  public boolean isFull(){
	 return  elements==size;
  }
  public boolean isEmpty(){
	  return elements==0;
  }
}
