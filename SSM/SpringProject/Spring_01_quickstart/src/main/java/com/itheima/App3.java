package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {
	public static void main(String[] args) {
		// 获取Ioc容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 获取bean对象
		BookDao bookDao = (BookDao) ctx.getBean("bookDao");
		bookDao.save();
	}
}
