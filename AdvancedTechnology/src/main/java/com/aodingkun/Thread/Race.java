package com.aodingkun.Thread;

/**
 * @ClassName Race
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/23
 * Project JavaTest
 * @Version 1.0
 **/
public class Race implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <=100 ; i++) {
            if (Thread.currentThread().getName().equals("兔") && i%10==0){
               try {
                   Thread.sleep(20);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
            }
            //判断是否结束
            boolean flag=gameOver(i);
            //如果比赛结束就停止该程序
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--->跑了"+i+"步");
        }
    }
    private static String winner;
    private boolean gameOver(int steps){
        if (winner!=null){
            return true;
        }{
            if (steps==100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is  "+winner);
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"龟").start();
        new Thread(race,"兔").start();

    }
}
