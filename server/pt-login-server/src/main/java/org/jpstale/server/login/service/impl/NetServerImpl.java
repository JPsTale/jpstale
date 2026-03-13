package org.jpstale.server.login.service.impl;

import org.jpstale.server.login.service.NetServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * NetServer 默认实现（登录服侧）。
 *
 * 直接移植自原 core.NetServer，目前仅做日志，占位以便后续实现。
 */
@Service
public class NetServerImpl implements NetServer {

    private static final Logger log = LoggerFactory.getLogger(NetServerImpl.class);

    @Override
    public void onNetIdentifier(Object packet) {
        log.trace("onNetIdentifier (TODO) packet={}", packet);
    }

    @Override
    public void onNetUsersOnline(Object packet) {
        log.trace("onNetUsersOnline (TODO) packet={}", packet);
    }

    @Override
    public void onNetClan(Object packet) {
        log.trace("onNetClan (TODO) packet={}", packet);
    }

    @Override
    public void onNetPlayDataEx(Object packet) {
        log.trace("onNetPlayDataEx (TODO) packet={}", packet);
    }

    @Override
    public void onNetQuestUpdateDataPart(Object packet) {
        log.trace("onNetQuestUpdateDataPart (TODO) packet={}", packet);
    }

    @Override
    public void onNetGiveExp(Object packet) {
        log.trace("onNetGiveExp (TODO) packet={}", packet);
    }

    @Override
    public void onNetPlayerGoldDiff(Object packet) {
        log.trace("onNetPlayerGoldDiff (TODO) packet={}", packet);
    }

    @Override
    public void onNetPlayerItemPut(Object packet) {
        log.trace("onNetPlayerItemPut (TODO) packet={}", packet);
    }

    @Override
    public void onNetPlayerThrow(Object packet) {
        log.trace("onNetPlayerThrow (TODO) packet={}", packet);
    }
}

