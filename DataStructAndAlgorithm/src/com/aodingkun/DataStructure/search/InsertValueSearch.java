package com.aodingkun.DataStructure.search;

/**
 * @ClassName: InsertValueSearch
 * @Description: 插值查找算法
 * int mid=left+(right-left)*(findval-arr[left])/(arr[right]-arr[left])
 * @Author: AoDingKun
 * @Date :2020/6/17 16:12
 * Project : InsertValueSearch.java
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        //		int [] arr = new int[100];
        //		for(int i = 0; i < 100; i++) {
        //			arr[i] = i + 1;
        //		}

        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};

       int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
       // int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);

        //System.out.println(Arrays.toString(arr));
    }

    /**
     * 二分法查找
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("开始二分法查找~");
        // �� left > right ʱ��˵���ݹ��������飬����û���ҵ�
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // �� �ҵݹ�
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // ����ݹ�
            return binarySearch(arr, left, mid - 1, findVal);
        } else {

            return mid;
        }

    }


    /**
     * 插值查找算法
     *
     * @param arr
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找目标值
     * @return 如果找到就返回下标   如果没有找到就返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("插值查找算法~~");

        //findVal < arr[0]    findVal > arr[arr.length - 1]
        //
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        /**
         * 求出mid
         * int mid=left+(right-left)*(findval-arr[left])/(arr[right]-arr[left])
         */
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (findVal > midVal) { // 说明应该向右查找
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
