package com.aodingkun.Thread.synchronizeds;

import java.util.ArrayList;

/**
 * @ClassName UnsafeList
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/24
 * Project JavaTest
 * @Version 1.0
 **/
public class UnsafeList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <10000 ; i++) {
             new Thread(() ->{
                 synchronized (list){
                     list.add(Thread.currentThread().getName());
                 }
             }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
