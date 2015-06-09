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
        LOG.debug("处理XML");
        nextFilter.messageReceived(session,message);
    }
}
