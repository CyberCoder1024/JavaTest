package com.aodingkun;

/**
 * @ClassName HelloJava
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/3/4 3:08
 * Project JavaTest
 * @Version 1.0
 **/
public class HelloJava {
    public static void main(String[] args) {
        System.out.println(val());
    }
    public static int val(){
        int num=5;
        try {
            num=num/0;
        }catch (Exception e)
        {
            num=10;
        }finally {
            num=15;
        }
        return num;
    }
}
