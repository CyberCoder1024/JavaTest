package com.aodingkun.Thread;

/**
 * @ClassName TestSleep
 * @Description 模拟网络延时:放大问题的发生性
 * @Author jonas.ao
 * @Date 2020/5/23
 * Project JavaTest
 * @Version 1.0
 **/
public class TestSleep implements Runnable{
    private int ticketNums=10;
    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            //模拟网络延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNums--+"票");
        }

    }

    public static void main(String[] args) {

        TestSleep testSleep = new TestSleep();
        new Thread(testSleep,"AAA").start();
        new Thread(testSleep,"bbb").start();
        new Thread(testSleep,"ccc").start();
        new Thread(testSleep,"dddd").start();
    }
}
