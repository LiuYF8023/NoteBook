package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		// 第一种方式 从类路径加载
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 第二种方式 从绝对路径加载
//		ApplicationContext ctx2 = new FileSystemXmlApplicationContext("C:\\Users\\lyf\\NoteBook\\SSM\\Spring_09_container\\src\\main\\resources\\applicationContext.xml");

		// 1、
		BookDao bookDao = (BookDao) ctx.getBean("bookDao");

		// 2、
		BookDao bookDao2 = ctx.getBean("bookDao", BookDao.class);

		// 3、
		BookDao bookDao3 = ctx.getBean(BookDao.class);
		bookDao.save();
	}
}
