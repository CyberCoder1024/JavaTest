package com.aodingkun;

/**
 * @ClassName Derived
 * @Description
 * @Author jonas.ao
 * @Date 2020/6/15
 * Project JavaTest
 * @Version 1.0
 **/
public class Derived extends Bases {
    public static void main(String[] args) {
         Bases base = new Derived();
         base.methodA();
    }
    public void methodA(){
        super.methodA();
        System.out.println("C");
    }
    public void methodB(){
        super.methodB();
        System.out.println("D");
    }

}


