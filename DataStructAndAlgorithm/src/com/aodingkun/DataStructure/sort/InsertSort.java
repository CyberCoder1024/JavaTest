package com.aodingkun.DataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: InsertSort
 * @Description : 插入排序
 * @Author: AoDingKun
 * @Date :2020/6/7 18:33
 * Project : InsertSort.java
 */
public class InsertSort {

    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1, -1, 89};
        // ����Ҫ��80000�������������
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前=" + date1Str);

        insertSort(arr); //调用插入排序

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后=" + date2Str);

        //System.out.println(Arrays.toString(arr));


    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用 for循环 简化代码
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; //即 arr[1]的卡门面这个数的下标

            // 给insertVal找到插入位置
            //1. insertIndex >= 0保证在给 insertVal找插入位置 不越界
            //2. insertVal < arr[insertIndex] 待插入数 还没有找到适当的插入位置
            //3.  就需要将 arr[insertIndex]  后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            //当退出whileѭ循环时，说明插入的位置找到, insertIndex + 1
            //进行判断
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("��"+i+"�ֲ���");
            //System.out.println(Arrays.toString(arr));
        }

		
		/*
		
		
		//ʹ插入排序 推到的过程
		//第一轮排序 {101, 34, 119, 1};  => {34, 101, 119, 1}
		
		
		//{101, 34, 119, 1}; => {101,101,119,1}
		//定义待插入的数
		int insertVal = arr[1];//34
		int insertIndex = 1 - 1; //定义待插入数的索引 arr[1]前面数的这个下标
		
		//给insertVal找到插入的位置
		//
		//1. insertIndex >= 0保证在给 insertVal找插入位置 不越界
		//2. insertVal < arr[insertIndex] 待插入数 还没有找到适当的插入位置

		//3.  就需要将 arr[insertIndex] 101 后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex] //后移 101 101 119 1；34存放在insertValue中
			insertIndex--;//
		}
		//当退出whileѭ循环时，说明插入的位置找到, insertIndex + 1
		//使用debug
		arr[insertIndex + 1] = insertVal;
		
		System.out.println("��1�ֲ���");
		System.out.println(Arrays.toString(arr));
		
		//第二轮
		insertVal = arr[2];
		insertIndex = 2 - 1; 
		
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		
		arr[insertIndex + 1] = insertVal;
		System.out.println("��2�ֲ���");
		System.out.println(Arrays.toString(arr));
		
		
		//第三轮
		insertVal = arr[3];
		insertIndex = 3 - 1;

		while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}

		arr[insertIndex + 1] = insertVal;
		System.out.println("��3�ֲ���");
		System.out.println(Arrays.toString(arr)); */

    }

}
