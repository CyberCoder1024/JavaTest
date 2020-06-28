package com.aodingkun.DataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MergetSort
 * @Description:
 * @Author: AoDingKun
 * @Date :2020/6/7 19:55
 * Project : MergetSort.java
 */
public class MergetSort {

    public static void main(String[] args) {
        //int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //

        //���Կ��ŵ�ִ���ٶ�
        // ����Ҫ��80000�������������
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }
        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外的空间
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

        //System.out.println("�鲢�����=" + Arrays.toString(arr));
    }


    /**
     * 分+合的方法
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //
            merge(arr, left, mid, right, temp);

        }
    }

    /**
     * @param arr   原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     * @Description : 功能说明 合并的方法
     * @MethodName merge
     * @Description:
     * @Return : void
     * @Author : AoDingKun
     * @Date : 2020/6/7 21:47
     */

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left; // 初始i 左边有序序列列的初始索引
        int j = mid + 1; //初始化j 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        /**1
         *先把左右两边（youxu)的数据按照规则填充到temp数组
         * 直到左右两边的有序序列 右一边处理完毕为止
         */
        while (i <= mid && j <= right) {//
            // 如果左边的有序序列的当前元素 小于等于右边有序序列的当前元素
            //即将 左边的当前元素 拷贝到temp数组
            //然后 t++, i++
            //
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之 将右边有序序列的当前元素 填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        /**
         * 2
         * 把有剩余数据的以边的数据一次全部填充到temp
         */
        while (i <= mid) { //说明左边的有序学列还要剩余元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) { //右边的有序序列还要剩余元素 就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }


        /**
         * 3
         * 将temp数组的元素拷贝到arr
         * 注意 并不是每次都拷贝所有
         */
        t = 0;
        int tempLeft = left; //第一次
        //  tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        // 最好一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

}
