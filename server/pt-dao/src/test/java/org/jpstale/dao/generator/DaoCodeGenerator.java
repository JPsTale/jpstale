package org.jpstale.dao.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * 按 schema 循环生成 entity、mapper（及可选 XML）。不生成 service/controller，业务 Service 由各应用自行实现。
 * 输出到 pt-dao 模块的 src/main/java 与 src/main/resources。
 * 实体带 @TableName(schema="...", value="表名") 和 Lombok @Data。
 * <p>
 * 运行：cd server/pt-dao && mvn test-compile exec:java
 */
public final class DaoCodeGenerator {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/pt";
    private static final String USER = System.getenv().getOrDefault("DB_USER", "postgres");
    private static final String PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "123456");
    private static final List<String> SCHEMAS = List.of(
            "userdb", "gamedb", "clandb", "chatdb", "itemdb", "eventdb", "serverdb", "skilldb", "logdb");

    private static String resolvePtDaoModuleRoot() {
        try {
            URI uri = DaoCodeGenerator.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI();
            Path path = Paths.get(uri).normalize();
            // target/test-classes or target/classes -> module root
            Path root = path;
            while (root != null && !"pt-dao".equals(root.getFileName() != null ? root.getFileName().toString() : null)) {
                root = root.getParent();
            }
            if (root != null) {
                return root.toString();
            }
        } catch (Exception ignored) {
        }
        return System.getProperty("user.dir");
    }

    public static void main(String[] args) {
        String moduleRoot = resolvePtDaoModuleRoot();
        String outJava = moduleRoot + "/src/main/java";
        String outResources = moduleRoot + "/src/main/resources";

        for (String schema : SCHEMAS) {
            FastAutoGenerator.create(JDBC_URL, USER, PASSWORD)
                    .globalConfig(b -> b
                            .author("pt-dao")
                            .outputDir(outJava)
                            .disableOpenDir())
                    .dataSourceConfig(b -> b.schema(schema))
                    .packageConfig(b -> b
                            .parent("org.jpstale.dao")
                            .entity(schema + ".entity")
                            .mapper(schema + ".mapper")
                            .pathInfo(Collections.singletonMap(
                                    OutputFile.xml,
                                    outResources + "/org/jpstale/dao/" + schema + "/mapper")))
                    .injectionConfig(ic -> ic
                            .customMap(Collections.singletonMap("schema", schema)))
                    .templateConfig(b -> b
                            .disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICE_IMPL)
                            .entity("templates/entity.java"))
                    .strategyConfig(sc -> sc
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .enableLombok()
                            .enableTableFieldAnnotation())
                    .templateEngine(new FreemarkerTemplateEngine())
                    .execute();
        }
    }
}
