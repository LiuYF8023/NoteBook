package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.itheima")
@Import({MyBatisConfig.class, JdbcConfig.class})
public class SpringConfig {

}
