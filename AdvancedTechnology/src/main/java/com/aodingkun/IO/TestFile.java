package com.aodingkun.IO;

import java.io.File;

/**
 * @ClassName TestFile
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/17
 * Project JavaTest
 * @Version 1.0
 **/
public class TestFile  {
    public static void main(String[] args) {
        TestFile testFile = new TestFile();
        File file = new File("D://Test");
        //testFile.showFile(file);
        testFile.deleteFile(file);
    }
    public void showFile(File file){//D://Test文件夹
        //判断如果file是一个文件夹 文件夹内有元素 找一个人先做
        //判断file的子元素 files==null 是个文件 files！=null 是一个文件夹 files.length!=0是一个带元素的文件夹
        File[] files = file.listFiles();//test文件夹所有子元素
        if (files!=null && files.length!=0){
            for (File f:files){
                //每一个子元素都找人遍历
                this.showFile(f);//循环第一次 test文件夹中的aaaa  循环第二次 test-->B 循环第三次 C.TXT
            }
        }
        //做自己的显示（file是文件或file是一个空的文件夹)
        System.out.println(file.getAbsolutePath());
    }
    public  void deleteFile(File file){
        //判断file不是空文件夹 找人先做事
        File[] files = file.listFiles();
        if (files!=null && files.length!=0){
            for (File f:files){
                this.deleteFile(f);
            }
        }

        //删除file file是个文件或file是一个空文件夹
        file.delete();
    }
}
