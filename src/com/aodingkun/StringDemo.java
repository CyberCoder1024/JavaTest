package com.aodingkun;

/**
 * @ClassName StringDemo
 * @Description
 * @Author jonas.ao
 * @Date 2020/4/24
 * Project JavaTest
 * @Version 1.0
 **/
public class StringDemo {
    private static final String MESSAGE="taobao";
    public static void main(String [] args) {
        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);
        System.out.println((b+c)==MESSAGE);
    }
}
