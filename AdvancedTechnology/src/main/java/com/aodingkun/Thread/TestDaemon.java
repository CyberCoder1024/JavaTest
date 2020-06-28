package com.aodingkun.Thread;

/**
 * @ClassName TestDaemon
 * @Description 守护线程
 * @Author jonas.ao
 * @Date 2020/5/24
 * Project JavaTest
 * @Version 1.0
 **/
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Man man = new Man();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认为false
        thread.start();//守护线程启动


        new Thread(man).start();//用户线程启动

    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("The God bless you all the time");
        }
    }
}
class  Man implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("you happe live in the world");
        }
        System.out.println("finally! you dead and goodbye world");
    }
}

