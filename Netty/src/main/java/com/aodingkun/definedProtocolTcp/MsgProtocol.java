package com.aodingkun.definedProtocolTcp;

import java.util.Arrays;

/**
 * @ClassName MsgProtocol
 * @Description TODO
 * @Author jonas.ao
 * @Date 2020/4/13 17:11
 * Project JavaTest
 * @Version 1.0
 **/
public class MsgProtocol {
    /**
     * 协议数据包格式
     * +------+------+------+------+------+------+
     * |  帧头 |标志位 |长度  |数据内容 |校验位|帧尾|
     * +------+------+------+------+------+------+
     *
     */
    private int heard;
    private short flag;//标志 命令 cmd
    private int contentLength;

    private byte[] dataContent;

    private int CRC;

    private short tail;
    public MsgProtocol(){

    }

    public MsgProtocol(int heard,short flag,int contentLength,short tail){
        this.heard=heard;
        this.flag=flag;
        this.contentLength=contentLength;
        this.tail=tail;
    }
    public MsgProtocol(int heard,short flag, int contentLength,byte[] dataContent,short tail){
        this.heard=heard;
        this.flag=flag;
        this.contentLength=contentLength;
        this.dataContent=dataContent;
        this.tail=tail;
    }
    public int getHeard() {
        return heard;
    }

    public void setHeard(int heard) {
        this.heard = heard;
    }

    public short getFlag() {
        return flag;
    }

    public void setFlag(short flag) {
        this.flag = flag;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getDataContent() {
        return dataContent;
    }

    public void setDataContent(byte[] dataContent) {
        this.dataContent = dataContent;
    }

    public short getTail() {
        return tail;
    }

    public void setTail(short tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "MsgProtocol{" +
                "heard=" + heard +
                ", flag=" + flag +
                ", contentLength=" + contentLength +
                ", dataContent=" + Arrays.toString(dataContent) +
                ", tail=" + tail +
                '}';
    }
}
