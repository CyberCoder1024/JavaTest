package com.aodingkun.Algorithm.dac;

/**
 * @ClassName: Hanoitower
 * @Description :
 * @Author: AoDingKun
 * @Date :2020/6/6 21:03
 * Project : Hanoitower.java
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
    }


    public static void hanoiTower(int num, char a, char b, char c) {
        //
        if (num == 1) {
            System.out.println(" " + a + "->" + c);
        } else {

            hanoiTower(num - 1, a, c, b);

            System.out.println("" + num + " " + a + "->" + c);

            hanoiTower(num - 1, b, a, c);

        }
    }

}
