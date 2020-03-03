package com.aodingkun.IO.ATM;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO 记录数据库中的一行信息 账户 密码 余额
 * @Author jonas.ao
 * @Date 2019/12/20 15:43
 * Project JavaTest
 * @Version 1.0
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 4852604322687182777L;

    //建议 除了私有属性 无参数有参数构造方法  属性对应的get set方法之外
    //建议类实现一个序列化接口 并添加一个序列化版本号
    private String account;
    private String password;
    private Float balances;
    //无参构造方法
    public User(){

    }
    //有参的构造方法
    public  User(String account,String password){
        this.account=account;
        this.password=password;


    }
    public  User(String account,String password,Float balances){
        this.account=account;
        this.password=password;
        this.balances=balances;

    }
    public  User(String account,Float balances){
        this.account=account;
        this.balances=balances;

    }

    public String getaccount() {
        return account;
    }

    public void setaccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getbalances() {
        return balances;
    }

    public void setbalances(Float balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "[账户="+account+",密码="+password+",余额="+balances+"]";
    }



}
