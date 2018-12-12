package com.cn.javase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
   
  @author 张全
 */
public class ListTest {
	public static void main(String[] args) throws  Exception{
		ArrayList<String> list1 = new ArrayList<String>(3);
		list1.add("1");
		elementSize(list1);
		list1.add("2");
		elementSize(list1);
		list1.add("3");
		elementSize(list1);
		list1.add("4");
		elementSize(list1);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("5");
		list2.add("6");
		
		boolean retainAll = list1.retainAll(list2);//list1中与list2中相同的元素
		System.out.println(retainAll);
		System.out.println(list1);


	}

	 public static void elementSize(ArrayList list)throws  Exception{
		 Class<? extends ArrayList> cls = list.getClass();
		 Field field = cls.getDeclaredField("elementData");
		 if(!field.isAccessible())field.setAccessible(true);
		 Object[] array = (Object[]) field.get(list);
		 System.out.println("list.size="+list.size()+",array="+ Arrays.toString(array));
	 }

}
