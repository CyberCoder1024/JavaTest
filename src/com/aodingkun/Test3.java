package com.aodingkun;

/**
 * @ClassName Test3
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/12
 * Project JavaTest
 * @Version 1.0
 **/
public class Test3 {
    public static void main(String[] args) {
        int i = 0;
        i = i++ + ++i;//执行++i，++i后i的值是1，执行完++i后要补增i++，
        // 所以此时i的值实际上是2，0+2=2，然后赋值给i，最终i的值是2
        int j = 0;
        j = ++j + j++ + j++ + j++;//1+1+2+3=7
        int k = 0;
        k = k++ + k++ + k++ + ++k;//0+1+2+4=7，
        int h = 0;
        h = ++h + ++h;//1 +2=3
        int p1 = 0, p2 = 0;
        int q1 = 0, q2 = 0;
        q1 = ++p1;//1
        q2 = p2++;//0 1
        System.out.println("i" + i);
        System.out.println("j" + j);
        System.out.println("k" + k);
        System.out.println("h" + h);
        System.out.println("p1" + p1);
        System.out.println("p2" + p2);
        System.out.println("q1" + q1);
        System.out.println("q2" + q2);
    }
}
