package com.aodingkun.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		//����һ��
		//����һ������
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; //�����û�����
		Scanner scanner = new Scanner(System.in);//
		boolean loop = true;
		//���һ���˵�
		while(loop) {
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�����");
			System.out.println("a(add): ������ݵ�����");
			System.out.println("g(get): �Ӷ���ȡ������");
			System.out.println("h(head): �鿴����ͷ������");
			key = scanner.next().charAt(0);//����һ���ַ�
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g': //ȡ������
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h': //�鿴����ͷ������
				try {
					int res = queue.headQueue();
					System.out.printf("����ͷ��������%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': //�˳�
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		
		System.out.println("�����˳�~~");
	}

}

// 使用数组模拟队列 编写一个ArrayQueue类
class ArrayQueue {
	private int maxSize; // 表示数组的最大容量
	private int front; // 队列头
	private int rear; // 队列尾
	private int[] arr; // 该数据用于存放数据 模拟队列

	// 创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1; //指向队列头部 分析处front使指向队列头的前一个位置
		rear = -1; // 指向队列尾部 直接指向队列尾的尾部（即队列的最后一个数据）
	}

	//判断队列是否满了
	public boolean isFull() {
		//等于数组最大容量-1
		return rear == maxSize - 1;
	}

	//判断队列是否为空
	public boolean isEmpty() {
		//头部=尾部
		return rear == front;
	}

	//
	public void addQueue(int n) {
		//先判断队列是否满了
		if (isFull()) {
			System.out.println("队列已满 不能添加数据");
			return;
		}
		rear++; // rear会根据数据的添加后移
		arr[rear] = n;
	}

	//
	public int getQueue() {
		//
		if (isEmpty()) {
			//
			throw new RuntimeException("���пգ�����ȡ����");
		}
		front++; // front
		return arr[front];

	}

	//
	public void showQueue() {
		//
		if (isEmpty()) {
			System.out.println("���пյģ�û������~~");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	//
	public int headQueue() {
		//
		if (isEmpty()) {
			throw new RuntimeException("���пյģ�û������~~");
		}
		return arr[front + 1];
	}
}
