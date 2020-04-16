package com.aodingkun.linkedlist;

import java.util.Stack;
/**
 * @Description:链表是以节点的方式来存储；
 * 每个节点包含data域，next域：指向下一个节点
 * 每个节点不一定是连续存储。
 * 链表分带头节点的链表和无头节点的链表，根据实际需要来定
 * @Param:
 * @return:
 * @Date: 2020/3/22
 **/
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//进行测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "吴用", "智多星");
		HeroNode hero3 = new HeroNode(3, "卢俊义", "玉麒麟");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		
		//创建的一个链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
		//加入
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);

		//显示
		System.out.println("");
		singleLinkedList.list();
		
//		System.out.println("?????????~~");
//		reversetList(singleLinkedList.getHead());
//		singleLinkedList.list();
		
		System.out.println("");
		reversePrint(singleLinkedList.getHead());

		//添加按照编号的顺序
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		
/*		

		
		//
		singleLinkedList.list();
		
		//
		HeroNode newHeroNode = new HeroNode(2, "С?", "??????~~");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("~~");
		singleLinkedList.list();
		
		// 删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删除后链表情况~~");
		singleLinkedList.list();
		
		//测试 求单链表中的有效节点的个数
		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2
		
		//
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/		
		
	}

	//单链表的反转【腾讯面试题】
	//
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;//
		}
		//
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//
		while(cur != null) {
			stack.push(cur);
			cur = cur.next; //
		}
		//
		while (stack.size() > 0) {
			System.out.println(stack.pop()); //
		}
	}
	
	//
	public static void reversetList(HeroNode head) {
		//
		if(head.next == null || head.next.next == null) {
			return ;
		}
		
		//
		HeroNode cur = head.next;
		HeroNode next = null;//
		HeroNode reverseHead = new HeroNode(0, "", "");
		//
		//
		while(cur != null) { 
			next = cur.next;//
			cur.next = reverseHead.next;//
			reverseHead.next = cur; //
			cur = next;//
		}
		//
		head.next = reverseHead.next;
	}
	
	/** 查找单链表中的倒数第K个节点【新浪面试题】
	 * //0·
	 * 	//1.编写一个方法 接收head 同时接收一个index
	 * 	//2. index 表示倒数第index个基点
	 * 	//3.先把链表从头到尾遍历 ,得到链表的总长度 getLenth
	 * 	//4.我们从链表的第一个开始遍历（size-index）个 即可得到
	 * 	//5.如果找到了 则返回该节点 ；反之 为空
	 * @Description:
	 * @Param:
	 * @return:
	 * @Date: 2020/4/7
	 **/
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		//如果链表为空 返回null
		if(head.next == null) {
			return null;//
		}
		//第一次遍历得到链表的长度（节点个数）
		int size = getLength(head);
		//第二次 遍历 size -index位置 就是我们倒数的第K个节点
		//先做一个index的校验
		if(index <=0 || index > size) {
			return null; 
		}
		//定义一个辅助变量 for循环定位到倒数的index
		HeroNode cur = head.next; //3 // 3 - 1 = 2
		for(int i =0; i< size - index; i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	
	//
	/**方法 后去单链表的节点的个数（如果带节点的链表 需求不统计头节点）
	 * 
	 * @param head 链表的头节点
	 * @return 返回有效节点的个数
	 */
	public static int getLength(HeroNode head) {
		if(head.next == null) { //空链表
			return 0;
		}
		int length = 0;
		//定义一个辅助的遍历 这里没有定义头节点
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next; //遍历
		}
		return length;
	}

}


//定义SingleLinkedList 管理我们的英雄
//完成对对象的增删改查
class SingleLinkedList {
	//初始化一个头节点 头节点不要动 不妨具体数据
	//head节点不存放具体的数据 作用就是表示单链表头next
	private HeroNode head = new HeroNode(0, "", "");
	
	/**
	 * @Description: 返回头节点
	 * @Param:
	 * @return:
	 * @Date: 2020/3/22
	 **/
	public HeroNode getHead() {
		return head;
	}

	/**
	 * @Description: 添加增加 添加节点到单向列表
	 *
	 * 	//思路：当不考虑编号的适合
	 * 	//1.找到当前链表的最后节点
	 * 	//2.将最后的节点next 指向新的节点
	 * @Param: heroNode
	 * @return:
	 * @Date: 2020/3/18
	 **/
	public void add(HeroNode heroNode) {
		
		//因为head节点不能动 因此我们需要一个辅助遍历temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while(true) {//死循环
			//找到链表的最后
			if(temp.next == null) {//
				break;
			}
			//如果没有找-到最后，让temp后移
			temp = temp.next;
		}
		//当退出while循环时 temp指向链表的最后
		//将最后的这个节点的next 指向新的节点
		temp.next = heroNode;
	}
	
	/**
	 * @Description: 顺序插入节点
	 * 1、首先找到新添加节点的位置，通过辅助变量（指针），通过遍历实现
	 * 2、新的节点.next=temp.next
	 * 3、将 temp.next=新的节点
	 * @Param:
	 * @return:
	 * @Date: 2020/3/22
	 **/
	public void addByOrder(HeroNode heroNode) {
		//因为头节点不能动，因此我们仍然通过一个辅助指针（变量）帮助找到添加的位置
		//因为这是一个单连的结构，因此我们找的temp是位于添加位置的前一个节点，否则添加不了
		HeroNode temp = head;
		boolean flag = false; //标识 添加的编号是否存在，默认为false
		while(true) {
			if(temp.next == null) {//说明temp已经在链表的最后
				break; //
			}
			//位置找到 就在temp的后面插入 数据添加在temp 与temp.next之间
			if(temp.next.no > heroNode.no) {
				break;

			} else if (temp.next.no == heroNode.no) {
				//说明希望添加的heronode 的编号已经存在
				flag = true; //说明编号存在
				break;
			}
			temp = temp.next; //后移，遍历当前的链表
		}
		//判断flag的值
		if(flag) {
			//不能添加 说明编号存在
			System.out.printf("准备插入的英雄的编号 %d 已经存在，不能加入\n", heroNode.no);
		} else {
			//插入到链表中，temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	/**
	 * @Description: 修改更新
	 * 根据newHeroNode 的no 来修改即可
	 * @Param:
	 * @return:
	 * @Date: 2020/3/22
	 **/
	public void update(HeroNode newHeroNode) {
		//判断是否为空
		if(head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		//
		//定义一个辅助变量
		HeroNode temp = head.next;
		boolean flag = false; //表示是否找到该节点
		while(true) {
			if (temp == null) {
				break; //
			}
			if(temp.no == newHeroNode.no) {
				//找到
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//根据flag判断是否找到要修改的节点
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else { //没有找到
			System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
		}
	}
	/**
	 * @Description:删除
	 * @Param:
	 * @return:
	 * @Date: 2020/3/22
	 **/
	//
	//0·
	//1.
	//2.
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false; //标记是否找到待删除的节点
		while(true) {
			if(temp.next == null) { //已经找到链表的最后
				break;
			}
			if(temp.next.no == no) {
				//找到待删除节点的前一个节点temp
				flag = true;
				break;
			}
			temp = temp.next; //temp后移 遍历
		}
		//判断flag
		if(flag) { //找到
			//可以删除
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}
	}
	
	/**
	 * @Description: 显示列表 show list
	 * @Param:
	 * @return:
	 * @Date: 2020/3/18
	 **/
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//因为头节点不能动 因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while(true) {
			//判断是否到链表最后
			if(temp == null) {
				break;
			}
			//输出节点信息
			System.out.println(temp);
			//将next 后移
			temp = temp.next;
		}
	}
}

//定义HeroNode 每个HeroNode 对象是一个节点
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next; //指向下一个节点
	//构造器
	public HeroNode(int no, String name, String nickname) {
		//初始化
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//为了显示方便 重写tostring方法
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}
