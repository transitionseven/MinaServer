package com.zl.mina.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.common.IoFilterAdapter;
import org.apache.mina.common.IoSession;

/**
 * Created by Administrator on 2015/5/27.
 */
public class XmlBeanBindingFilter extends IoFilterAdapter {
    public static final Log LOG = LogFactory.getLog(XmlBeanBindingFilter.class);

    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        LOG.debug("处理XML：" + message);
        nextFilter.messageReceived(session,message);
    }
    public void filterWrite(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        LOG.debug("封装XML：" + writeRequest.getMessage());
        nextFilter.filterWrite(session,writeRequest);
    }
    public void messageSent(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        nextFilter.messageSent(session, message);
        LOG.debug("XmlBeanBindingFilter:send message：" + message);
    }
}
