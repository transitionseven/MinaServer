package com.zl.mina.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.common.IoFilterAdapter;
import org.apache.mina.common.IoSession;

/**
 * Created by Administrator on 2015/5/27.
 */
public class CompressionFilter extends IoFilterAdapter {
    public static final Log LOG = LogFactory.getLog(CompressionFilter.class);

    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        LOG.debug("解压及解码：" + message);
        nextFilter.messageReceived(session, message);
    }

    public void filterWrite(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        LOG.debug("压缩及编码：" +  writeRequest.getMessage());
        nextFilter.filterWrite(session, writeRequest);
    }

    public void messageSent(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        nextFilter.messageSent(session, message);
        LOG.debug("CompressionFilter:send message：" + message);
    }
}
