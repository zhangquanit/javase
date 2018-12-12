package com.terry.test;

/**
 * 张全
 */
public class MyStack<E> {
	private Object[] arr;
	private int index = -1;
	private int size;

	public MyStack(int size) {
		arr = new Object[size];
	}

	public void push(E e) {
		arr[++index] = e;
	}

	public E peek() {
		if (index == -1)
			throw new NullPointerException("the stack is empty");
		return (E) arr[index];
	}

	public E pop() {
		if (index == -1)
			throw new NullPointerException("the stack is empty");
		return (E) arr[index--];
	}

	public boolean isFull() {
		return index == size - 1;
	}

	public boolean isEmpty() {
		return index == -1;
	}

	public static void main(String[] args) {
		MyStack stack= new MyStack<Integer>(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
