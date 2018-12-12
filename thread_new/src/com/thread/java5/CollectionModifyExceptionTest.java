package com.thread.java5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 *传统集合在迭代时不能对集合进行修改,如果需要在迭代时对集合进行修改 可以使用同步集合类
 * ConcurrentHashMap、           HashMap的同步类
 * ConcurrentSkipListMap、    TreeMap的同步类
 * ConcurrentSkipListSet、    TreeSet的同步类
 * CopyOnWriteArrayList     ArrayList的同步类
 *  CopyOnWriteArraySet     
 */
public class CollectionModifyExceptionTest {
	public static void main(String[] args) {
		Collection users = new CopyOnWriteArrayList();
//		Collection users = new ArrayList<User>();
			
		users.add(new User("张三",28));	
		users.add(new User("李四",25));			
		users.add(new User("王五",31));	
		Iterator itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			User user = (User)itrUsers.next();
			System.out.println(user.getName());
			if("张三".equals(user.getName())){ //第1个元素
				users.remove(user); //如果是Arraylist则会报错
			} else {
				System.out.println(user);				
			}
		}
	}
}	 
