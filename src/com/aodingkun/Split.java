package com.aodingkun;

/**
 * @ClassName Split
 * @Description
 * @Author jonas.ao
 * @Date 2020/4/24
 * Project JavaTest
 * @Version 1.0
 **/
public class Split {
    public static void main(String[] args) {
        split(12);//12 6 3 2 1
    }

    public static int split(int number) {
        if (number > 1) {
            if (number % 2 != 0) System.out.print(split((number + 1) / 2));
            System.out.print(split(number / 2));
        }
        return number;
    }
}
