package org.jpstale.server.login.service;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.struct.packets.PacketCharacterDataEx;
import org.jpstale.server.common.struct.packets.PacketCreateCharacter;

/**
 * 登录服角色相关接口。
 *
 * 对应 C++：
 * - Server/server/characterserver.cpp
 * - Server/server/packetserver.cpp 中 PKTHDR_CharacterDataEx / PKTHDR_CreateCharacter。
 */
public interface CharacterServer {

    void handleCharacterDataEx(ChannelHandlerContext ctx, PacketCharacterDataEx packet);

    void createCharacter(ChannelHandlerContext ctx, PacketCreateCharacter packet);
}

