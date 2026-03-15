# 登录/注册密码哈希约定与 C++ 源码位置

**日期**: 2026-03-16

## 1. 公式（与 C++ 客户端一致）

- **输入字符串**: `UPPERCASE(账号) + ":" + 明文密码`  
  - 仅**账号**做大写，**密码不做大写**。
- **存储/传输**: `SHA256(输入字符串)` 的 **64 位十六进制大写**。

示例：账号 `admin`、明文 `123456` → 输入 `"ADMIN:123456"` → 存库  
`6CCDEEF78D42BCA3BBACA378E9AB180801DF781434AE4709BA696905CB67F218`。

## 2. 本仓库实现

- **前端注册**（`server/www/js/register.js`）：  
  `input = account.toUpperCase() + ':' + password`，再 `sha256Hex(input)` 传后端。
- **后端**（pt-web-server）：只校验 64 位十六进制并直接存库，不再做哈希。
- **登录校验**（pt-login-server）：客户端发来的已是上述哈希，与 `user_info.password` 直接字符串比较。

## 3. C++ 源码位置（不在本仓库）

- **服务端**：参考仓库 **PristonTale-EU-main**（或你本地的等价 C++ 服务端仓库）  
  - 登录流程、与 DB 比对的逻辑在：`Server/server/accountserver.cpp`（如 `ProcessAccountLogin`、取 UserInfo 等）。
- **客户端**：同一 C++ 仓库内，**客户端**在发包前会先把密码按上述公式算成 SHA256 十六进制再填入登录包（如 `PacketLoginUser.szPassword`）。  
  具体实现需在客户端工程里搜 `SHA256`、`password`、`AccountName` 或登录发包处（常见在 GameCore / Client 目录下的登录或网络模块）。

若本地没有 PristonTale-EU-main，可从项目约定或原版 EU 仓库克隆后，在 `Server/server/accountserver.cpp` 与客户端登录相关代码中对照上述公式。
