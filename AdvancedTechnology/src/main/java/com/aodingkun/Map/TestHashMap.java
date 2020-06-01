package com.aodingkun.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TestHashMap
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/26
 * Project JavaTest
 * @Version 1.0
 **/
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(4, "敖丁");
        hashMap.put(1, "敖甲");
        hashMap.put(1, "敖甲1");//key相同 value不同
        hashMap.put(3, "敖丙");
        hashMap.put(2, "敖乙");
        hashMap.put(5, "敖丙");//key不同 value相同
        System.out.println(hashMap);
        //获取集合中其全部的entry对象

        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator1 = entrySet.iterator();
        //TODO 遍历
        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> entry = iterator1.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);


        }
        hashMap.remove(5);
        System.out.println(hashMap);
        //TODO 获取map集合的全部key
        Set<Integer> keys = hashMap.keySet();
        //TODO 通过迭代器遍历keys
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key + "---" + value);
        }
    }


    private HashMap<String, String> userBox = new HashMap<String, String>();

    {
        userBox.put("敖丙", "ABC1234");
        userBox.put("哪吒", "abc9876");

    }

    public String login(String name, String password) {
        String realPassword = userBox.get(name);
        if (realPassword != null) {
            //人命存在
            if (realPassword.equals(password)) {
                return "登录成功";
            }
        }
        return "用户名或密码错误";
    }
}