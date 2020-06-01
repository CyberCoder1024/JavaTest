package com.aodingkun.Thread;

import javax.xml.crypto.Data;

/**
 * @ClassName TestSleep2
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/24
 * Project JavaTest
 * @Version 1.0
 **/
public class TestSleep2 {
    public static void main(String[] args) {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }
}
