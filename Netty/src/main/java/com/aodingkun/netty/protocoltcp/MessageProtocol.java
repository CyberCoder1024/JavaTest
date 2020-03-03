package com.aodingkun.netty.protocoltcp;

//自定义协议格式
//协议包
public class MessageProtocol {
    //定义协议长度
    private int len; //关键
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
