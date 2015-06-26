package com.zl.mina.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/6/27.
 */
public class NoticeInfo implements Serializable {
    //消息标题
    private String noticeTitle;
    //消息内容
    private String noticeContent;
    // 接收者
    private String receiver;
    // 接收手机号
    private String receiverPhone;
    //目的地名称
    private String destination;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }
    public String getNoticeContent() {
        return noticeContent;
    }
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getReceiverPhone() {
        return receiverPhone;
    }
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
}
