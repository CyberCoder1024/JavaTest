package com.aodingkun;

/**
 * @ClassName Animal
 * @Description
 * @Author jonas.ao
 * @Date 2020/6/15
 * Project JavaTest
 * @Version 1.0
 **/

public abstract class Cat extends Animal{
    public Cat(){
        System.out.println("I AM CAT");
    }

    public static void main(String[] args) {
        Cat cat = new Cat() {
            @Override
            void say() {

            }
        };
    }
}

abstract class Animal {
    abstract void say();
}
