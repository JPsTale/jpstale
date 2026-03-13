# 登录响应包不加密设计（与 C++ 一致）

**日期**: 2026-03-13  
**目标**: 解决 C++ 客户端在 Java 登录服成功返回后仍一直显示 "Connecting.." 的问题。

## 背景与根因

- Java 登录服已能正确加解密消息体，并在登录成功时发送：`PacketAccountLoginCode(SUCCESS)` → `PacketUserInfo` → `PacketServerList`。
- C++ 服务端行为（`accountserver.cpp` / `server.cpp`）：
  - **成功时**：不发送 `PacketAccountLoginCode`，只发送 **PacketUserInfo**（`OnLoginSuccess`）和 **PacketServerList**（`PHServerList`），且二者均通过两参 `SendPacket(..., FALSE)` 即**不加密**发出。
  - **失败时**：发送 `PacketAccountLoginCode`，且使用 `SendPacket(..., TRUE)` 加密。
- Java 端 `PtCryptoHandler` 此前对除 KeySet、Version 以外的**所有**出站包做加密，导致 **UserInfo、ServerList** 被加密发出；客户端按 C++ 预期以明文解析这两包，得到乱码，无法离开 Connecting 状态。

## 设计决策（方案 A）

采用**协议行为对齐**：在 Java 端对登录成功后的 **UserInfo、ServerList** 与 C++ 一致，**不加密**发出。

- **不改动**：AccountLoginCode 仍按现有逻辑发送（成功/失败均可）；若后续需与 C++ 完全一致，可再考虑成功时不发 AccountLoginCode。
- **改动点**：在 `PtCryptoHandler.write()` 中，对 `PKTHDR_UserInfo`、`PKTHDR_ServerList` 与 KeySet、Version 一样，**跳过** `encryptPacket`，直接写出。

## 实现

- **文件**: `server/pt-common/.../PtCryptoHandler.java`
- **逻辑**: 在 `write()` 内，根据包头 `header` 判断；若为 `PKTHDR_UserInfo` 或 `PKTHDR_ServerList`，则不再调用 `state.encryptPacket(data)`，直接 `super.write(ctx, msg, promise)` 返回。

## 验证

1. 启动 Java 登录服，用 C++ 客户端使用硬编码账号（如 admin / 对应密码）登录。
2. 预期：客户端收到 UserInfo、ServerList 明文后，能正确解析并离开 "Connecting.."，进入角色选择或服务器列表界面。
3. 若仍卡在 Connecting，再考虑方案 B（抓包/二进制对比）进一步排查包体格式或顺序。

## 参考

- C++：`Server/server/accountserver.cpp`（OnLoginSuccess、ProcessAccountLogin）、`Server/server/server.cpp`（PHServerList）、`Server/server/packetserver.cpp`（Send 两参/三参）。
- Java：`PtCryptoHandler`、`AccountServerImpl`（sendUserInfo、sendServerList）。
