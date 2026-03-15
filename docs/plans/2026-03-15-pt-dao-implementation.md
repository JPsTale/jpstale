# pt-dao 模块实现计划

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** 在 server 下新增 pt-dao 与 pt-dao-spring-boot-starter 两个模块，以 Starter 形式交付多数据源 + MyBatis-Plus + Hikari，供 pt-login-server（及后续 pt-game-server）复用；pt-login-server 移除 spring-boot-starter-jdbc 并改为使用 pt-dao-starter。

**Architecture:** 核心层 pt-dao 仅含 entity/mapper 包与按 schema 的代码生成器，不依赖 Spring Boot；pt-dao-spring-boot-starter 聚合 dynamic-datasource-spring-boot4-starter、mybatis-plus-spring-boot4-starter、postgresql，通过 PtDaoAutoConfiguration 统一 Mapper 扫描与 MyBatis-Plus 全局配置。多数据源使用 `spring.datasource.dynamic`；单库多 schema 通过实体 `@TableName(schema="<schema>", value="表名")` 区分，schema 为 userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb。

**Tech Stack:** Spring Boot 4.0.3、MyBatis-Plus 3.5.15+（mybatis-plus-spring-boot4-starter）、dynamic-datasource 4.5.0+（dynamic-datasource-spring-boot4-starter）、PostgreSQL、Hikari、MyBatis-Plus FastAutoGenerator + Freemarker。

**设计文档:** `docs/plans/2026-03-15-pt-dao-design.md`

---

## Task 1: server 父 POM 增加模块与 dependencyManagement

**Files:**
- Modify: `server/pom.xml`

**Step 1: 添加 pt-dao、pt-dao-spring-boot-starter 模块**

在 `<modules>` 内增加（保持字母序或与现有一致）：
```xml
<module>pt-dao</module>
<module>pt-dao-spring-boot-starter</module>
```

**Step 2: 在 dependencyManagement 中统一版本**

在 `<dependencyManagement><dependencies>` 中增加（放在 flyway 依赖之后）：
```xml
<!-- pt-dao (Spring Boot 4 兼容) -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-spring-boot4-starter</artifactId>
    <version>3.5.15</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>dynamic-datasource-spring-boot4-starter</artifactId>
    <version>4.5.0</version>
</dependency>
<dependency>
    <groupId>org.jpstale</groupId>
    <artifactId>pt-dao</artifactId>
    <version>${project.version}</version>
</dependency>
<dependency>
    <groupId>org.jpstale</groupId>
    <artifactId>pt-dao-spring-boot-starter</artifactId>
    <version>${project.version}</version>
</dependency>
```

**Step 3: 验证**

Run: `cd server && mvn clean compile -N`
Expected: BUILD SUCCESS（仅构建父 POM，不构建子模块）。

**Step 4: Commit**

```bash
git add server/pom.xml
git commit -m "chore(server): add pt-dao modules and dependencyManagement for SB4"
```

---

## Task 2: 创建 pt-dao 模块目录与 POM

**Files:**
- Create: `server/pt-dao/pom.xml`

**Step 1: 创建 pt-dao/pom.xml**

内容如下（parent 为 server，artifactId 为 pt-dao）：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>server</artifactId>
        <groupId>org.jpstale</groupId>
        <version>1.0.0-SNAPSHOT</version>
        <relativePath>..</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>pt-dao</artifactId>
    <description>DAO layer: entity, mapper, code generator by schema (userdb, gamedb, clandb, itemdb, eventdb, serverdb, logdb)</description>

    <dependencies>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-spring-boot4-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!-- 代码生成（可选，仅生成时需要） -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.5.5</version>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```

**Step 2: 验证**

Run: `cd server/pt-dao && mvn clean compile`
Expected: BUILD SUCCESS（可能暂无源码，需下一步建包）。

**Step 3: Commit**

```bash
git add server/pt-dao/pom.xml
git commit -m "feat(pt-dao): add pt-dao module pom"
```

---

## Task 3: pt-dao 包结构与占位类

**Files:**
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/userdb/entity/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/userdb/mapper/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/gamedb/entity/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/gamedb/mapper/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/clandb/entity/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/clandb/mapper/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/itemdb/entity/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/itemdb/mapper/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/eventdb/entity/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/eventdb/mapper/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/serverdb/entity/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/serverdb/mapper/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/logdb/entity/package-info.java`
- Create: `server/pt-dao/src/main/java/org/jpstale/dao/logdb/mapper/package-info.java`

**Step 1: 创建各 schema 的 package-info.java（共 7 个 schema × 2 = 14 个文件）**

每个 schema 的 entity、mapper 各一个 package-info。例如 userdb.entity：
```java
/**
 * userdb schema entities.
 */
package org.jpstale.dao.userdb.entity;
```
同理：userdb.mapper；gamedb、clandb、itemdb、eventdb、serverdb、logdb 的 entity/mapper 的 package 与注释按 schema 名说明（如 `clandb schema entities`）。

**Step 2: 验证**

Run: `cd server/pt-dao && mvn clean compile`
Expected: BUILD SUCCESS.

**Step 3: Commit**

```bash
git add server/pt-dao/src/main/java/org/jpstale/dao/
git commit -m "feat(pt-dao): add schema package structure (userdb, gamedb, clandb, itemdb, eventdb, serverdb, logdb)"
```

---

## Task 4: pt-dao-spring-boot-starter 模块与 POM

**Files:**
- Create: `server/pt-dao-spring-boot-starter/pom.xml`

**Step 1: 创建 starter 的 pom.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>server</artifactId>
        <groupId>org.jpstale</groupId>
        <version>1.0.0-SNAPSHOT</version>
        <relativePath>..</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>pt-dao-spring-boot-starter</artifactId>
    <description>Spring Boot Starter: dynamic-datasource + MyBatis-Plus, Mapper scan for pt-dao</description>

    <dependencies>
        <dependency>
            <groupId>org.jpstale</groupId>
            <artifactId>pt-dao</artifactId>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>dynamic-datasource-spring-boot4-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-spring-boot4-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>
    </dependencies>
</project>
```

**Step 2: 验证**

Run: `cd server/pt-dao-spring-boot-starter && mvn clean compile`
Expected: BUILD SUCCESS.

**Step 3: Commit**

```bash
git add server/pt-dao-spring-boot-starter/pom.xml
git commit -m "feat(pt-dao): add pt-dao-spring-boot-starter module"
```

---

## Task 5: PtDaoAutoConfiguration 与 Mapper 扫描

**Files:**
- Create: `server/pt-dao-spring-boot-starter/src/main/java/org/jpstale/dao/autoconfigure/PtDaoAutoConfiguration.java`

**Step 1: 创建自动配置类**

```java
package org.jpstale.dao.autoconfigure;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.jpstale.dao")
public class PtDaoAutoConfiguration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
        return interceptor;
    }
}
```

说明：MapperScan 扫描 `org.jpstale.dao`，会包含所有 schema 下的 mapper（userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb）；MyBatis-Plus 全局配置（主键类型、逻辑删除等）若需可在此或通过 `application.yml` 的 `mybatis-plus.global-config` 扩展。

**Step 2: 注册自动配置**

- Create: `server/pt-dao-spring-boot-starter/src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`

文件内容（一行）：
```
org.jpstale.dao.autoconfigure.PtDaoAutoConfiguration
```

**Step 3: 验证**

Run: `cd server/pt-dao-spring-boot-starter && mvn clean compile`
Expected: BUILD SUCCESS.

**Step 4: Commit**

```bash
git add server/pt-dao-spring-boot-starter/src/main/java/ server/pt-dao-spring-boot-starter/src/main/resources/
git commit -m "feat(pt-dao): add PtDaoAutoConfiguration and MapperScan"
```

---

## Task 6: pt-login-server 改为使用 pt-dao-starter 并配置数据源

**Files:**
- Modify: `server/pt-login-server/pom.xml`
- Modify: `server/pt-login-server/src/main/resources/application.yml`

**Step 1: 替换依赖**

在 pt-login-server/pom.xml 中：
- 删除 `spring-boot-starter-jdbc` 依赖块。
- 删除单独声明的 `postgresql` 依赖（由 starter 传递）。
- 增加：
```xml
<dependency>
    <groupId>org.jpstale</groupId>
    <artifactId>pt-dao-spring-boot-starter</artifactId>
</dependency>
```
保留 flyway-core、flyway-database-postgresql（应用仍负责迁移）。

**Step 2: 使用 dynamic 数据源配置**

将 application.yml 中 `spring.datasource` 改为 dynamic-datasource 标准结构（设计文档 5、5.1：采用 `spring.datasource.dynamic`）：
```yaml
spring:
  main:
    web-application-type: none
  datasource:
    dynamic:
      primary: master
      strict: false
      datasource:
        master:
          url: jdbc:postgresql://localhost:5432/pt
          username: ${DB_USER:postgres}
          password: ${DB_PASSWORD:123456}
          driver-class-name: org.postgresql.Driver
  flyway:
    enabled: true
    locations: classpath:db/migration
```
保留 pt.login.port 等其余配置不变。

**Step 3: 验证**

Run: `cd server/pt-login-server && mvn clean compile`
Expected: BUILD SUCCESS.

**Step 4: 启动验证（可选，需本地 PostgreSQL pt 库）**

Run: `cd server/pt-login-server && mvn spring-boot:run`
Expected: 应用启动成功，无 DataSource 相关错误。若暂无 Flyway 脚本或库不存在，可仅验证到 “Started LoginServerApplication” 或根据环境跳过。

**Step 5: Commit**

```bash
git add server/pt-login-server/pom.xml server/pt-login-server/src/main/resources/application.yml
git commit -m "feat(pt-login-server): switch to pt-dao-starter, use spring.datasource.dynamic"
```

---

## Task 7: 代码生成器 DaoCodeGenerator（test 下 + 自定义实体模板）

**约束：**
- 生成器类放在 **pt-dao 的 src/test/java**，不参与主代码打包；生成结果输出到 **server/pt-dao 模块** 的 `src/main/java` / `src/main/resources`（即本模块目录，不写到 JPsTale 根目录）。
- 生成的 Entity 必须带 **@TableName(schema = "当前 schema", value = "表名")**（默认 MyBatis-Plus 生成不会带 schema，需自定义模板或注入变量）。
- 生成的实体使用 Lombok **@Data**，不要仅用 @Getter/@Setter。
- **允许生成 Service 与 ServiceImpl**；**禁止生成 Controller**（MyBatis-Plus 默认会生成 Controller，需在策略或模板配置中显式关闭）。

**Files:**
- Create: `server/pt-dao/src/test/java/org/jpstale/dao/generator/DaoCodeGenerator.java`
- Create: `server/pt-dao/src/test/resources/templates/entity.java.ftl`（自定义实体模板：@TableName(schema + value)、@Data）

**Step 1: 确定 pt-dao 模块输出根路径**

生成代码必须落在 **server/pt-dao** 下。建议在生成器内通过「当前类所在 classpath 位置」解析出 pt-dao 模块根目录（例如从 `target/test-classes` 向上到 pt-dao），再得到：
- 实体/Mapper Java：`<pt-dao根>/src/main/java`
- Mapper XML：`<pt-dao根>/src/main/resources/org/jpstale/dao/<schema>/mapper`

若统一约定「仅在 server/pt-dao 目录下执行生成命令」，也可用 `System.getProperty("user.dir")` 作为 pt-dao 根（此时不要从仓库根目录执行，避免生成到错误目录）。

**Step 2: 自定义实体模板 entity.java.ftl**

在 `server/pt-dao/src/test/resources/templates/entity.java.ftl` 中：
- 在类上使用 **@TableName(schema = "${schema!''}", value = "${table.name}")**，确保生成的每个实体都声明访问的 schema（变量 `schema` 由 Step 3 注入）。
- 使用 Lombok **@Data**（可保留 `@NoArgsConstructor`/`@AllArgsConstructor` 等按需），不要仅生成 @Getter/@Setter。

模板可参考 MyBatis-Plus 自带 entity 模板结构，重点修改：表注解为 `@TableName(schema = "${schema!''}", value = "${table.name}")`，类注解为 `@Data`。

**Step 3: 实现 DaoCodeGenerator（test 下）**

- 类路径：`server/pt-dao/src/test/java/org/jpstale/dao/generator/DaoCodeGenerator.java`。
- 对 schema 列表（userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb）循环：
  - `dataSourceConfig(b -> b.schema(schemaName))`，连接库 `pt`，账号密码从环境变量 DB_USER/DB_PASSWORD 或默认读取。
  - `globalConfig`：`outputDir` = pt-dao 模块下的 `src/main/java`（见 Step 1）。
  - `packageConfig`：parent `org.jpstale.dao`，entity `<schema>.entity`，mapper `<schema>.mapper`，**service `<schema>.service`**，**serviceImpl `<schema>.service.impl`**（允许生成 Service）；`pathInfo(OutputFile.xml, ...)` 指向 pt-dao 下 `src/main/resources/org/jpstale/dao/<schema>/mapper`。
  - **InjectionConfig**：`customMap` 注入 **schema** 为当前循环的 schema 名，供实体模板中的 `@TableName(schema = "${schema}", ...)` 使用。
  - **TemplateConfig / StrategyConfig**：实体模板指定为上述自定义模板（如 `/templates/entity.java.ftl`，确保从 test resources 加载）。
  - **禁止 Controller**：通过 `strategyConfig.controllerBuilder().disable()` 或 `templateConfig.disable(TemplateType.CONTROLLER)` 关闭 Controller 生成（以当前 mybatis-plus-generator API 为准）。
  - `strategyConfig`：`entityBuilder()` 启用 Lombok（模板里用 @Data 即可）、表字段注解、下划线转驼峰等；`addInclude("*")` 或显式表名列表。
- 使用 Freemarker 引擎，每次循环 `execute()` 生成该 schema 的 entity、mapper、service、serviceImpl（及可选 XML），**不生成 controller**。

参考实现要点（API 以当前 mybatis-plus-generator 为准）：
```java
// 解析 pt-dao 模块根目录（示例：从 class 所在 target/test-classes 反推）
private static String resolvePtDaoModuleRoot() {
    try {
        String path = DaoCodeGenerator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        // ... 解析得到 server/pt-dao 目录的绝对路径，或 fallback 到 user.dir
        return path; // 返回 pt-dao 模块根
    } catch (Exception e) {
        return System.getProperty("user.dir");
    }
}

// 循环内
String moduleRoot = resolvePtDaoModuleRoot();
String outJava = moduleRoot + "/src/main/java";
String outXml = moduleRoot + "/src/main/resources";

.injectionConfig(ic -> ic.customMap(Collections.singletonMap("schema", schema)))
.packageConfig(b -> b
    .parent("org.jpstale.dao")
    .entity(schema + ".entity")
    .mapper(schema + ".mapper")
    .service(schema + ".service")
    .serviceImpl(schema + ".service.impl")
    .pathInfo(...)  // xml 等
)
.strategyConfig(sc -> sc
    .addInclude("*")
    .entityBuilder()
    .naming(NamingStrategy.underline_to_camel)
    .columnNaming(NamingStrategy.underline_to_camel)
    .enableLombok()
    .setTemplatePath("/templates/entity.java.ftl")  // 自定义实体模板
    // 禁止生成 Controller
    .controllerBuilder().disable()
)
```
注意：禁止 Controller 的 API 可能是 `strategyConfig.controllerBuilder().disable()` 或全局 `templateConfig.disable(TemplateType.CONTROLLER)`，以 mybatis-plus-generator 文档为准。

**Step 4: 运行方式（test 类）**

生成器在 **src/test/java**，需先编译 test 再以 test classpath 执行：
```bash
cd server/pt-dao
mvn test-compile exec:java -Dexec.mainClass="org.jpstale.dao.generator.DaoCodeGenerator" -Dexec.classpathScope=test
```
若 exec 未绑定 classpathScope，可在 pt-dao 的 pom.xml 中为 exec-maven-plugin 配置 `classpathScope=test`（或每次命令行传 `-Dexec.classpathScope=test`）。

**Step 5: 验证**

- 运行上述命令；若本地 pt 库存在且某 schema 下有表，检查生成在 **server/pt-dao/src/main/java** 下的实体是否包含 `@TableName(schema = "xxx", value = "表名")` 和 `@Data`。
- 若无表则可能无生成文件，仅需保证 `mvn test-compile` 通过即可。

**Step 6: Commit**

```bash
git add server/pt-dao/src/test/java/org/jpstale/dao/generator/ server/pt-dao/src/test/resources/templates/
git commit -m "feat(pt-dao): add DaoCodeGenerator in test with schema TableName and Lombok Data"
```

---

## Task 8: 文档与 README 说明

**Files:**
- Create or Modify: `server/pt-dao/README.md` 或设计文档末尾/链接

**Step 1: 在 pt-dao 或 starter 下添加简短说明**

内容包含：
- 配置前缀：使用 `spring.datasource.dynamic`（与 standard dynamic-datasource 一致）；单库多 schema 时仅配一个数据源，实体用 `@TableName(schema="<schema>", value="表名")`，schema 为 userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb。
- 代码生成：DaoCodeGenerator 位于 **pt-dao 的 src/test/java**，输出到 **server/pt-dao** 的 src/main/java 与 src/main/resources。运行：`cd server/pt-dao && mvn test-compile exec:java -Dexec.mainClass="org.jpstale.dao.generator.DaoCodeGenerator" -Dexec.classpathScope=test`；需 pt 库可连、环境变量 DB_USER/DB_PASSWORD 或默认；schema 列表在代码中可配置（userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb）。生成的实体带 `@TableName(schema="...", value="表名")` 和 Lombok `@Data`。

**Step 2: Commit**

```bash
git add server/pt-dao/README.md
git commit -m "docs(pt-dao): add config and code generator usage"
```

---

## 实现检查清单（与设计文档 8 对应）

- [ ] Spring Boot 4：dependencyManagement 与模块使用 mybatis-plus-spring-boot4-starter 3.5.15+、dynamic-datasource-spring-boot4-starter 4.5.0+；pt-login-server 启动无错。
- [ ] server 父 pom：已增加 pt-dao、pt-dao-spring-boot-starter 模块及上述依赖版本。
- [ ] pt-dao：包结构 org.jpstale.dao.<schema>.entity/mapper（schema：userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb）、generator；可选 generator 依赖。
- [ ] pt-dao-spring-boot-starter：PtDaoAutoConfiguration、MapperScan、AutoConfiguration.imports；配置说明使用 spring.datasource.dynamic。
- [ ] pt-login-server：已依赖 pt-dao-spring-boot-starter，已移除 spring-boot-starter-jdbc，application.yml 使用 spring.datasource.dynamic。
- [ ] DaoCodeGenerator：位于 pt-dao 的 src/test/java；按 schema 循环生成；输出到 server/pt-dao 模块；实体使用 @TableName(schema, value) 与 @Data；**允许生成 Service/ServiceImpl，禁止生成 Controller**；README 或设计文档中说明运行方式（test-compile + exec classpathScope=test）。
