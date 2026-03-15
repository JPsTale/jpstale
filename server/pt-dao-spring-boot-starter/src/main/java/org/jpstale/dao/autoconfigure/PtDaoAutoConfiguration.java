package org.jpstale.dao.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * pt-dao 自动配置：统一扫描 org.jpstale.dao 下所有 schema 的 Mapper。
 * 分页插件可由应用自行配置 MybatisPlusInterceptor + PaginationInnerInterceptor，或使用 MyBatis-Plus 默认行为。
 */
@Configuration
@MapperScan("org.jpstale.dao")
public class PtDaoAutoConfiguration {
}
