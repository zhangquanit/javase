package com.terry.data;

/**
 * 链接点 链接点中包含一个数据域或一个指针域,其中数据域用来包装数据,而指针域用来指向下一个链接点 链表 链表只包含一个数据项,即对第一个链接点的引用
 */
public class Link {

	private int data;// 数据域
	private Link next;// 指针域

	public Link(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}

	public static void main(String[] args) {
		System.out.println("............Link start................");
		Link link1 = new Link(1);
		Link link2 = new Link(2);
		Link link3 = new Link(3);
		Link link4 = new Link(4);

		// 建立链接关系
		link1.setNext(link2);
		link2.setNext(link3);
		link3.setNext(link4);

		System.out.println(link1.getData());
		System.out.println(link1.getNext().getData());
		System.out.println(link1.getNext().getNext().getData());
		System.out.println(link1.getNext().getNext().getNext().getData());

		System.out.println("............Link end................");
		System.out.println();
		System.out.println("............Linklist start................");
		// 链表
		LinkList linkList = new LinkList();
		linkList.insert(1);
		linkList.insert(2);
		linkList.insert(3);
		linkList.insert(4);

		linkList.show();

		System.out.println("查找节点：" + linkList.findLink(4).getData());

		System.out.println("xxxxxxxxxxxxx指定位置插入节点xxxxxxxxxxx");
		linkList.insert(5, 0);
		linkList.insert(6, 1);
		linkList.show();

		System.out.println("xxxxxxxxxxxxxx删除指定节点xxxxxxxxxxxxx");
		linkList.delete(5);
		linkList.show();

	}

	/**
	 * 链表 链表只包含一个数据项,即对第一个链接点的引用
	 * 
	 * 链表和顺序表(有序数组)的比较： 1.对于插入和删除 链表一般快于顺序表 2.对于查询和修改 顺序表一般快于链表
	 */
	static class LinkList {
		private Link first; // 用来作为上一个链接的引用

		public void insert(int value) {
			Link link = new Link(value); // 创建一个新节点
			if (null == first) {
				first = link;
			} else {
				link.setNext(first);// 当前节点的下一个节点为上一个节点
				first = link; // 赋值为上一个节点 所以最后为倒序
			}
		}

		/**
		 * 显示链表数据
		 */
		public void show() {
			Link current = first;
			while (null != current) {
				System.out.print(current.getData() + " ");
				current = current.getNext();
			}
			System.out.println();
		}

		/**
		 * 查找节点 核心：遍历节点(getnext())直到节点的值为查询的值
		 */
		public Link findLink(int value) {
			if (null == first)
				return null;
			Link current = first;
			while (current.getData() != value) {
				if (current.getNext() == null) {
					return null;
				}
				current = current.getNext();
			}
			return current;
		}

		/**
		 * 添加节点到指定位置 核心：x y z 要在x，z之间插入y 首先得到节点x(通过遍历的方式),然后生成节点y,将x的下一个节点设为
		 * y,y的下一个节点设为z(之前x的下一个节点)
		 */
		public void insert(int value, int pos) {
			if (pos == 0) {
				insert(value);
			} else { // 0 1 2 X 3 4 要在2,3之间插入x,则要将2的下一个节点设为X即lnk，X的下一个节点设为3
				Link current = first;
				for (int i = 0; i < pos - 1; i++) { // 得到pos前一位的节点
					current = current.getNext();
				}
				Link lnk = new Link(value); // 创建插入的节点x
				lnk.setNext(current.getNext()); // x的下一个节点为2的下一个节点
				current.setNext(lnk); // 2的下一个节点为x
			}
		}

		/**
		 * 删除指定节点 核心：x y z 删除节点y,即将x的下一个节点指向z
		 */
		public void delete(int key) {
			Link current = first;
			Link ago = first;
			// 找到要删除的节点
			while (current.getData() != key) {
				if (current.getNext() == null) {
					return;
				} else {
					ago = current; // 记录上一次的节点
					current = current.getNext();// 获取下一个节点
				}
			}

			// 如果删除的节点就是 第一个节点 则直接将指针指向下一个节点
			if (current == first) {
				first = first.getNext();
			} else {
				ago.setNext(current.getNext());// 上一个节点的下一个节点为当前节点的下一个节点 1---》3
			}
		}

	}
}
