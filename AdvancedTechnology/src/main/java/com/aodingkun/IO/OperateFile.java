package com.aodingkun.IO;

import java.io.*;

/**
 * @ClassName OperateFile
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/19 16:15
 * Project JavaTest
 * @Version 1.0
 **/
public class OperateFile {
    public static void main(String[] args) {
        OperateFile opf = new OperateFile();
        opf.copyFile(new File("D://test.txt"),"D://test");
    }
    /**
     * @Description: copyFile 文件复制操作
     * @Param:
     * @return:
     * @Date: 2019/12/19
     **/
    public void copyFile(File file,String path){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try{
            //creat a new inputstream
            fis = new FileInputStream(file);
            //new a new file object
            File newFile = new File(path +"//"+ file.getName());

            fos = new FileOutputStream(newFile);
            //read file info
            //create byte
            byte[] bytes = new byte[1024];//1kb--8kb之间 8bit=1Byte，1024Byte=1kB
            int count = fis.read(bytes);
            while (count!=-1){
                fos.write(bytes,0,count);//将读取到的有效字节 写入
                fos.flush();
                count=fis.read(bytes);
            }
            System.out.println("复制完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭
            try{
                if (fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @Description: 文件的加密
     * @Param:
     * @return:
     * @Date: 2019/12/19
     **/
    public void  jiamiFile(File file,String path){
        FileOutputStream fos=null;
        FileInputStream fis=null;
        try{
            //创建一个输入流
            fis=new FileInputStream(file);
            //创建一个新file对象
            File newFile = new File(path + "//" + file.getName());
            //创建一个输出流
             fos = new FileOutputStream(newFile);
            byte[] bytes = new byte[1024];
            //读取过程是一个循环
            int count= fis.read(bytes);
            while (count!=-1){
                //做点手脚 每一次数组的前两个元素位置互换 1024
                byte temp=bytes[0];
                bytes[0]=bytes[1];
                bytes[1]=temp;

                fos.write(bytes,0,count);
                fos.flush();
                count=fis.read(bytes);
            }
            System.out.println("加密完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭
            try{
                if (fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    /**
     * @Description: 文件夹的复制
     * @Param: file可为文件或文件夹
     * @return:
     * @Date: 2019/12/19
     **/
    public void superCopyFile(File file,String newPath){

        //获取file的绝对路径 通过拼串的方式获取新的文件名字
        String oldFilePath=file.getAbsolutePath();//C://aaa/bbb---->D://aaa//bbb
        String newFilePath=newPath+ oldFilePath.split(":")[1];
        //创建新的file对象
        File newFile = new File(newFilePath);
        //判断当前传递进来的file是个文件还是文件夹 isFile isDirectory lisFiles
        //获取当前传递过来的file对象的所有子元素
        File[] files = file.listFiles();
        if (files!=null){
            //file is Directory
            // 通过新的file对象操作在硬盘上创建一个文件夹
            newFile.mkdir();
            System.out.println("文件夹复制完毕");
            //里面的元素
            if (files.length!=0){
                for (File f:files){
                    this.superCopyFile(f,newPath);
                }
            }
        }else {
            //file is file no
            //创建两个文件流 分别读取旧的file 和写入新的newFile
            FileInputStream fis=null;
            FileOutputStream fos=null;
            try{
                //creat a new inputstream
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
                //read file info
                //create byte
                byte[] bytes = new byte[1024];//1kb--8kb之间 8bit=1Byte，1024Byte=1kB
                int count = fis.read(bytes);
                while (count!=-1){
                    fos.write(bytes,0,count);//将读取到的有效字节 写入
                    fos.flush();
                    count=fis.read(bytes);//别忘了再读一遍
                }
                System.out.println(newFile.getName()+"文件复制完毕");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //关闭
                try{
                    if (fis!=null){
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fos!=null){
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //里面的元素

    }
    public void cutFile(){
       // this.superCopyFile();
        this.deleteFile();
    }

    private void deleteFile() {
    }
}
