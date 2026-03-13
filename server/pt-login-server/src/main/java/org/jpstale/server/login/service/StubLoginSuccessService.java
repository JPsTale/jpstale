package org.jpstale.server.login.service;

import org.jpstale.server.common.codec.PacketIds;
import org.jpstale.server.common.packet.Header;
import org.jpstale.server.common.packet.PacketServerList;
import org.jpstale.server.common.packet.PacketUserInfo;
import org.jpstale.server.common.packet.Server;
import org.jpstale.server.common.packet.TransCharInfo;
import org.jpstale.server.login.api.LoginSuccessServiceApi;
import org.springframework.stereotype.Service;

/**
 * 占位实现：返回 0 个角色的 UserInfo 和固定 1 条服务器的 ServerList。
 * TODO: 与 C++ 一致实现，查 CharacterInfo、ServerDB/配置。
 */
@Service
public class StubLoginSuccessService implements LoginSuccessServiceApi {

    @Override
    public PacketUserInfo buildUserInfo(String accountName) {
        PacketUserInfo p = new PacketUserInfo();
        p.setPktHeader(PacketIds.PKTHDR_UserInfo);
        p.setUserId(accountName != null ? accountName : "");
        p.setCharCount(0);
        TransCharInfo[] arr = new TransCharInfo[6];
        for (int i = 0; i < 6; i++) arr[i] = new TransCharInfo();
        p.setCharacterData(arr);
        return p;
    }

    @Override
    public PacketServerList buildServerList(int ticket) {
        PacketServerList p = new PacketServerList();
        p.setPktHeader(PacketIds.PKTHDR_ServerList);
        Header h = new Header();
        h.setServerName("Local");
        h.setTime((int) (System.currentTimeMillis() / 1000));
        h.setTicket(ticket);
        h.setUnknown(0);
        h.setClanServerIndex(0);
        h.setGameServers(1);
        p.setHeader(h);
        Server[] servers = new Server[4];
        Server s0 = new Server();
        s0.setName("Game1");
        s0.getIp()[0] = "127.0.0.1";
        s0.getPort()[0] = 8485;
        s0.getPort()[1] = 8485;
        s0.getPort()[2] = 8485;
        s0.getPort()[3] = 0;
        servers[0] = s0;
        for (int i = 1; i < 4; i++) servers[i] = new Server();
        p.setServers(servers);
        return p;
    }
}
