package com.aodingkun.DataStructure.recursion;

public class MiGong {

    public static void main(String[] args) {
        //创建二维素组 模拟迷宫
        //地图
        int[][] map = new int[8][7];

        //	使用1表示墙；
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][2] = 1;


        System.out.println("输出地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //使用递归 回溯给小球找路
        setWay(map, 1, 1);

        setWay2(map, 1, 1);


        System.out.println("小球走过并标识的路");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归
     * 1. map表示地图
     * 2. i，j 表示从地图那个位置； 出发位置 （1，1） 结束位置（6，5）
     * 3. 约定：map[i][j] 为0表示该点没有走过，为1表示墙；为2 表示通路可以走；3 表示该点已经走过，但是走不通
     * 4. 策略方法确定 ：先 下--右--上--左；如果该点不通 回溯
     *
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，返回true；反之为false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//当前点没有走过
                //按照策略
                map[i][j] = 2;//假定该店可通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //该点置为3
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }


    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) {
                    return true;
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                } else if (setWay2(map, i + 1, j)) {
                    return true;
                } else if (setWay2(map, i, j - 1)) {
                    return true;
                } else {

                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
