package com.terry.test;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 张全
 */
public class LinkTest {

	public static void main(String[] args) {

		System.out.println("............Link start");
		MyLink link = new MyLink<Integer>(1);
		MyLink link2 = new MyLink<Integer>(2);
		MyLink link3 = new MyLink<Integer>(3);
		MyLink link4 = new MyLink<Integer>(4);

		link.setNext(link2);
		link2.setNext(link3);
		link3.setNext(link4);

		MyLink next = link;
		while (true) {
			if (null != next) {
				System.out.println(next.getData());
				next = next.getNext();
			} else {
				break;
			}
		}
		System.out.println("............Link end");
		
		System.out.println();
		System.out.println("............LinkList start");
       
		MyLinkList linkList=new MyLinkList();
		linkList.insert(1);
		linkList.insert(2);
		linkList.insert(3);
		linkList.insert(4);
		
		linkList.print();
		
		int pos=1;
		System.out.println();
		System.out.println("在第"+pos+"位插入");
		linkList.insert(5, pos);
		linkList.print();
		
		System.out.println();
		linkList.query(3).getData();
	}

	static class MyLink<E> {
		private E e;
		private MyLink next;

		public MyLink(E e) {
			this.e = e;
		}

		public E getData() {
			return e;
		}

		public void setData(E e) {
			this.e = e;
		}

		public MyLink getNext() {
			return next;
		}

		public void setNext(MyLink next) {
			this.next = next;
		}

	}

	static class MyLinkList {
		private MyLink first;

		public void insert(int value) {
			MyLink link=new MyLink(value);
           if(null==first){
        	   first=link;
           }else{
        	   link.setNext(first);
        	   first=link;
           }
		}
		
		public void insert(int value,int pos) {
            if(pos==0){
            	insert(value);
            }else{
            	MyLink link=first;
            	for(int i=0;i<pos-1;i++){
            		link=link.getNext();
            	}
            	
            	MyLink now=new MyLink(value);
            	now.setNext(link.getNext());
            	link.setNext(now);
            }
		}
		
		public void print(){
			if(null==first)return;
			MyLink link=first;
			while(true){
				System.out.print(link.getData()+" ");
				link=link.getNext();
				if(null==link)return;
			}
		}
		

		public MyLink query(int value) {
			MyLink now=new MyLink(value);
			MyLink link=first;
			while((Integer)first.getData()!=value){
				 link=link.getNext();
				 if(null==link)break;
			}
			
			return link;
		}

		public void delete(int value) {
			MyLink now=new MyLink(value);
			MyLink link=first;
			MyLink ago=first;
			while((Integer)first.getData()!=value){
				 ago=link;
				 link=link.getNext();
				 if(null==link)return;
			}
			if(first==link){
				first=first.getNext();
			}else{
				ago.setNext(now.getNext());
			}
		}
	}
}
