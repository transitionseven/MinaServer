package com.zl.mina.jms;

import com.zl.mina.entity.NoticeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProducerTest {

    private static Log LOG = LogFactory.getLog(ProducerTest.class);
    private MyMessageProducer myMessageProducer;

    private String[] getConfigLocations() {
        return new String[]{
                "applicationContext-communication.xml",
                "applicationContext-activemq.xml"};
    }

    @BeforeTest
    public void setUp() {
        ApplicationContext atx = new ClassPathXmlApplicationContext(
                getConfigLocations());
        myMessageProducer = (MyMessageProducer) atx.getBean("myMessageProducer");
    }

    @Test
    public void testSendQueue() throws Exception {
        NoticeInfo noticeInfo = new NoticeInfo();
        noticeInfo.setNoticeTitle("Hi");
        noticeInfo.setNoticeContent("Hi Word");
        noticeInfo.setReceiver("sss");
        noticeInfo.setReceiverPhone("1111111");
        noticeInfo.setDestination("queue1");
        myMessageProducer.sendQueue(noticeInfo);
    }
    @Test
    public void testSendTopic() throws Exception {
        NoticeInfo noticeInfo = new NoticeInfo();
        noticeInfo.setNoticeTitle("Hello");
        noticeInfo.setNoticeContent("Hello Word");
        noticeInfo.setReceiver("everyone");
        noticeInfo.setReceiverPhone("2222222");
        noticeInfo.setDestination("topic1");
        myMessageProducer.sendTopic(noticeInfo);
    }
}