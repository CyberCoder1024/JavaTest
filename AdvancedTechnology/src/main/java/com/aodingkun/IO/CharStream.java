package com.aodingkun.IO;

import java.io.*;

/**
 * @ClassName CharStream
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/19 21:11
 * Project JavaTest
 * @Version 1.0
 **/
public class CharStream {
    public static void main(String[] args) {
        try{
            //字符型文件输入流
            File file = new File("");
            FileWriter fw = new FileWriter(file);
            FileReader fr = new FileReader(file);
            String  str="abc";
            char[] chars = str.toCharArray();
            fw.write(97);
            fw.write(chars);
            fw.write(str);
            fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
