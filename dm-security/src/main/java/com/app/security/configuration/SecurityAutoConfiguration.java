package com.app.security.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.app.security")
@EntityScan(basePackages = "com.app.security")
public class SecurityAutoConfiguration {

}
