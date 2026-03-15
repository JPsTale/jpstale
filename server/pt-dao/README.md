# pt-dao

DAO 层：按 PostgreSQL schema（userdb、gamedb、clandb、itemdb、eventdb、serverdb、logdb）组织 entity、mapper，供 pt-login-server、pt-game-server 等通过 **pt-dao-spring-boot-starter** 复用。

## 配置

- **数据源**：使用 `spring.datasource.dynamic`（与 [dynamic-datasource](https://github.com/baomidou/dynamic-datasource) 一致）。单库多 schema 时只配一个数据源，实体通过 `@TableName(schema="<schema>", value="表名")` 区分，schema 为上述 7 个之一。
- **Starter**：应用引入 `pt-dao-spring-boot-starter` 并在 `application.yml` 中配置 `spring.datasource.dynamic` 即可获得 Mapper 扫描与多数据源能力。

## 代码生成

- **位置**：生成器在 **pt-dao 的 src/test/java**（`org.jpstale.dao.generator.DaoCodeGenerator`），生成结果输出到 **本模块**的 `src/main/java` 与 `src/main/resources`。**不会在 `mvn test-compile` 或任何构建阶段自动执行**，仅在你手动触发时运行。
- **手动运行**（需本地 pt 库可连，环境变量 `DB_USER` / `DB_PASSWORD` 或默认 postgres/123456）：
  ```bash
  cd server/pt-dao
  mvn test-compile exec:java -Dexec.mainClass="org.jpstale.dao.generator.DaoCodeGenerator" -Dexec.classpathScope=test
  ```
  或：`mvn test-compile exec:java`（pom 中已绑定 mainClass 与 classpathScope=test）。
- **生成内容**：各 schema 下的 entity（带 `@TableName(schema="...", value="表名")` 与 Lombok `@Data`）、mapper（及可选 XML）。不生成 service/controller，业务 Service 由各应用自行实现。schema 列表在 `DaoCodeGenerator` 中可配置。
