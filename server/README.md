# Server 模块（PristonTale 服务端）

子模块需 **JDK 21**。根项目为 Java 8 时请用 JDK 21 编译本模块。

## 无数据库运行（先联调协议）

不连 PostgreSQL，所有登录返回「密码错误」：

```bash
# IDEA 里 Run Configuration 添加 VM options 或 Program arguments:
--spring.profiles.active=no-db

# 或命令行
java -jar pt-login-server/target/pt-login-server-1.0.0-SNAPSHOT.jar --spring.profiles.active=no-db
```

## 本地部署 PostgreSQL

**方式一：Docker（推荐）**

```bash
cd server
docker compose up -d
# 首次会创建 userdb、gamedb 两个库
```

建表（脚本在 PristonTale-EU 仓库的 `docs/postgresql-scripts/`）：

```bash
psql -h localhost -U postgres -d userdb -f /path/to/PristonTale-EU-main/docs/postgresql-scripts/01-UserDB.sql
psql -h localhost -U postgres -d gamedb  -f /path/to/PristonTale-EU-main/docs/postgresql-scripts/02-GameDB.sql
```

**方式二：Homebrew（macOS）**

```bash
brew install postgresql@16
brew services start postgresql@16
createuser -s postgres  # 若无则创建
createdb -O postgres userdb
createdb -O postgres gamedb
# 再用 psql 执行上述两个 sql 文件
```

启用数据库后，运行 Login Server 时**不要**加 `no-db` profile，并保证 `application.yml` 里数据源指向本机 PG（默认 `localhost:5432`，用户/密码 `postgres/postgres`）。

## 子模块

| 模块 | 说明 |
|------|------|
| pt-common | 协议、包 ID、编解码 |
| pt-login-server | Login Server，端口 8484，Netty + 可选 UserDB |
| pt-game-server | Game Server，端口 8485 |

## 编译与打包

```bash
mvn -pl server -am clean package -DskipTests
```
