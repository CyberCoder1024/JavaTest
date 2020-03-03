package com.aodingkun.Collection.List;

import java.util.Stack;

/**
 * @ClassName TestVector
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/25 16：41
 * Project JavaTest
 * @Version 1.0
 **/
public class TestVector {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("zjut");
        stack.push("zju");
        stack.push("cai");
        System.out.println(stack);
        System.out.println(stack.search("zju"));
        System.out.println(stack.size());

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);

    }

}
