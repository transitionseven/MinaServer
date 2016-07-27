package com.zl.mina.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

/**
 * Created by Administrator on 2015/5/27.
 */
public class ServerHandler extends IoHandlerAdapter {

    public static final Log LOG = LogFactory.getLog(ServerHandler.class);

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        LOG.debug("服务异常，关闭连接");
        session.close();
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        LOG.debug("服务端收到信息：" + message);
        String response = "HTTP/1.1 200 0K \\r\\nServer: my server\\r\\nContent-Type: text/html\\r\\nContent-Length:31\\r\\n\\r\\n<html><h1>It works!</h1></html>\\r\\n";
        LOG.debug("服务端发送消息：" + message);
        session.write(response);
    }
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        LOG.debug("ServerHandler:send message：" + message);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        LOG.debug("创建session..." + session.getRemoteAddress().toString());
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        LOG.debug("打开session..."+session.getLocalAddress());
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)throws Exception {
        LOG.debug("空闲session..." + session.getServiceAddress());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        LOG.debug("关闭session..." + session.getRemoteAddress().toString());
    }

}
