package com.aodingkun.Thread;

/**
 * @ClassName DeadLock
 * @Description 多个线程沪线抱着对方需要的资源 然后形成僵持
 * @Author jonas.ao
 * @Date 2020/6/14
 * Project JavaTest
 * @Version 1.0
 **/
public class DeadLock {


}

class Lipstick{

}
class Mirror{

}

class MakeUp extends Thread{
    //需要的资源只有一份 static保证只有一份
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();
    int choice;
    String girlName;

    MakeUp(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }

    @Override
    public void run() {
        super.run();
    }
    private void makeUp(){
        
    }
}
