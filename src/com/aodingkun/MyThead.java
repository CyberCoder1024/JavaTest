package com.aodingkun;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/4/3
 * Project JavaTest
 * @Version 1.0
 **/
public class MyThead  extends Thread{
    public static void main(String[] args) {
        MyThead t=new MyThead();
        MyThead s=new MyThead();
        t.start();
        System.out.println("one.");
        s.start();
        System.out.println("two.");
    }
    public void run() {
        System.out.println("Thread");
    }
}
