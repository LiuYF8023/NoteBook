package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//@ComponentScan({"com.itheima.dao","com.itheima.service"})
@ComponentScan(
	value = "com.itheima",
	excludeFilters = @ComponentScan.Filter(
			type = FilterType.ANNOTATION,
			classes = Controller.class
	)
)
public class SpringConfig {

}