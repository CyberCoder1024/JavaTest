package com.aodingkun.DataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BubbleSort {

    public static void main(String[] args) {
        //		int arr[] = {3, 9, -1, 10, 20};
        //
        //		System.out.println("排序前");
        //		System.out.println(Arrays.toString(arr));


        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成0---80000 之间的随机数
        }
        //测试排序时间
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间=" + date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));


		/*
		//第一躺排序
		 int temp = 0; //
        boolean flag = false; //


        for (int j = 0; j < arr.length - 1 - 0; j++) {
                //如果前面的数比后面大 交换
            if (arr[j] > arr[j + 1]) {
              flag = true;
               temp = arr[j];
               arr[j] = arr[j + 1];
                arr[j + 1] = temp;
              }

		//第二趟排序
		for (int j = 0; j < arr.length - 1 - 1 ; j++) {
			// 如果前面的数比后面大 交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("�ڶ�������������");
		System.out.println(Arrays.toString(arr));


		// 第三趟排序

		for (int j = 0; j < arr.length - 1 - 2; j++) {
			 如果前面的数比后面大 交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("����������������");
		System.out.println(Arrays.toString(arr));

		// 第四趟排序

		for (int j = 0; j < arr.length - 1 - 3; j++) {
			// ���ǰ������Ⱥ���������򽻻�
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("����������������");
		System.out.println(Arrays.toString(arr)); */

    }

    /**
     *O（n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //冒泡排序
        int temp = 0; //临时变量
        boolean flag = false; //标识变量 标识是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面大 交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("第" + (i + 1) + "趟排序");
            //System.out.println(Arrays.toString(arr));

            if (!flag) { //在一趟排序中 一次交换也没出现 flag==false
                break;
            } else {
                flag = false; //重置flag 进行下次判断
            }
        }
    }

}
