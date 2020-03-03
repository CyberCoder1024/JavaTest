package com.aodingkun.Collection.List;

import java.util.ArrayList;

/**
 * @ClassName TestArrayList
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/25
 * Project JavaTest
 * @Version 1.0
 **/
public class TestArrayList {
    public static void main(String[] args) {
        //存 add取get 删 remove改 个数 size
        //ArrayList list=new ArrayList();
        //泛型
        ArrayList<String> list=new ArrayList<String>();
//        list.add(1);
//        list.add("zjut");
//        list.add(true);
//        list.get(2);
//        list.remove(0);
//        list.size();
        list.add("浙江省");
        list.add(1,"杭州市");
        list.add("西湖区");
        list.add("留和路288号");
        list.add("浙江工业大学");

        list.add("信息学院");
        list.add("zjuter");
        //有效元素的个数
        System.out.println(list.size());
        System.out.println(list.get(1));
        //List底层重写了toString方法
        System.out.println(list);

       // String value=(String)list.get(0);
        //value.trim();
        //遍历
        System.out.println("-------------遍历数组元素---------------");
        for (int i = 0; i <list.size() ; i++) {
            String value = list.get(i);
            //打印不换

            System.out.print(value+"\n");

        }
        //集合元素全部删掉
        int size=list.size();
        for (int i = 0; i <size ; i++) {
            list.remove(0);
        }

        //泛型不能使用基本类型 如果需要使用基本类型 需要使用其对应的包装类
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(10);
        list2.add(20);

        //将list2集合元素加入到list1
        list1.addAll(list2);//list1.addAll(com.aodingkun.Collection<? exctends E> list2) 将list2集合的全部元素存入list1 list 1集合存在泛型 Integer list集合存在泛型 Integer或市其自类
        System.out.println("-----------输出addAll list1---------------\n");
        System.out.println(list1);

        System.out.println("------------输出索引 index----------------");
        int index = list1.indexOf(100);
        System.out.println(index);
        System.out.println("-------------输出removeAll 差集-----------");
        list1.removeAll(list2);
        System.out.println(list1);


        System.out.println("----------返回这个集合的对象数组 toArray 集合变成数组----------");
        Object[] array = list1.toArray();
        for (Object obj:array) {
            //String value=(String)obj;
            Integer value=(Integer)obj;
            System.out.println(value);
        }
        System.out.println("/*************{trimToSize 变成有效1元素个数那么长}**************/");
    }
}
