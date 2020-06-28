package com.aodingkun.DataStructure.search;

import java.util.Arrays;

/**
 * @ClassName: FibonacciSearch
 * @Description: 斐波那契查找
 * @Author: AoDingKun
 * @Date :2020/6/17 16:12
 * Project : FibonacciSearch.java
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 189));// 0

    }

    /**
     * mid=low+F(k-1)-1
     * 获取斐波那契数列
     * 使用非递归的方式
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    /**编写斐波那契查找算法
     * @param a   ����
     * @param key 需要查找的关键码
     * @return 返回对应的下标
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0; //斐波那契数列分割值的下标
        int mid = 0; //存放 midֵ
        int f[] = fib(); //获取斐波那契数列
        //获取斐波那契分割值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //f[k] 可能大于a的长度 需要使用Arrays类 构造一个新的数组 并指向a[]
        //不足 的部分会0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        //循环处理 找到需要的key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                /**
                 * 1.全部元素=前面的元素+后边的元素
                 * 2.f[k]=f[k-1]+f[k-2]
                 * 因为前面由f[k-1]个元素，所以可以继续拆分 f[k-1]=f[k-2]+f[k-3]
                 * 记载f[k-1]前面继续查找k--
                 */
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                /**
                 * 1.全部元素=前面的元素+后边的元素
                 * 2.f[k]=f[k-1]+f[k-2]
                 * 因为前面由f[k-2]个元素，所以可以继续拆分 f[k-1]=f[k-3]+f[k-4]
                 * 记载f[k-1]前面继续查找k-=2
                 * 下次循环 mid=f[k-1-2]-1
                 */
                k -= 2;
            } else {
               //需要确定的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
