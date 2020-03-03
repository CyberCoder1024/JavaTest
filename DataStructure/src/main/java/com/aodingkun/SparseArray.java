package com.aodingkun;

/**
 * @ClassName SparseArray
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/2/27
 * Project JavaTest
 * @Version 1.0
 **/
public class SparseArray {
    public static void main(String[] args) {
        //创建一个元素的二维数组 11*11
        //0代表没有妻子 1表示黑子 2表示白子
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][5]=2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row:chessArr1) {
            for (int data:
                    row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组转 稀疏数组
        //1 遍历二维数组 得到非零数据个数
        int sum=0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1.length ; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);
        //2 创建对应的稀疏数组
        int sparseArray[][]=new int[sum + 1][3];
        //给稀疏数组幅值
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;
        //3 遍历二维数组 将非0数存入稀疏数组
        int count=0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1.length ; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArr1[i][j];
                }

            }

        }

        //输出稀疏数组
        System.out.println();
        System.out.println("----得到的稀疏数组------");;
        for (int i = 0; i <sparseArray.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
            
        }
        System.out.println();

        //稀疏数组 ----->>二维数组
        //1、先读取稀疏数组的第一行 根据第一行的数据 创建原始的数据
        int chessArr2[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        //2、在读取稀疏数组后几行的数据 从第二行开始 创建原始的二维数组
        for (int i = 1; i <sparseArray.length ; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出恢复的二维数组
        System.out.println();
        System.out.println("huanyuan");

        for (int[] row:chessArr2) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
