package org.jpstale.server.login.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Java 版 LogServer（仅登录服侧需要的部分）。
 *
 * 主要逻辑来源：
 * - Server/server/logserver.cpp
 * - Server/server/packetserver.cpp 中 case PKTHDR_LogCheat 分支。
 */
@Component
public class LogServer {

    private static final Logger log = LoggerFactory.getLogger(LogServer.class);

    /**
     * 对应 C++:
     *   LOGSERVER->OnLogCheat(UserData* pcUserData, PacketLogCheat* psPacket)
     */
    public void onLogCheat(Object userSession, Object packet) {
        // TODO: 使用具体的 UserSession / PacketLogCheat 类型，对齐 C++ 写入数据库/文件的逻辑。
        log.trace("onLogCheat (TODO) userSession={} packet={}", userSession, packet);
    }
}

