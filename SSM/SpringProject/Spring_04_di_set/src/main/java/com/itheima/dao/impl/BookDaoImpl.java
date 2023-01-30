package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {

	private int connectionNum;
	private String connectionName;

	public void setConnectionNum(int connectionNum) {
		this.connectionNum = connectionNum;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	@Override
	public void save() {
		System.out.println("bookdao ...." + connectionName + ", " + connectionNum + ".");
	}
}
