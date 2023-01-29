package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
}
