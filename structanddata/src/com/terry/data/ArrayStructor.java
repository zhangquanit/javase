package com.terry.data;

import java.util.Arrays;


/** 
 * 数组的相关操作
 * 在for循环中 
 * for(int i=index;i<num-1;i++){ //往前移动一位/左移一位
			array[i]=array[i+1];
		}
	for(int j=num;j>index;j--){ //往后移动一位/右移一位
			array[j]=array[j-1];
		}	
		
 * 
 * @author terry
 */
public class ArrayStructor {
	private int num;
	private int[] array;
	public ArrayStructor(){
		array=new int[100];
	}
	public ArrayStructor(int max){
		array=new int[max];
	}
	
	/**
	 * 增加
	 */
	public void insert(int value){
		if(num==Integer.MAX_VALUE) return;
		array[num]=value;
		num++;
		
	}
	/**
	 * 有序增加
	 */
	public void binaryInsert(int value){
		if(num==Integer.MAX_VALUE) return;
		int index;
		for(index=0;index<num;index++){
			if(array[index]>value){//直到数组元素比增加的元素大时
				break;
			}
		}
		for(int j=num;j>index;j--){ //往后移动一位
			array[j]=array[j-1];
		}
		array[index]=value;
		num++;
	}
	/**
	 * 冒泡排序
	 * 冒泡排序法：比较两个元素,如果前一个比后一个大则进行交换，经过对每个元素的比较,最后将最大的元素设置成最后一个
                                            元素(该元素不再参与排序).重复该动作,最后形成从小到大的排序
	 */
	public void bubbleSort(){
		int temp=0;
		for(int i=0;i<num-1;i++){
			for(int j=i+1;j<num;j++){
				if(array[i]>array[j]){
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		
		
	}
	
	/**
	 * 选择排序
	 *    扫描所有的元素,得到最小的元素,并将最小的元素与左边第一个元素进行交换,再次扫描除第一位置
	 *    的所有元素,得到最小的元素,与左边第二该元素进行互换,以此类推。
	 */
	public void selectSort(){
		int min=0;
		int temp=0;
		for(int i=0;i<num-1;i++){
			min=i;
			for(int j=i+1;j<num;j++){
				if(array[i]>array[j]){ //选择最小值的下标
					min=j;
				}
			}
			
			temp=array[i];
			array[i]=array[min];
			array[min]=temp;
		}
	}
	
	/**
	 * 插入排序
	 * 抽取一个元素,在其前面的元素中找到合适的位置进行插入
	 */
	public void insertSort(){
		int select=0;
		for(int i=1;i<num;i++){ //从第2个元素开始 抽出数据和前面的数据进行比较
			select=array[i];
			int j=0;
			for(j=i;j>0&&array[j-1]>=select;j--){//如果前一个元素比后一个元素大 则其他数据右移 空出该数据位置
				array[j]=array[j-1];
			}
			array[j]=select; //填充空出的数据位置
		}
	}
	
	/**
	 * 字符串的排序
	 * 系统提供的compareTo()方法
	 * 0      等于
	 * 1      大于
	 *-1      小于
	 */
	public void strSort(String oneStr,String otherStr){
		int result=oneStr.compareTo(otherStr);
//		int result=oneStr.compareToIgnoreCase(otherStr);
		
	}
	/**
	 * 删除
	 */
	public void delete(int value){
		int index=query(value);
		if(index==-1){
			System.out.println("对不起 数组中不包含该元素");
			return ;
		}
		for(int i=index;i<num-1;i++){ //往前移动一位
			array[i]=array[i+1];
		}
		num-=1;
		
	}
	/**
	 * 线性查询
	 */
	public int query(int value){
		for(int i=0;i<num;i++){
			if(array[i]==value)return i;
		}
		return -1;
	}
	
	/**
	 * 二分法查找
	 * 适用于有序数组(即按大小排列的数组)
	 */
	public int binaryFind(int value){
		int middle=0;
		int low=0;
		int pow=num;
		while(true){
			middle=(low+pow)/2;
			if(array[middle]==value){
				return middle;
			}else if(low>pow){ //找不到  
				return -1;
			}else{
				if(array[middle]>value){//中间值比查询值大  则往前移动一位
					pow=middle-1;
				}else{  //中间值比查询值小  则往后移动一位
					low=middle+1;
				}
			}
		}
		
	}
	
	/**
	 * 修改元素
	 */
	public  void update(int oldValue,int newValue){
		int index=query(oldValue);
		if(index==-1){
			System.out.println("对不起 数组中不包含该元素");
			return ;
		}
		array[index]=newValue;
	}
   /**
    * 打印
    */
	public void print(){
		for(int i=0;i<num;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
