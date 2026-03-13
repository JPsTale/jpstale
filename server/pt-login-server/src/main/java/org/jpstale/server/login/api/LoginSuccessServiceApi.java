package org.jpstale.server.login.api;

import org.jpstale.server.common.struct.PacketServerList;
import org.jpstale.server.common.struct.PacketUserInfo;

/**
 * 登录成功后的流程：组 PacketUserInfo（角色列表）、PacketServerList（服务器列表+Ticket）。
 * 对应 C++ AccountServer::OnLoginSuccess、Server::PHServerList。
 */
public interface LoginSuccessServiceApi {

    /**
     * 为已认证账号组角色列表包（查 CharacterInfo、组 6 个 _TRANS_CHAR_INFO）。
     * TODO: 与 C++ 一致实现，查 DB/文件；当前 stub 可返回 0 个角色。
     */
    PacketUserInfo buildUserInfo(String accountName);

    /**
     * 组服务器列表包（从配置或 ServerDB 读；当前 stub 返回占位 1 条）。
     */
    PacketServerList buildServerList(int ticket);
}
