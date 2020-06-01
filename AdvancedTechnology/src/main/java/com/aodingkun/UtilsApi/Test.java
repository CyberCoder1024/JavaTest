package com.aodingkun.UtilsApi;

/**
 * @ClassName Test
 * @Description TODO  内存的存储方式  ==与equal
 * @Author jonas.ao
 * @Date 2019/12/23
 * Project JavaTest
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 10;
        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i3 == i4);
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(i3));
        System.out.println(i3.equals(i4));
    }
}
