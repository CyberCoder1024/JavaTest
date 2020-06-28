package com.aodingkun;

/**
 * @ClassName Test01
 * @Description
 * @Author jonas.ao
 * @Date 2020/6/15
 * Project JavaTest
 * @Version 1.0
 **/
public class Test01 {
    public static void main(String[] args) {
        Bsse base = new Son();
        base.method();
        ((Son) base).methodB();
    }
}

class Bsse{
    public void method(){
        System.out.println("son");
    }
}
class Son extends Bsse{

    public void method() {
        System.out.println("Son");
    }
    public void methodB(){
        System.out.println("SonB");
    }
}
