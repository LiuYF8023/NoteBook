package com.itheima;

import com.itheima.dao.OrderDao;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class AppForInstanceOrder {
	public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 记得要在maven 中配置SpringFramework

		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		orderDao.save();
	}
}
