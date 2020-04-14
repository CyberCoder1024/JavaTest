package com.aodingkun.definedProtocolTcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName ServerInitializer
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/4/13
 * Project JavaTest
 * @Version 1.0
 **/
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //7 将自定义的ServerHandler 加入管道中
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new MsgDecoder());
        pipeline.addLast(new MsgEncoder());
        pipeline.addLast(new ServerHandler());//实现真正的业务逻辑
    }
}
