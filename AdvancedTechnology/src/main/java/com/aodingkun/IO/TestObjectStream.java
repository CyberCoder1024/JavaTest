package com.aodingkun.IO;

import java.io.*;

/**
 * @ClassName TestObjectStream
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/20 14:47
 * Project JavaTest
 * @Version 1.0
 **/
public class TestObjectStream {


    public static void main(String[] args) {


        //将对象直接记录在文件中
        Person person = new Person("caixukun",11);
        try {
            //ObjectInputStream ois = new ObjectInputStream(person);
            FileOutputStream fos = new FileOutputStream("D://test//test.txt");
            //对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(fos);//高级流
            oos.writeObject(person);//需将对象拆分成字节碎片 序列化到文件里
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //读取对象输入流
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://test//test.txt"));
            Person person1=(Person)ois.readObject();
            System.out.println(person1);
            person1.eat();
            //通常会把所有记录的对象存在一个集合里
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
