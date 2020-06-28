package com.aodingkun.DataStructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        //创建一个ArrayStack对象 表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";//空串
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 显示 ");
            System.out.println("exit: 退出");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("选择你的输入");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf(" 出栈的数据%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("");
    }

}

//定义一个栈
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组 模拟战 数据放在该组
    private int top = -1;// top表示栈顶 初始化为-1

    //初始化 构造器 栈的大小
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-PUSH
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈 POP 将栈顶的数据返回
    public int pop() {
        //判断栈是否为空
        if (isEmpty()) {
            //抛出一个运行异常
            throw new RuntimeException("栈空~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况 遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("~~");
            return;
        }
        //需要从栈顶显示
        // 遍历时 需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}
