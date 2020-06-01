package com.aodingkun.Collection.Set;

import java.util.TreeSet;

/**
 * @ClassName TestTreeSet
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/25
 * Project JavaTest
 * @Version 1.0
 **/
public class TestTreeSet {
    public static void main(String[] args) {

        TreeSet<Person> personSet = new TreeSet<Person>();

        personSet.add(new Person("sunwukong", 1));
        personSet.add(new Person("sunwukong", 2));
        personSet.add(new Person("sunwukong", 3));
        personSet.add(new Person("sunwukong", 4));

        System.out.println(personSet.size());
        System.out.println(personSet);


        TreeSet<String> stringSet = new TreeSet<String>();
        stringSet.add("a");
        stringSet.add("c");
        stringSet.add("b");
        stringSet.add("d");
        stringSet.add(new String("蔡徐坤"));
        stringSet.add(new String("蔡徐坤"));
        stringSet.add(new String("蔡徐坤"));
        System.out.println(stringSet.size());
        System.out.println(stringSet);

    }
}
