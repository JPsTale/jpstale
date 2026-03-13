package org.jpstale.server.login.service;

/**
 * 登录服侧 Net* 包处理接口。
 *
 * 对应 C++：
 * - Server/server/netserver.cpp
 * - Server/server/packetserver.cpp 中所有 PKTHDR_Net* 分支（LoginServer 相关部分）。
 */
public interface NetServer {

    void onNetIdentifier(Object packet);

    void onNetUsersOnline(Object packet);

    void onNetClan(Object packet);

    void onNetPlayDataEx(Object packet);

    void onNetQuestUpdateDataPart(Object packet);

    void onNetGiveExp(Object packet);

    void onNetPlayerGoldDiff(Object packet);

    void onNetPlayerItemPut(Object packet);

    void onNetPlayerThrow(Object packet);
}

