package com.aodingkun.Collection.Set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @ClassName TestHashSet
 * @Description TODO 无序无重复
 * @Author jonas.ao
 * @Date 2019/12/25 21:21
 * Project JavaTest
 * @Version 1.0
 **/
public class TestHashSet {
    public static void main(String[] args) {
      /*  HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("C");
        hashSet.add("A");
        hashSet.add("b");
        System.out.println(hashSet);

        hashSet.remove("b");
        System.out.println(hashSet);
        //先获取1一个迭代器对象 Iterator接口 多态的效果
        Iterator<String> iterator = hashSet.iterator();
        //判断下一个位置是否有元素 hasNext()
        //不知道长度用while
        while (iterator.hasNext()){
            String value = iterator.next();
            System.out.println(value);
        }*/


      //TODO hashSet 无重复原则
        HashSet<Person> pset = new HashSet<Person>();
        pset.add(new Person("蔡徐坤",1));
        pset.add(new Person("蔡徐坤",2));
        pset.add(new Person("吴亦凡",3));
        pset.add(new Person("两开花",4));
        pset.add(new Person("庆余年",5));
        System.out.println(pset.size());//5个
        //蔡徐坤此对象只剩一个 第一存储的还是最后一次存储的
        System.out.println(pset.iterator().next().getNum());
        //输出对象
        System.out.println();
        //TODO String  equal进行比较
        HashSet<String> stringSet = new HashSet<>();
        stringSet.add(new String("蔡徐坤"));
        stringSet.add(new String("蔡徐坤"));
        stringSet.add(new String("蔡徐坤"));
        stringSet.add(new String("蔡徐坤"));
        stringSet.add(new String("蔡徐坤"));
        System.out.println(stringSet.size());//1


    }
}
