package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
		System.out.println(dataSource);
	}
}
