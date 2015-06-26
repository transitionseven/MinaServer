package com.zl.mina.jms;

/**
 * Created by Administrator on 2015/6/27.
 */


import com.zl.mina.entity.NoticeInfo;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * 消息转换
 */
public class MyMessageConverter implements MessageConverter {
    private static Log LOG = LogFactory.getLog(MyMessageConverter.class);
    @Override
    /**
     * 转换接收到的消息为NoticeInfo对象
     */
    public Object fromMessage(Message message) throws JMSException,
            MessageConversionException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Receive JMS message :"+message);
        }
        if (message instanceof ObjectMessage) {
            ObjectMessage oMsg = (ObjectMessage)message;
            if (oMsg instanceof ActiveMQObjectMessage) {
                ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage)oMsg;
                try {
                    NoticeInfo noticeInfo = (NoticeInfo)aMsg.getObject();
                    return noticeInfo;
                } catch (Exception e) {
                    LOG.error("Message:${} is not a instance of NoticeInfo."+message.toString());
                    throw new JMSException("Message:"+message.toString()+"is not a instance of NoticeInfo."+message.toString());
                }
            }else{
                LOG.error("Message:${} is not a instance of ActiveMQObjectMessage."+message.toString());
                throw new JMSException("Message:"+message.toString()+"is not a instance of ActiveMQObjectMessage."+message.toString());
            }
        }else {
            LOG.error("Message:${} is not a instance of ObjectMessage."+message.toString());
            throw new JMSException("Message:"+message.toString()+"is not a instance of ObjectMessage."+message.toString());
        }
    }

    @Override
    /**
     * 转换NoticeInfo对象为消息
     */
    public Message toMessage(Object obj, Session session) throws JMSException,
            MessageConversionException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Convert Notify object to JMS message:${}"+obj.toString());
        }
        if (obj instanceof NoticeInfo) {
            ActiveMQObjectMessage msg = (ActiveMQObjectMessage)session.createObjectMessage();
            msg.setObject((NoticeInfo)obj);
            return msg;
        }else {
            LOG.debug("Convert Notify object to JMS message:${}"+obj.toString());
        }
        return null;
    }
}
