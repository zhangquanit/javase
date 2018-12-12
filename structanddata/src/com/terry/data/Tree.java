package com.terry.data;

/**
 * 树 
 * 1.二叉树 树中每个节点最多只有2个节点
 */
public class Tree {
	private Node root;//根
	/**
	 * 插入方法
	 * 核心：
	 *   1.如果不存在节点,则直接插入
	 *   2.从根开始查找一个相应的节点,即新节点的父节点,当父节点找到后，根据新节点的值来确定新节点连接到左子节点
	 *   还是右子节点，一般比父节点小在左边,大就在有右边
	 */
	public void insert(int keyData, int otherData) {
		Node newNode=new Node(keyData, otherData);
       if(root==null){
    	   root=newNode;
       }else{
    	   Node current=root;
    	   Node parent;
    	   while(true){
    		   parent=current;
    		       //如果关键字比父节点的小 则设置为左节点
    		    if(keyData<current.getKeyData()){
    		    	current=current.getLeftNode();
    		    	  if(current==null){
    		    		  parent.setLeftNode(newNode);
    		    		  return ;
    		    	  }
    		    }else{//如果关键字比父节点的大 则设置为右节点
    		    	current=current.getRightNode();
    		    	 if(current==null){
    		    		parent.setRightNode(newNode);
    		    		return ;
    		    	 }
    		    }
    	   }
       }
	}

	
	/**
	 * 查询方法
	 * 核心：
	 * 从根节点开始查找,如果查找节点值比父节点值要小,则查找左子树,否则查找右子树,直到查到为止,如果不存在节点,则返回null
	 */
	public Node find(int keyData) {
		Node current=root;
		Node parent;
		while(current.getKeyData()!=keyData){
			parent=current;
			   if(parent.getKeyData()>keyData){
				   current=parent.getLeftNode();
				  
			   }else{
				   current=parent.getRightNode();
			   }
			   
			   if(null==current)return null;
		}
		return current;
	}

	/**
	 * 修改方法
	 * 核心：首先查找节点,找到相应节点后,再进行修改
	 */
	public void change(int keyData,int newOtherData) {
             Node node=find(keyData);//查找节点
             if(null!=node)
            	 node.setOtherData(newOtherData);//修改节点的值
	}
	
	/**
	 * 删除方法
	 * 核心：查到节点  删除
	 */
	public void delete(int keyData) {
	
	}
	
	/**
	 * 返回根节点
	 */
	public Node getRoot(){
		return root;
	}
	/**
	 *遍历二叉树
	 *1.先序遍历
	 *      访问节点,先序遍历节点的左子树,先序遍历节点的右子树
	 *2.中序遍历
	 *      中序遍历节点的左子树，访问节点，中序遍历节点的右子树
	 *3.后序遍历
	 *      后序遍历节点的左子树,后序遍历节点的右子树,访问节点\
	 *      
	 *      A
	 *    B   C
	 *    对于遍历节点A及其子节点
	 * 先序遍历：ABC
	 * 中序遍历：BAC
	 * 后序遍历：BCA   
	 *      
	 */
	
	//1.先序遍历
	 public void preOrder(Node node){
		 if(null!=node){
		 node.display();//访问节点
		 preOrder(node.getLeftNode());//先序遍历节点的左子树
		 preOrder(node.getRightNode());//先序遍历节点的右子树
		 }
	 }
	 
	 //2.中序遍历
	 public void middleOrder(Node node){
		 if(null!=node){
			 middleOrder(node.getLeftNode());//中序遍历节点的左子树
			 node.display(); //访问节点
			 middleOrder(node.getRightNode());//中序遍历节点的右子树
		 }
	 }
	//3.后序遍历
	 public void endOrder(Node node){
		 if(null!=node){
			 endOrder(node.getLeftNode());//后序遍历节点的左子树
			 endOrder(node.getRightNode());//后序遍历节点的右子树
			 node.display();//放问节点
		 }
	 }
	 
	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.insert(1, 11);
		tree.insert(95, 22);
		tree.insert(10, 33);
		tree.insert(80, 33);
		tree.insert(30, 33);
		tree.insert(28, 33);
		
		Node findNode=tree.find(1);
		System.out.println(findNode.getOtherData());
		
		System.out.println("xxxxxxxxx1.先序遍历节点xxxxxxxxxxxx");
		
		tree.preOrder(tree.getRoot());
		System.out.println("xxxxxxxxxxxxxx中序遍历节点xxxxxxxxxxxxx");
		tree.middleOrder(tree.getRoot());
	}
}

class Node {
	// 关键字
	private int keyData;
	// 其他数据
	private int otherData;
	// 左节点
	private Node leftNode;
	// 右节点
	private Node rightNode;

	public Node(int keyData, int otherData) {
		this.keyData = keyData;
		this.otherData = otherData;
	}

	public int getKeyData() {
		return keyData;
	}

	public void setKeyData(int keyData) {
		this.keyData = keyData;
	}

	public int getOtherData() {
		return otherData;
	}

	public void setOtherData(int otherData) {
		this.otherData = otherData;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public void display(){
		System.out.println("keyData="+keyData+",otherData="+otherData);
	}
}