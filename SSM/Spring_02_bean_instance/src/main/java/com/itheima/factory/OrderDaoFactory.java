package com.itheima.factory;

import com.itheima.dao.OrderDao;
import com.itheima.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
	public static OrderDao getOrderDao() {
		System.out.println("set up");
	    return new OrderDaoImpl();
	}
}
