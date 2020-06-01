package com.aodingkun;

/**
 * @ClassName Base
 * @Description
 * @Author jonas.ao
 * @Date 2020/4/24
 * Project JavaTest
 * @Version 1.0
 **/
public class Base extends BaseClass {
    public Base() {
    }

    {
        System.out.println("I’m Base class");
    }

    static {
        System.out.println("static Base");
    }

    public static void main(String[] args) {
        new Base();
    }

}

class BaseClass {
    public BaseClass() {

        System.out.println("I’m BaseClass class");
    }

    static {
        System.out.println("static BaseClass");
    }
}
