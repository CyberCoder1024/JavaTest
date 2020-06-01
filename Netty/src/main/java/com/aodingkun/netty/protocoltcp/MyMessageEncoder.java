package com.aodingkun.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description: 编码形式处理
 * @Param:
 * @return:
 * @Date: 2020/1/11
 **/
public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {

        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());
        System.out.println("MyMessageEncoder encode 方法被调用");
    }
}
