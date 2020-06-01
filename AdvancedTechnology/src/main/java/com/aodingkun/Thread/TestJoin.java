package com.aodingkun.Thread;

/**
 * @ClassName TestJoin
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/24
 * Project JavaTest
 * @Version 1.0
 **/
public class TestJoin implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        TestJoin testJoin = new TestJoin();

        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i <1000 ; i++) {
            if (i==200){
                thread.join();
            }
            System.out.println("main"+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip"+i);
        }
    }
}
