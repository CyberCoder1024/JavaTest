package com.aodingkun.Array;

/**
 * @ClassName TestArray
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/16
 * Project JavaTest
 * @Version 1.0
 **/
public class TestArray {
    public static void main(String[] args) {
        //静态初始化
        int[] array=new int[]{10,20,30,40};
        //数组元素的访问:通过元素在数组中的位置index（索引、下标）访问
        //从数组内取得某一个位置的元素
        int value=array[0];
        System.out.println(value);
        //向数组内的某一个位置存入元素
        array[3]=400;
        int b=array[3];
        System.out.println(b);
    //将数组中的元数每一个元素都拿出来看一看 for{}
        System.out.println("----------for循环遍历----");
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        System.out.println("-------增强的for循环--------");
//        加强的for循环
        for (int element:array) {

            System.out.println(element);
        }
        System.out.println("--------动态初始化--------");



        //基本数据类型和引用数据类型在内存结构上的区别
        System.out.println("/*******************************{基本数据类型}************************************/");
         int a=10;
         int c=a;
         c=100;
        System.out.println(a);
        System.out.println(c);
        System.out.println("/*******************************{引用数据类型}************************************/");
        int[] x={1,2,3,3};//栈内存中的小容器，类型定义了只能存储这种东西，容器中只能存一份
        //见到new 关键字 相当于在堆内存中申请开辟一块新的空间
        //数组在堆内存的空间是一串连续的地址
        int[] y=x;
        y[0]=100;
        System.out.println(x[0]);
        System.out.println(y[0]);
    }
}
