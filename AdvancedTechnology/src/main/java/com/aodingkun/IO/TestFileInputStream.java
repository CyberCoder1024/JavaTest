package com.aodingkun.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName TestFileInputStream
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/17 24:22
 * Project JavaTest
 * @Version 1.0
 **/
public class TestFileInputStream {
    public static void main(String[] args) {
        //可以理解文件是一个仓库 fis对象搬运工
     /*  try{
           //创建一个字节型的文件输入流 读取一个文件中的内容
           File file = new File("D://test/test.txt");
           FileInputStream fis = new FileInputStream(file);
           //读取一个字节
           int i = fis.read();
           while (i!=-1){
               System.out.println((char)i);//读取的字节对应的Unicode码 0-65535 读不到为-1
               i=fis.read();
           }

       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch (IOException e){
           //编译时异常
           e.printStackTrace();
       }*/
     FileInputStream fis=null;
    try{
        //流
        fis = new FileInputStream("D://test//test.txt");
        int v=fis.available();//流管道中有多少缓存的字节   读取网络数据的数据可能会有问题
        System.out.println(v);
     /*   int code = fis.read();
        System.out.println((char)code);*/
        //创建一个空的数组--->小推车
        byte[] b = new byte[6 ];
        int count = fis.read(b);//去文件里都东西 装入数组内 读取到的有效字节个数
        while (count!=-1){
            System.out.println("-----"+count+"-----");
            String value = new String(b,0,count);
            System.out.println(value);
            count=fis.read(b);

        }

    }catch (IOException e){
        e.printStackTrace();
    }finally {
        try{
            if (fis!=null){
                //关闭的时流通道
                fis.close();
            }

        }catch (IOException E){
            E.printStackTrace();
        }

    }


    }
}
