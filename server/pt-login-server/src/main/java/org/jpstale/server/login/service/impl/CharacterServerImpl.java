package org.jpstale.server.login.service.impl;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.struct.packets.PacketCharacterDataEx;
import org.jpstale.server.common.struct.packets.PacketCreateCharacter;
import org.jpstale.server.login.service.CharacterServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * CharacterServer 默认实现（登录服侧）。
 *
 * 直接移植自原 core.CharacterServer，当前仅做日志与占位。
 */
@Service
public class CharacterServerImpl implements CharacterServer {

    private static final Logger log = LoggerFactory.getLogger(CharacterServerImpl.class);

    @Override
    public void handleCharacterDataEx(ChannelHandlerContext ctx, PacketCharacterDataEx packet) {
        // TODO: 按照 characterserver.cpp 中逻辑更新 / 读取角色信息并回包。
        log.trace("handleCharacterDataEx (TODO) packet={}", packet);
    }

    @Override
    public void createCharacter(ChannelHandlerContext ctx, PacketCreateCharacter packet) {
        // TODO: 校验名字/职业/位置，写入数据库后回包结果。
        log.trace("createCharacter (TODO) packet={}", packet);
    }
}

