package com.aodingkun.Socket;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/17 115:27
 * Project JavaTest
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args)throws IOException {
        File file = new File("C:\\Users\\logo.jpg");
        if (file.exists())
            FileProtocl(file);
        else
            throw new IOException("文件"+file+"不存在");


    }

    private static void FileProtocl(File file)throws IOException {
        Socket client = new Socket("127.0.0.1", 8086);
        //创建文件输出流
        PrintWriter pwout = new PrintWriter(client.getOutputStream(), true);
        //创建文件输入流 选择字符缓存流bufferedReader
        BufferedReader bufread = new BufferedReader(new FileReader(file));
        //开始传输，传输完打印提示
        String line=null;
        while ((line=bufread.readLine())!=null){
            System.out.println(line);
        }
        client.shutdownOutput();//通知客户的传输完毕
        System.out.println("文件传输完毕");
        //创建socket输入流 获取从赋予武器收到的信息并打印
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str = bufIn.readLine();
        System.out.println(str);
        bufread.close();
        client.close();
    }
}
