package com.aodingkun;

/**
 * @ClassName Demo
 * @Description
 * @Author jonas.ao
 * @Date 2020/4/24
 * Project JavaTest
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(num));
    }

    public static int test(int b) {
        try {
            b += 10;
            return b;
        } catch (RuntimeException e) {

        } catch (Exception e2) {

        } finally {
            b += 10;
            return b;
        }
    }
}
