package com.cn.javase;
/**
 * 单向链表：
 * 每一个节点都包含下一个节点的引用
 *
 */

class Node{
	private String data;
	private Node next; //对下一个节点的引用
	public Node(String data){
		this.data=data;
	}
	public String getData(){
		return this.data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
public class LianBiao {
    public static void main(String[] args) {
		Node root=new Node("根节点");
		Node nodeA=new Node("节点A");
		Node nodeB=new Node("节点B");
		root.setNext(nodeA);
		nodeA.setNext(nodeB);
		printNode(root);
	}
    public static void printNode(Node node){
    	
    	 System.out.println(node.getData());
    	 if(node.getNext()!=null){
    		 printNode(node.getNext());
    	 }
    }
}
