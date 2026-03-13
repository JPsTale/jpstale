package org.jpstale.server.login.service;

/**
 * 登录服日志接口（只涵盖当前需要的部分）。
 *
 * 对应 C++：
 * - Server/server/logserver.cpp
 * - Server/server/packetserver.cpp 中 PKTHDR_LogCheat 分支。
 */
public interface LogServer {

    void onLogCheat(Object userSession, Object packet);
}

