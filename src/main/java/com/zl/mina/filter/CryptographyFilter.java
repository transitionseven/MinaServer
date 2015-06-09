package com.zl.mina.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.common.IoFilterAdapter;
import org.apache.mina.common.IoSession;

/**
 * Created by Administrator on 2015/5/27.
 */
public class CryptographyFilter  extends IoFilterAdapter {
    public static final Log LOG = LogFactory.getLog(CryptographyFilter.class);

    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message)
            throws Exception {
        LOG.debug("加解密");
        nextFilter.messageReceived(session, message);
    }
}
