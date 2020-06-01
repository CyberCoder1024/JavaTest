package com.aodingkun.definedProtocolTcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName MsgDecoder
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/4/13
 * Project JavaTest
 * @Version 1.0
 **/
public class MsgDecoder extends ByteToMessageDecoder {
    //数据包长度
    public static int PACKET_LENGTH = 4 + 2 + 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> listOut) throws Exception {
        //需要将得到二进制字节码 转成-> MessageProtocol 数据包(对象)
        //获取协议的帧头
        int heard = byteBuf.readInt();


        //
        if (byteBuf.readableBytes() >= PACKET_LENGTH) {
            if (byteBuf.readableBytes() > 2048) {
                byteBuf.skipBytes(byteBuf.readableBytes());
            }

            int beginReader;//记录 包头开始的index

            while (true) {
                //获取包头开始index
                beginReader = byteBuf.readerIndex();
                //标记包头开始的index
                byteBuf.markReaderIndex();
                //READ 协议开始的标志，结束while循环
                if (heard == MsgConstant.HEARD) {
                    break;
                }

                //未读到包头，跳过一个字节
                //每次略过一个字节 去读取 包头信息开始标记
                byteBuf.resetReaderIndex();
                byteBuf.readByte();

                //当略过一个字节之后
                //数据包的长度 又变得不满足，此时应该结束，等待后面的数据到达
                if (byteBuf.readableBytes() < PACKET_LENGTH) {
                    return;
                }

            }


            //获取标志位
            short flag = byteBuf.readShort();


            //消息的长度
            //获取消息数据长度
            int contentLength = byteBuf.readInt();
            if (byteBuf.readableBytes() < contentLength) {
                //还原指针
                byteBuf.readerIndex(beginReader);
                return;
            }
            //读取数据
            byte[] dataContent = new byte[contentLength];
            byteBuf.readBytes(dataContent);

            //获取消息的帧尾
            short tail = byteBuf.readShort();


            MsgProtocol protocol = new MsgProtocol(heard, flag, contentLength, dataContent, tail);
            listOut.add(protocol);


        }


    }
}
