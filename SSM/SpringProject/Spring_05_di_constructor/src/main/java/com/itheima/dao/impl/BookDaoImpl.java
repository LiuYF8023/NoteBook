package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {

	private int connectionNum;
	private String connectionName;

	public BookDaoImpl(int connectionNum, String connectionName) {
		this.connectionNum = connectionNum;
		this.connectionName = connectionName;
	}

	@Override
	public void save() {
		System.out.println("bookdao ....");
	}
}
