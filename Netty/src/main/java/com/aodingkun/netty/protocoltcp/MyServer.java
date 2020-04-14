package com.aodingkun.netty.protocoltcp;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {
    public static void main(String[] args) throws Exception{

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)//指定NIO连接通信
                    .childHandler(new MyServerInitializer()); //自定义一个初始化类

            //绑定对应的端口号 并启动监听端口上的连接
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            //等待关闭 同步端口
            channelFuture.channel().closeFuture().sync();


        }finally {
            //优雅释放线程资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
