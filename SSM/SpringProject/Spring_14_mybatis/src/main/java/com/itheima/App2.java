package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 */
public class App2 {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountService accountService = ctx.getBean(AccountService.class);
		System.out.println(accountService.selectAll());
	}
}
