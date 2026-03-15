# pt-dao 模块设计

**日期**: 2026-03-15  
**目标**: 在 server 下新增 pt-dao 模块，以 **Spring Boot Starter** 形式交付，集成 dynamic-datasource、MyBatis-Plus、Hikari，确保 **Spring Boot 4.0 兼容**；按 PostgreSQL schema 组织包与代码生成，供 pt-login-server（及后续 pt-game-server）复用。

## 1. 背景与范围

- **现状**：pt-login-server 使用 spring-boot-starter-jdbc + PostgreSQL（库 `pt`）+ Flyway，登录等逻辑尚未真正查库；pt-game-server 另有 gamedb 配置。
- **目标**：
  - 新增可复用 DAO 层，以 **pt-dao-spring-boot-starter** 形式提供：应用只需引入该 starter 并在 `application.yml` 中填写数据源连接信息即可获得统一的多数据源 + MyBatis-Plus 行为。
  - 支持**单库多 schema** 或**多数据源**：一个 PostgreSQL 库 `pt` 下用 schema（userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb）做逻辑隔离时，可只配一个数据源，通过 `@TableName(schema="<schema>", value="表名")` 区分；若将来需要多库，则通过 dynamic-datasource 配置多个数据源，使用 `@DS("xxx")` 切换。
  - **Spring Boot 4.0 兼容**：所有相关依赖均使用官方提供的 Spring Boot 4 专用 starter/版本，并在实现与清单中显式验证。
  - pt-login-server 全部改为通过 pt-dao 访问数据库，移除 spring-boot-starter-jdbc。
- **边界**：pt-dao 提供 entity、mapper（及可选 XML）及 starter 自动配置；业务 Service 仍在各应用内。

## 2. Spring Boot 4.0 兼容性（硬性要求）

- 必须与 **Spring Boot 4.0.x**（当前项目使用 4.0.3）兼容，禁止使用仅支持 Boot 2/3 的 starter。
- **依赖版本与构件**（以 Maven Central 为准，实现时再核对最新小版本）：
  - **MyBatis-Plus**：使用 `mybatis-plus-spring-boot4-starter`，版本 **3.5.15+**（3.5.13 起支持 Spring Boot 4，推荐 3.5.15 及以上）。
  - **多数据源**：使用 `dynamic-datasource-spring-boot4-starter`（Baomidou），版本 **4.5.0+**，JDK 17+。
  - **PostgreSQL**：沿用 Spring Boot BOM 中的 `postgresql` 驱动。
  - **Hikari**：由 Spring Boot / dynamic-datasource 管理，无需单独指定 Hikari 构件。
- **验证方式**：在 pt-login-server（Spring Boot 4.0.3）中引入 pt-dao-starter 并配置数据源，启动成功且能执行 Mapper 查询；若发现 3.5.15 存在已知问题，可评估升级到 3.5.16 或跟踪官方 Issue。

## 3. 技术选型与 Starter 方案（方案 3）

- 采用 **方案 3**：在 dynamic-datasource + MyBatis-Plus + Hikari 基础上，以 **Spring Boot Auto-Configuration** 形式提供 **pt-dao-spring-boot-starter**。
- **Starter 职责**：
  - 聚合并传递依赖：`dynamic-datasource-spring-boot4-starter`、`mybatis-plus-spring-boot4-starter`、`postgresql` 等。
  - 提供自动配置类：统一 **Mapper 扫描路径**（如 `org.jpstale.dao`，扫描所有 `org.jpstale.dao.*.mapper`）、**MyBatis-Plus 全局配置**（如主键类型、逻辑删除字段名、表名下划线转驼峰等）。
  - **多数据源配置前缀**：优先支持 `pt.dao.datasource.dynamic`，结构与 standard dynamic-datasource 一致（primary、strict、datasource.<name> 等）；若底层 dynamic-datasource 仅支持 `spring.datasource.dynamic`，则 Starter 在文档与示例中说明使用 `spring.datasource.dynamic`，或在实现中做一次配置映射（将 `pt.dao.datasource.dynamic` 映射为 DataSource 并注册）。
- **应用侧**：只需引入 `pt-dao-spring-boot-starter`，在 `application.yml` 中填写各数据源连接信息（在选定前缀下），即可获得多数据源与 Mapper 扫描，行为一致、配置入口统一。
- **代价**：需维护 starter 模块及版本矩阵（Spring Boot 4 / MyBatis-Plus / dynamic-datasource），在 8. 实现检查清单 中体现。

| 项         | 选型                                       | 说明                                                                 |
| --------- | ------------------------------------------ | -------------------------------------------------------------------- |
| 连接池     | HikariCP                                   | 由 Spring Boot / dynamic-datasource 管理，可在配置中显式设置 Hikari 参数 |
| ORM/持久层 | MyBatis-Plus（Spring Boot 4 专用 starter） | 使用 mybatis-plus-spring-boot4-starter 3.5.15+，支持 @TableName(schema=…) |
| 多数据源   | dynamic-datasource（Spring Boot 4 专用）   | 使用 dynamic-datasource-spring-boot4-starter 4.5.0+，支持 @DS 切换     |
| 迁移      | Flyway                                     | 沿用现有，locations 可仍为 classpath:db/migration                      |
| 代码生成   | MyBatis-Plus FastAutoGenerator             | 按 schema 分别运行，生成 entity/mapper 到 schema 子包                 |


## 4. 模块与包结构

- **模块划分**：
  - **pt-dao**：核心模块，仅含 entity、mapper 包及代码生成器；不直接依赖 Spring Boot，仅依赖 MyBatis-Plus 注解/API、Lombok 等；可选依赖 mybatis-plus-generator + Freemarker（仅代码生成时需要）。
  - **pt-dao-spring-boot-starter**：Starter 模块，依赖 pt-dao，并引入 `dynamic-datasource-spring-boot4-starter`、`mybatis-plus-spring-boot4-starter`、`postgresql`；提供 `PtDaoAutoConfiguration`（Mapper 扫描、MyBatis-Plus 全局配置）及 `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`。
- **包名按 schema 区分**（在 pt-dao 中）：
  - userdb：`org.jpstale.dao.userdb.entity`、`org.jpstale.dao.userdb.mapper`
  - gamedb：`org.jpstale.dao.gamedb.entity`、`org.jpstale.dao.gamedb.mapper`
  - clandb：`org.jpstale.dao.clandb.entity`、`org.jpstale.dao.clandb.mapper`
  - itemdb：`org.jpstale.dao.itemdb.entity`、`org.jpstale.dao.itemdb.mapper`
  - eventdb：`org.jpstale.dao.eventdb.entity`、`org.jpstale.dao.eventdb.mapper`
  - serverdb：`org.jpstale.dao.serverdb.entity`、`org.jpstale.dao.serverdb.mapper`
  - logdb：`org.jpstale.dao.logdb.entity`、`org.jpstale.dao.logdb.mapper`
  - 生成器入口：`org.jpstale.dao.generator`（仅放生成器主类，不参与运行时）
- **Mapper XML**（若生成）：`src/main/resources/org/jpstale/dao/<schema>/mapper/`（如 userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb），与包路径对应。

## 5. 数据源与配置（含 Starter 配置前缀）

- **配置前缀**：优先使用 `pt.dao.datasource.dynamic`，结构与 standard dynamic-datasource 一致（primary、strict、hikari、datasource.<name> 等）；若实现时发现 dynamic-datasource 仅支持 `spring.datasource.dynamic`，则采用其一并在文档中说明，或在 Starter 内做从 `pt.dao.datasource.dynamic` 到 DataSource 的映射。
- **单库多 schema 示例**：仅配置一个数据源（如 master）指向 `jdbc:postgresql://localhost:5432/pt`，`username`/`password` 使用环境变量 `${DB_USER}`、`${DB_PASSWORD}`；通过实体 `@TableName(schema="userdb"|"gamedb"|"clandb"|"itemdb"|"eventdb"|"serverdb"|"logdb", value="表名")` 区分 schema。
- **多数据源示例**：在选定前缀下配置多个 datasource（如 master、game），使用 `@DS("master")` / `@DS("game")` 切换。
- **Hikari 参数**：在 dynamic 配置下的 `hikari` 节点统一设置（connection-timeout、maximum-pool-size、idle-timeout、connection-test-query: SELECT 1 等）。
- **Flyway**：由各应用自行配置，`enabled: true`，`locations: classpath:db/migration`；若按 schema 拆分脚本可后续扩展。

## 5.1 多数据库兼容（如 MySQL）——仅作改造难度评估

- **当前立场**：项目**以 PostgreSQL 为准**，**保持按 schema 隔离**（userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb），**不计划实际使用 MySQL**。本节内容仅用于**评估若未来要迁到或兼容 MySQL 时的改造难度**，实现时不必优先考虑 MySQL，也无需引入 MySQL 依赖。
- **评估结论**：现有方案无需结构性调整即可在理论上兼容 MySQL；若将来真要支持 MySQL，主要工作为：多数据源（每个 schema 对应一个 MySQL database 并配成一个 DataSource）、驱动与 URL 配置、SQL 避免 PG 方言、代码生成器支持 MySQL 元数据读取。**改造难度可接受，但非当前实现范围。**
- **（可选参考）兼容 MySQL 时的要点**：若日后评估决定支持 MySQL，可参考：MySQL 无 PG 的 schema 概念，等价为 database；要保持「按 schema 隔离」则需多数据源，每个库一个 DataSource，用 `@DS("userdb")` 等切换；Mapper 中避免 PostgreSQL 专用语法以保持可移植性；Starter 不写死单一驱动，按需引入 `mysql-connector-j`。实现时再按需补充。

## 6. 代码生成（写入计划）

### 6.1 目标

- 根据**表名 + schema 名**自动生成：
  - 实体类：带 `@TableName(schema="<schema>", value="表名")`（schema 为 userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb 之一），位于 `org.jpstale.dao.<schema>.entity`
  - Mapper 接口：位于 `org.jpstale.dao.<schema>.mapper`
  - 可选：Mapper XML 到 `resources/org/jpstale/dao/<schema>/mapper/`

### 6.2 技术方式

- 使用 **MyBatis-Plus FastAutoGenerator**，模板引擎 **Freemarker**。
- 依赖：`mybatis-plus-generator`、`freemarker`；可设为 compile（若用 exec:java 运行）或 optional，避免业务运行时强依赖。

### 6.3 运行方式

- **按需执行**，不绑定编译流程。
- 在 pt-dao 中提供可执行类，例如 `org.jpstale.dao.generator.DaoCodeGenerator`：
  - 读取数据源配置（环境变量或与 pt-login-server 一致的配置键），连接库 `pt`。
  - 对 schema 列表（如 `["userdb", "gamedb", "clandb", "itemdb", "eventdb", "serverdb", "logdb"]`）循环执行生成：
    - `dataSourceConfig(builder -> builder.schema(schemaName))`
    - `packageConfig`：`parent("org.jpstale.dao")`，`entity("<schema>.entity")`，`mapper("<schema>.mapper")`（例如 userdb → `userdb.entity` / `userdb.mapper`）。
    - `strategyConfig`：`addInclude("*")` 或显式表名列表；`entityBuilder()` 启用 Lombok、表字段注解、下划线转驼峰等。
    - 每次 `execute()` 生成该 schema 下所有表的 entity 与 mapper。
  - 运行方式：IDE 运行该类的 `main`，或 Maven：`mvn exec:java -Dexec.mainClass="org.jpstale.dao.generator.DaoCodeGenerator"`（可扩展为通过参数/配置文件指定 schema 列表）。

### 6.4 与共用配置的关系

- 生成器仅读取库结构，连接信息与 pt-login-server 共用（同一 `pt` 库、同一环境变量或配置），不引入额外配置源。

## 7. 与应用的集成

- **pt-login-server**：依赖 **pt-dao-spring-boot-starter**（从而传递 pt-dao、dynamic-datasource、mybatis-plus-spring-boot4-starter）；移除 `spring-boot-starter-jdbc`；在 `application.yml` 中在选定前缀（如 `pt.dao.datasource.dynamic` 或 `spring.datasource.dynamic`）下填写数据源连接信息；所有数据库访问通过 pt-dao 的 Mapper（如 `org.jpstale.dao.userdb.mapper.*`）进行。
- **pt-game-server**：后续依赖 **pt-dao-spring-boot-starter**，使用 `org.jpstale.dao.gamedb.*` 访问 gamedb schema；数据源配置方式与 pt-login-server 一致。

## 8. 实现检查清单（概要）

- **Spring Boot 4 兼容**：dependencyManagement 与各模块使用 `mybatis-plus-spring-boot4-starter` 3.5.15+、`dynamic-datasource-spring-boot4-starter` 4.5.0+；在 pt-login-server（Boot 4.0.3）中启动验证。
- **server 父 pom**：增加 pt-dao、pt-dao-spring-boot-starter 模块；dependencyManagement 中统一上述版本及 PostgreSQL。
- **pt-dao 模块**：pom（MyBatis-Plus 注解/API、postgresql、Lombok；可选 mybatis-plus-generator、freemarker）；包结构 `org.jpstale.dao.<schema>.entity/mapper`（schema：userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb）、`generator`。
- **pt-dao-spring-boot-starter 模块**：依赖 pt-dao、dynamic-datasource-spring-boot4-starter、mybatis-plus-spring-boot4-starter；提供 `PtDaoAutoConfiguration`（Mapper 扫描 `org.jpstale.dao`、MyBatis-Plus 全局配置）；`META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` 注册自动配置；文档说明配置前缀（pt.dao.datasource.dynamic 或 spring.datasource.dynamic）及示例。
- **pt-login-server**：改为依赖 pt-dao-spring-boot-starter；移除 spring-boot-starter-jdbc；在 application.yml 中配置数据源（及可选 Flyway）。
- **代码生成**：实现 `DaoCodeGenerator`，按 schema 循环生成 entity/mapper（及可选 XML）；运行方式与 6.3 一致；在 README 或设计文档中说明。
- **（非当前范围）MySQL 兼容**：见 5.1，仅作改造难度评估；当前实现不包含 MySQL 支持。

## 9. 参考

- MyBatis-Plus 代码生成：[https://baomidou.com/en/guides/new-code-generator](https://baomidou.com/en/guides/new-code-generator)
- 本仓库：server/pt-login-server（现有 JDBC + Flyway 配置）、server/pom.xml（模块与依赖管理）。

