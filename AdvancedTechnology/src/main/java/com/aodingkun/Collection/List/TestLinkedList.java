package com.aodingkun.Collection.List;

import java.util.LinkedList;

/**
 * @ClassName TestLinkedList
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/25
 * Project JavaTest
 * @Version 1.0
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        //    long time1= System.currentTimeMillis();
        //linkedList 200000 次为例
        for (int i = 1; i < 200000; i++) {
            //向后追加元素 23a
            //linkedList.addLast("a");
            //向前插入元素 23
            linkedList.addFirst("");

        }
        //遍历轮询
        long time1 = System.currentTimeMillis();
        //遍历轮询 3毫秒
        for (String value : linkedList
        ) {

        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
