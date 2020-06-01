package com.aodingkun.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOFileChannel
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/1/3
 * Project JavaTest
 * @Version 1.0
 **/
public class NIOFileChannel {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("C:\\Users\\jonas.ao\\Documents\\ProjectCode\\JavaTest\\Netty\\src\\main\\java\\com.aodingkun.nio\\1.txt");
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("D:\\test\\test.txt");
        FileChannel fosChannel = fos.getChannel();

        //创建一个缓存区 输入输出读写共用一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            //重要操作 清空buffer 相关标志位进行重置
            byteBuffer.clear();

            //循环读取
            int read = fisChannel.read(byteBuffer);//buffer从 通道数据读取数据
            System.out.println("read=" + read);
            if (read == -1) {
                //读取结束
                break;
            }
            //对byteBuffer 进行反转
            byteBuffer.flip();
            //将buffer 中的数据写入到fOSchannel
            fosChannel.write(byteBuffer);
        }
        //关闭相关流
        fis.close();
        fos.close();

    }
}
/*
    String str="WELOCME ZJUT";
    File file = new File("D://test//test.txt");
    //创建一个输出流 channel
    FileOutputStream fos = new FileOutputStream("D://test//test.txt");
    //通过fos 获取对应的FileChannel
    FileChannel fosChannel = fos.getChannel();
    //创建文件输入流
    FileInputStream fis = new FileInputStream(file);

    FileChannel fisChannel = fis.getChannel();


    //创建一个缓存区 ByterBuffer
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    //创建输入的额缓存区
    ByteBuffer byteBuffer1 = ByteBuffer.allocate((int) file.length());

//将str 放入 byteBuffer
        byteBuffer.put(str.getBytes());

                //将通道数据读入到buffer
                // Integer read = fisChannel.read(byteBuffer1);
                fisChannel.read(byteBuffer1);
                //将byteBuffer 的字节数据转成String
                //  System.out.println(new String(String.valueOf(read)));
                System.out.println(new String(byteBuffer1.array()));
                //对byteBuffer 进行反转
                byteBuffer.flip();

                //将缓冲区的数据 byteBuffer写入到通道channel
                fosChannel.write(byteBuffer);
                //关闭文件流
                fos.close();
                fis.close();
*/
