package com.aodingkun.DataStructure.recursion;

public class Queue8 {


    int max = 8;

    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("һ����%d�ⷨ", count);
        System.out.printf("һ���жϳ�ͻ�Ĵ���%d��", judgeCount); // 1.5w

    }

    /**
     * 编写一个方法 放置n个皇后
     * check 是第一递归 进入到check中都有for循环 因此会有回溯
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) {  //n = 8 ,
            print();
            return;
        }

        //依次放入皇后，并判断是否有冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行第1列
            array[n] = i;
            //判断当反之第n个皇后到i列史，是否冲突
            if (judge(n)) { //不冲突

                check(n + 1); //接着放n+1个皇后 即开始递归
            }
            //如果冲突 就继续执行array[n]=1；即将第n个皇后，反之在本行的后移一个位置

        }
    }

    /**
     * 查看我们当前放置第n个皇后，就去检测该皇后是否和前面已经拜访的皇后冲突
     *
     * @param n 第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {

            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
