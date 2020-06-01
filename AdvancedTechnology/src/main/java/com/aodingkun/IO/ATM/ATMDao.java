package com.aodingkun.IO.ATM;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @ClassName ATMDao
 * @Description TODO 持久层 操作数据 读写数据
 * @Author jonas.ao
 * @Date 2019/12/21 21:42
 * Project JavaTest
 * @Version 1.0
 **/
public class ATMDao {

    //负责加载文件 更新文件
    private FileLoadAndCommit fileLoadAndCommit = new FileLoadAndCommit("src\\com.aodingkun.IO\\ATM\\Bank.txt");

    //设计一个对象 目的是为了我们的所有业务
    public User selectOne(String account) {
        return userBox.get(account);
    }

    //TODO 设计一个方法 目的是为了修改完毕的对象存入集合;//将集合内所有最终的数据全部写入文件中 文件内的所有内容替换
    public void updateOne(User user) {
        //先更新集合
        userBox.put(user.getaccount(), user);//集合做了修改
        //this.commit();
        //TODO 改进为自动提交 后更新文件
        fileLoadAndCommit.commit(userBox);
    }

    //TODO 增加
    public void insertOne(User user) {
        user.setaccount("");
        userBox.put(user.getaccount(), user);

    }


    //键值对
    //键 用户账户 ；值 用户对象 三个属性 可读性好
    //集合除了可以充当缓存 增强执行性能之外 还能用来记录修改
    // private HashMap<String,User> userBox=new HashMap<String,User>();
    private HashMap<String, User> userBox = fileLoadAndCommit.loadFile();

}
