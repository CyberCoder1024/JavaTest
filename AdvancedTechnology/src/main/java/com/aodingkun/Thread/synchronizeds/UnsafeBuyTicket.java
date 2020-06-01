package com.aodingkun.Thread.synchronizeds;

/**
 * @ClassName UnsafeBuyTicket
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/24
 * Project JavaTest
 * @Version 1.0
 **/
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"黄牛党").start();
        new Thread(buyTicket,"学生党").start();
        new Thread(buyTicket,"铁路职工").start();
        new Thread(buyTicket,"抢票的你").start();
    }
}
class BuyTicket implements Runnable{
    private int ticketNums=10;
    private boolean flag=true;//外部停止
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            }catch (InterruptedException  e){
                e.printStackTrace();
            }


        }

    }

    private void buy() throws InterruptedException {
        if (ticketNums<=0){
            flag=false;

            return;
        }
        //模拟延时
        Thread.sleep(100);
        //buy
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);

    }
}