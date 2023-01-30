package com.itheiam;

import com.itheiam.dao.BookDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDao bookDao = (BookDao) ctx.getBean("bookDao");
		bookDao.save();
	}
}
