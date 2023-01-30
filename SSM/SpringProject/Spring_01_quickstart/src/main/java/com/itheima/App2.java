package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {
		// 3、获取IoC容器
		// ApplicationContext是一个接口，不能实例化，应该用他的实现类
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 4、获取bean
		BookDao bookDao1 = (BookDao)ctx.getBean("bookDao");
		BookDao bookDao2 = (BookDao)ctx.getBean("bookDao");
		BookDao bookDao3 = (BookDao)ctx.getBean("bookDao");
//		BookService bookService = (BookService)ctx.getBean("service3"); // 别名
		System.out.println(bookDao1);
		System.out.println(bookDao2);
		System.out.println(bookDao3);
	}
}
