package org.jpstale.server.login.service.impl;

import org.jpstale.server.login.service.LogServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * LogServer 默认实现（登录服侧）。
 */
@Service
public class LogServerImpl implements LogServer {

    private static final Logger log = LoggerFactory.getLogger(LogServerImpl.class);

    @Override
    public void onLogCheat(Object userSession, Object packet) {
        // TODO: 使用具体的 UserSession / PacketLogCheat 类型，对齐 C++ 写入数据库/文件的逻辑。
        log.trace("onLogCheat (TODO) userSession={} packet={}", userSession, packet);
    }
}

