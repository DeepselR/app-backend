package com.app.postgre.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.app.postgre")
@EnableJpaRepositories(basePackages = "com.app.postgre")
@EntityScan(basePackages = "com.app.postgre")
@EnableTransactionManagement
public class PostgreSqlAutoConfiguration {


}
