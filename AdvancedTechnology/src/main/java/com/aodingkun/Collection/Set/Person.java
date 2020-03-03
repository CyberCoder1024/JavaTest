package com.aodingkun.Collection.Set;

/**
 * @ClassName Person
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/25
 * Project JavaTest
 * @Version 1.0
 **/
public class Person implements Comparable<Person>{
    private String name;
    private Integer num;
    public Person(String name,Integer num){
        this.name=name;
        this.num=num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TODO 重写一个equals方法 将Person放入set结合中去掉重复

    @Override
    public boolean equals(Object obj) {
        //判断是否为Object
        if (this==obj){
            return true;
            //Person
        }if (obj instanceof Person){
            //obj还原Person类型
            Person antherPerson=(Person)obj;
            //this anthoerPerson 比较对象中的name 属性
            if (this.name.equals(antherPerson.name)){
                //递归
                return true;

            }
        }return false;

        //return super.equals(obj);
    }
    //TODO 重写hashcode方法

    @Override
    public int hashCode() {
        //return super.hashCode();
        return this.name.hashCode();
    }
//TODO 如果想要让person对象存入TreeSet集合内 必须重写此方法
    @Override
    public int compareTo(Person o) {
        int value=this.name.compareTo(o.name);
        if (value!=0){
            return value;
        }
        return this.num-o.num;
    }

    //TODO  重写String方法 让对象打印输出的适合直接输出对象的属性 而不是hashcode
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
