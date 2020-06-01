package com.aodingkun.DataStructure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        //???????
        System.out.println("测试数组环形队列");

        // 创建一个队列
        CircleArray queue = new CircleArray(4); //???????4, ????е???Ч?????????3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //
        while (loop) {
            System.out.println("s(show):显示队列 ");
            System.out.println("e(exit):退出程序 ");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列里面取出数据");
            System.out.println("h(head): 查询队列头的数据");
            // 接收一个字符
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
                case 'g': // get数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // ?????????????
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}


class CircleArray {
    private int maxSize; // 表示数组的最大容量
    //front 变量的含义一个调整：front 就指向队列的第一个元素，也就是说arr[front]
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置，因此希望空出一个
    //rear 的初始值 = 0
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据 模拟队列


    //创建循环队列的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满了 不同于数组队列
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //循环队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int n) {
        // 先判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满 不能添加数据~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //rear 后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //取出数据
    public int getQueue() {
        //为空判断
        if (isEmpty()) {
            //
            throw new RuntimeException("队列为空，没有数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        // 1. 先把front 的对应值保存一个临时的变量
        // 2. 将 front 后移考虑取模 [如果直接返回 front没有后移的机会]
        // 3.将临时保存到变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }

    //显示队列数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("~~");
            return;
        }
        //思路：从front开始遍历 ，遍历多少个元素 size 当前最终有效元素的个数
        // 下标
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    //
    public int headQueue() {
        //
        if (isEmpty()) {
            throw new RuntimeException("???п??????????~~");
        }
        return arr[front];
    }
}