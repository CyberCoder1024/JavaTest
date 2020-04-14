package com.aodingkun.definedProtocolTcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName Server
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/4/13
 * Project JavaTest
 * @Version 1.0
 **/
public class Server {
    public static void main(String[] args) throws Exception {
        //1 第一个线程组用于接收Client 连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2 第二个线程组用于接收实际业务
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try{
            //3 创建一个启动NIO服务的辅助启动类ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //4 绑定两个线程组
            serverBootstrap.group(bossGroup,workGroup)
                    //5 需要指定使用NioSocketServerChannel 这种类型的通道
                    .channel(NioServerSocketChannel.class)
                    //6 一定需要使用ChildHandler 去绑定那个具体事务处理器
                    .childHandler(new ServerInitializer())
                    //8  设置TCP的缓冲区
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    // 设置发送缓存大小 32k发送缓冲
                    .option(ChannelOption.SO_SNDBUF, 32*1024)
                    //设置接收缓冲大小
                    .option(ChannelOption.SO_RCVBUF,32*1024 )
                    //9 保持连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            //10 绑定指定端口进行监听 可以绑定多个端口
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();//对应端口异步等待关闭


        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }
}
