package com.zl.mina.jms;

import com.zl.mina.entity.NoticeInfo;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

/**
 * Created by Administrator on 2015/6/27.
 */
//消息生产者服务类
public class MyMessageProducer {
    private JmsTemplate jmsTemplate;
    private Destination destination;
    private MyMessageConverter messageConverter;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public MyMessageConverter getMessageConverter() {
        return messageConverter;
    }

    public void setMessageConverter(MyMessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    /**
     * 发送消息
     * @param noticeInfo
     */
    public void sendQueue(NoticeInfo noticeInfo){
        jmsTemplate.setMessageConverter(messageConverter);
        jmsTemplate.setPubSubDomain(false);
        Destination destination = new ActiveMQQueue(noticeInfo.getDestination());
        jmsTemplate.convertAndSend(destination, noticeInfo);
    }

    public void sendTopic(NoticeInfo noticeInfo){
        jmsTemplate.setMessageConverter(messageConverter);
        jmsTemplate.setPubSubDomain(true);
        Destination destination = new ActiveMQTopic(noticeInfo.getDestination());
        jmsTemplate.convertAndSend(destination,noticeInfo);
    }

}
