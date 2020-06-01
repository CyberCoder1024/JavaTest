package com.aodingkun.definedProtocolTcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName MsgEncoder
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/4/13
 * Project JavaTest
 * @Version 1.0
 **/
public class MsgEncoder extends MessageToByteEncoder<MsgProtocol> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MsgProtocol msgProtocol, ByteBuf bufOut) throws Exception {
        //写入消息的具体内容
        bufOut.writeInt(msgProtocol.getHeard());
        bufOut.writeShort(msgProtocol.getFlag());
        bufOut.writeInt(msgProtocol.getContentLength());
        bufOut.writeBytes(msgProtocol.getDataContent());


    }
}
