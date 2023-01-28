package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.registerShutdownHook();
		BookDao bookDao = (BookDao) ctx.getBean("bookDao");
		bookDao.save();

//		ctx.close();
	}
}
