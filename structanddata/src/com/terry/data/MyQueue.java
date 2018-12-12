package com.terry.data;

/**
 * 队列 队列是一种数据结构,类似于栈,不同的是在队列中第一个插入的数据项会最先被移除,也就是先进先出。类似于管道 先流进的会先流出来
 */
public class MyQueue {
	public int insert = -1; // 插入的数据下标
	public int take = 0; // 取走的数据下标
	public long[] array; // 保存数据的数组
	public int maxSize;
	public int elements;

	public MyQueue(int maxSize) {
		array = new long[maxSize];
		this.maxSize = maxSize;
		this.take = 0;
		this.insert = -1;
		this.elements = 0;
	}

	/**
	 * 添加数据
	 * 
	 * @param value
	 */
	public void add(long value) {
		elements++;
		array[++insert] = value;
	}

	/**
	 * 取出数据
	 * 
	 * @return
	 */
	public long take() {
		if (insert == -1)
			return -1;
		elements--;
		return array[take++];
	}

	public boolean isFull() {
		return insert == maxSize - 1;
	}

	public boolean isEmpty() {
		return elements == 0;
	}

	public void print() {
		for (int i = 0; i <= insert; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// 普通队列 只能操作最大个数 不能重复添加或移除
		MyQueue queue = new MyQueue(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.print();
		System.out.println(queue.isFull());
		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());

		// 添加到最大个数后继续添加 则会报数组越界异常
		// queue.add(1);

		// 循环队列 内部类的创建 外部类.内部类 对象=new 外部类().new 内部类();
		MyQueue.LoopQueue loopQueue = queue.new LoopQueue(5);
		loopQueue.add(1);
		loopQueue.add(2);
		loopQueue.add(3);
		loopQueue.add(4);
		loopQueue.add(5);

		System.out.println(loopQueue.isFull());

		loopQueue.take();
		loopQueue.take();
		loopQueue.take();
		loopQueue.take();
		loopQueue.take();

		System.out.println("取出5个元素后为空：" + loopQueue.isEmpty());

		loopQueue.add(1);
		loopQueue.add(2);
		loopQueue.add(3);
		loopQueue.add(4);
		loopQueue.add(5);
		System.out.println("删除后 重新添加5个元素为满：：" + loopQueue.isFull());

		// 有序队列
		MyQueue.PriorityQueue priorityQueue = queue.new PriorityQueue(5);
		priorityQueue.add(1);
		priorityQueue.add(5);
		priorityQueue.add(3);
		priorityQueue.add(4);
		priorityQueue.add(2);

		priorityQueue.print();

		System.out.println(priorityQueue.take());
		System.out.println(priorityQueue.take());
		System.out.println(priorityQueue.take());
		System.out.println(priorityQueue.take());
		System.out.println(priorityQueue.take());
	}

	/**
	 * 循环队列 可以不断的添加和删除
	 */
	class LoopQueue {
		public int[] array;
		public int elements;// 有效个数
		public int insert = -1;
		public int take = 0;
		public int maxSize;

		public LoopQueue(int maxSize) {
			array = new int[maxSize];
			this.maxSize = maxSize;
			take = 0;
			insert = -1;
			elements = 0;
		}

		/**
		 * 重复添加
		 * 
		 * @param value
		 */
		public void add(int value) {
			if (insert == maxSize - 1)
				insert = -1;
			
			array[++insert] = value;
			elements++;
		}

		/**
		 * 重复取出
		 * 
		 * @return
		 */
		public int take() {
			int temp = array[take++];
			if (take == maxSize) {
				take = 0;
			}
			elements--;
			return temp;
		}

		public boolean isFull() {

			return elements == maxSize;
		}

		public boolean isEmpty() {
			return elements == 0;
		}

		public void print() {
			for (int i = 0; i < elements; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 优先级队列 在优先级队列中,数据项按关键字的值有序,这样关键字最小的数据项(或者最大)总是在头部,数据项插入是会按照顺序插入
	 * 到合适的位置以确保队列的顺序
	 */
	class PriorityQueue {
		int[] array;
		int elements;// 有效个数
		int maxSize;

		public PriorityQueue(int maxSize) {
			this.maxSize = maxSize;
			this.elements = 0;
			array = new int[maxSize];
		}

		/**
		 * 有序插入 从大到小
		 * 
		 * @param value
		 */
		public void add(int value) {
			int i = 0;
			for (i = 0; i < elements; i++) { // 5421 ..插入3..>54 3 21
				if (array[i] < value) {
					break;
				}
			}
			// 右移
			for (int j = elements; j > i; j--) {
				array[j] = array[j - 1];
			}
			// 原来i的位置放置value
			array[i] = value;
			elements++;
		}

		public int take() {
			int temp = array[elements - 1];
			elements--;
			return temp;
		}

		public boolean isFull() {
			return elements == maxSize;
		}

		public boolean isEmpty() {
			return elements == 0;
		}

		/**
		 * 返回有效个数
		 * 
		 * @return
		 */
		public int getSize() {
			return elements;
		}

		public void print() {
			for (int i = 0; i < elements; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
}
