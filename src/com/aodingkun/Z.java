package com.aodingkun;

import javax.jws.soap.SOAPBinding;

/**
 * @ClassName X
 * @Description
 * @Author jonas.ao
 * @Date 2020/6/15
 * Project JavaTest
 * @Version 1.0
 **/
public class Z extends X{
    Y y= new Y();
    public Z(){
        System.out.println("Z");
    }

    public static void main(String[] args) {
        new Z();
    }

}

class X {
    Y y= new Y();
    public X(){
        System.out.println("X");
    }

}
class Y{
    public Y(){
        System.out.println("Y");
    }

}
