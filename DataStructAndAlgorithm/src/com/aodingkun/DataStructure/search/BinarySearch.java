package com.aodingkun.DataStructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BinarySearch
 * @Description: 二分法查找
 * @Author: AoDingKun
 * @Date :2020/6/17 15:04
 * Project : BinarySearch.java
 */
public class BinarySearch {

    public static void main(String[] args) {
        //使用二分法查找 目标数组应该有序
        //int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};


        //
        //		int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
        //		System.out.println("resIndex=" + resIndex);

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1);
        System.out.println("resIndexList=" + resIndexList);
    }


    /**
     * 二分查找
     *
     * @param arr
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找目标值
     * @return 如果找到就返回下标  如果没有找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {


        // left > right 说明递归整个数组 但是没有找到目标值
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            /**
             *
             */
            return mid;
        }

    }

    /**
     * 完成同一个课后思考题
     * 思路分析：
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        System.out.println("hello~");
        // left > right 说明递归整个数组 但是没有找到目标值
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            /**
             * 1.在找到mid索引值 不要马上返回
             * 2.向mid 索引值的左边扫描 将所有满足1000 的元素的下标 加入到集合ArrayList
             * 3.向mid 索引值的右边扫描 将所有满足1000 的元素下标 加入到集合rrayList
             * 4.将ArrayList 返回
             */


            List<Integer> resIndexlist = new ArrayList<Integer>();
            // 向mid 索引值的左边扫描 将所有满足1000 的元素的下标 加入到集合ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {//退出递归遍历
                    break;
                }
                //否则 temp  放入resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp左移
            }
            resIndexlist.add(mid);  //

            //向mid 索引值的右边扫描 将所有满足1000 的元素下标 加入到集合rrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {//�˳�
                    break;
                }
                ///否则 temp  放入resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp右移
            }

            return resIndexlist;
        }

    }
}
