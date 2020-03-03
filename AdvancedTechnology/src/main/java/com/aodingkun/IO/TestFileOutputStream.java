package com.aodingkun.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName TestFileOutputStream
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/18 14:02
 * Project JavaTest
 * @Version 1.0
 **/
public class TestFileOutputStream {
    public static void main(String[] args) {

     /*   //创建一个字节型文件输出流
        try{
            File file = new File("D://test//test.txt");
            //创建文件输入流 若文件路径有问题  则抛出异常 FileNotFoundException
            //创建的是文件输出流  若文件路径有问题 则直接帮我们创建新的文件
            FileOutputStream fos = new FileOutputStream(file,true);//true boolean 判断；表示追加
            fos.write(97);
            //刷新 将管道的字节推入文件中
            fos.flush();
            System.out.println("write success");
        }catch (IOException e){
            e.printStackTrace();
        }*/
     FileOutputStream fos=null;
     try{
         File file = new File("D://test//test.txt");
        fos = new FileOutputStream(file,true);
         //创建一个数组  带着信息
         //byte[] b = new byte[]{97,98,99};
         //String --->byte[]
         String str="杭州市西湖区留和路288号";
         byte[] b = str.getBytes();
         fos.write(b);
         fos.flush();

     } catch (IOException e) {
         e.printStackTrace();
     }finally {
         try {
             if (fos!=null){
                 fos.close();
             }

         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    }
}
