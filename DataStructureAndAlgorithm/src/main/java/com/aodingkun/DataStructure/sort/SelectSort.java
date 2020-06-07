package com.aodingkun.DataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@ClassName: SelectSort
 *@Description: 选择排序
 *@Author: AoDingKun
 *@Date :2020/6/7 0:14
 *Project : SelectSort.java
 */
public class SelectSort {

    public static void main(String[] args) {
        //int [] arr = {101, 34, 119, 1, -1, 90, 123};

        //创建一个随机数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000] 数
        }

        System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间=" + date1Str);

        selectSort(arr);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间=" + date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));


    }

    /**
     * 选择排序
     * O(n^2)
     * @param arr
     */
    public static void selectSort(int[] arr) {


        //在推到过程 我们发现规律 可以使用for循环解决
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { //
                    min = arr[j]; //
                    minIndex = j; // minIndex
                }
            }

            //
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            //System.out.println("��"+(i+1)+"�ֺ�~~");
            //System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
		
		
		/*
		
		//使用逐步推导的方式
		//第一轮
		//原始数组 	：101, 34, 119, 1
		//第一轮排序 :   	1, 34, 119, 101
		//算法思想：先简单--》后复杂
		//将复杂的算法拆分成简单的问题
		
		//第一轮
		int minIndex = 0;//最小的索引
		int min = arr[0];
		for(int j = 0 + 1; j < arr.length; j++) {
			if (min > arr[j]) { //说明假定的最小值 并不是最小的
				min = arr[j]; // 重置最小值min
				minIndex = j; // 重置minIndex
			}
		}
		
		
		//将最小值 放在arr[0], 即交换
		if(minIndex != 0) {
			arr[minIndex] = arr[0]; //101 放到 1的位置即小标为minIndex的位置
			arr[0] = min; //1放到下标为0的位置
		}
		
		System.out.println("第一轮~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		
		
		//第二轮
		minIndex = 1;
		min = arr[1];
		for (int j = 1 + 1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
				min = arr[j]; // ����min
				minIndex = j; // ����minIndex
			}
		}

		// ����Сֵ������arr[0], ������
		if(minIndex != 1) {
			arr[minIndex] = arr[1];
			arr[1] = min;
		}

		System.out.println("��2�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		
		//��3��
		minIndex = 2;
		min = arr[2];
		for (int j = 2 + 1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
				min = arr[j]; // ����min
				minIndex = j; // ����minIndex
			}
		}

		// ����Сֵ������arr[0], ������
		if (minIndex != 2) {
			arr[minIndex] = arr[2];
			arr[2] = min;
		}

		System.out.println("��3�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 101, 119 */


    }

}
