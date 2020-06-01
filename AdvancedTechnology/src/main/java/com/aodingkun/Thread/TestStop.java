package com.aodingkun.Thread;

import com.sun.media.sound.RIFFInvalidDataException;

/**
 * @ClassName TestStop
 * 1 建议线程正常停止
 * 2 建议使用标志位
 * 3 不要使用不推荐的方法
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/23
 * Project JavaTest
 * @Version 1.0
 **/
public class TestStop implements Runnable {
    //1 设置一个标志位
    boolean flag=true;


    @Override
    public void run() {

        int i=0;
        while (flag){
            System.out.println(i++);

        }

    }

    //设置一个公开的方法停止线程 转换标志位
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();


        for (int i = 0; i <1000 ; i++) {
            System.out.println("main"+i);
            if (i==900){
                //调用stop方法 切换标志位 让线程停止
                testStop.stop();
                System.out.println("线程should stop");
            }
        }
    }
}
