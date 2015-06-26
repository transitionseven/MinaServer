package com.zl.mina.jms;

import com.zl.mina.entity.NoticeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Created by Administrator on 2015/6/27.
 */
public class MyMessageListener implements MessageListener {
    private static Log LOG = LogFactory.getLog(MyMessageListener.class);

    private MyMessageConverter messageConverter;

    public MyMessageConverter getMessageConverter() {
        return messageConverter;
    }
    public void setMessageConverter(MyMessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }
    /**
     * 接收消息
     */
    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage)message;
            NoticeInfo noticeInfo = (NoticeInfo)messageConverter.fromMessage(objectMessage);
            System.out.println(noticeInfo.getNoticeContent());
            System.out.println("model:"+objectMessage.getJMSDeliveryMode());
            System.out.println("destination:"+objectMessage.getJMSDestination());
            System.out.println("type:"+objectMessage.getJMSType());
            System.out.println("messageId:"+objectMessage.getJMSMessageID());
            System.out.println("time:"+objectMessage.getJMSTimestamp());
            System.out.println("expiredTime:"+objectMessage.getJMSExpiration());
            System.out.println("priority:"+objectMessage.getJMSPriority());

        } catch (Exception e) {
            LOG.error("处理信息时发生异常",e);
        }
    }
}