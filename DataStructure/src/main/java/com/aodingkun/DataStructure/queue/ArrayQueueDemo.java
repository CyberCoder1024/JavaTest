package com.aodingkun.DataStructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        //???????
        //创建一个队列 queue
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        //
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;//默认死循环
        //
        while (loop) {
            System.out.println("s(show):显示队列 ");
            System.out.println("e(exit):退出程序 ");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列里面取出数据");
            System.out.println("h(head): 查询队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头部数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~");
    }

}

// TODO: 2020/3/12  先写一个类 
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
        //等同于 arr[++rear]=n
    }

    //获取队列的数据， 出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //抛出一个异常进行处理
            throw new RuntimeException("队列空 不能取数据");
        }
        front++; // front 后移
        return arr[front];

    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        //判断是否为空
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据 注意不是取出数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            System.out.println("队列为空 没有数据");
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front + 1];
    }
}
