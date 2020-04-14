package com.aodingkun.definedProtocolTcp;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName ServerHandler
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/4/13
 * Project JavaTest
 * @Version 1.0
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MsgProtocol msgProtocol = (MsgProtocol) msg;
        short flag = msgProtocol.getFlag();
        int contentLength = msgProtocol.getContentLength();
        byte[] dataContent = msgProtocol.getDataContent();
        System.out.println("服务器收到的内容如下");
        System.out.println("标志位"+flag);
        System.out.println("数据长度"+contentLength);
        System.out.println("数据内容"+new String(dataContent, Charset.forName("utf-8")));

        System.out.println("内容"+dataContent.toString());

        //恢复消息
        String responseCode = UUID.randomUUID().toString();
        int responseLen = responseCode.getBytes("utf-8").length;
        byte[] responseContent = responseCode.getBytes("utf-8");

        //构建一个协议包
        MsgProtocol msgProtocol1 = new MsgProtocol();
        msgProtocol1.setHeard(MsgConstant.HEARD);
        msgProtocol1.setFlag(MsgConstant.FLAG_RECALL);
        msgProtocol1.setContentLength(responseLen);
        msgProtocol1.setDataContent(responseContent);
        msgProtocol1.setTail(MsgConstant.TAIL);

        ctx.writeAndFlush(msgProtocol1);


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
