package com.aodingkun.Thread.synchronizeds;

/**
 * @ClassName UnsafeBank
 * @Description
 * @Author jonas.ao
 * @Date 2020/5/24
 * Project JavaTest
 * @Version 1.0
 **/
public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(111110000,"xxxxxxx" );
        Drawing you=new Drawing(account, 1111111, 22);
        Drawing he=new Drawing(account, 1111111, 33);
        you.start();
        he.start();

    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;
  /*  public Drawing(Account account,int drawingMoney,String name){
        this.account=account;
        this.drawingMoney=drawingMoney;
         super(name);
    }*/

    public Drawing(Account account,int drawingMoney,int nowMoney){
        this.account=account;
        this.drawingMoney=drawingMoney;
        this.nowMoney=nowMoney;
    }

    @Override
    public void run() {
        super.run();
        //判断有没有money
        if (account.money-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+"钱不够 取不了");
            return;
        }
        //卡内余额
        account.money=account.money-drawingMoney;
        //手里钱
        nowMoney=nowMoney+drawingMoney;
        System.out.println(account.name+"余额"+account.money);
        System.out.println(this.getName()+"手里的钱"+nowMoney);
    }
}
