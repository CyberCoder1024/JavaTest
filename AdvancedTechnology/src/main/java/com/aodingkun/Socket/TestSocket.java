package com.aodingkun.Socket;

import java.net.InetAddress;
import java.rmi.UnexpectedException;

/**
 * @ClassName TestSocket
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/11/8
 * Projiect JavaTest
 * @Version 1.0
 **/
public class TestSocket {
    public static void main(String[] args)throws Exception {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println("本机ip地址"+ip);


    }
}
