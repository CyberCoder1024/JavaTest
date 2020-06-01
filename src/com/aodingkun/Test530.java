package com.aodingkun;

/**
 * @ClassName Test530
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/31
 * Project JavaTest
 * @Version 1.0
 **/
public class Test530 {

    public static void main(String[] args) {
        int a[][]={{1,2},{3,4},{5,6}};
        System.out.println(a);
        String s1="abc";
        String s2="abc";
        String s3=new String(s1);
        if (s1==s2){
            System.out.println(true);
        }
        if (s2==s3){
            System.out.println(true);
        }

    }
}
