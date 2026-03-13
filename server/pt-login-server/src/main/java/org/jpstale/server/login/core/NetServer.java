package org.jpstale.server.login.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Java 版 NetServer（Login/Game 服之间的 Net* 包处理，登录服侧）。
 *
 * 主要逻辑来源：
 * - Server/server/netserver.cpp
 * - Server/server/packetserver.cpp 中所有 PKTHDR_Net* 相关分支。
 *
 * 当前仅定义接口和日志，具体实现留 TODO，后续可逐项对照 C++ 迁移。
 */
@Component
public class NetServer {

    private static final Logger log = LoggerFactory.getLogger(NetServer.class);

    public void onNetIdentifier(Object packet) {
        // TODO: 对齐 C++ 中 Net 标识逻辑。
        log.trace("onNetIdentifier (TODO) packet={}", packet);
    }

    public void onNetUsersOnline(Object packet) {
        // TODO: 处理 GameServer 上报的在线人数。
        log.trace("onNetUsersOnline (TODO) packet={}", packet);
    }

    public void onNetClan(Object packet) {
        // TODO: 处理公会相关同步。
        log.trace("onNetClan (TODO) packet={}", packet);
    }

    public void onNetPlayDataEx(Object packet) {
        // TODO: 处理 PlayDataEx 从 GameServer 转发到 LoginServer 的数据。
        log.trace("onNetPlayDataEx (TODO) packet={}", packet);
    }

    public void onNetQuestUpdateDataPart(Object packet) {
        // TODO: 任务同步。
        log.trace("onNetQuestUpdateDataPart (TODO) packet={}", packet);
    }

    public void onNetGiveExp(Object packet) {
        // TODO: 处理 GameServer 请求 LoginServer 给经验。
        log.trace("onNetGiveExp (TODO) packet={}", packet);
    }

    public void onNetPlayerGoldDiff(Object packet) {
        // TODO: 金币变动同步。
        log.trace("onNetPlayerGoldDiff (TODO) packet={}", packet);
    }

    public void onNetPlayerItemPut(Object packet) {
        // TODO: 玩家放入物品同步。
        log.trace("onNetPlayerItemPut (TODO) packet={}", packet);
    }

    public void onNetPlayerThrow(Object packet) {
        // TODO: 玩家丢弃物品同步。
        log.trace("onNetPlayerThrow (TODO) packet={}", packet);
    }
}

