package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {

	@Override
	public void save() {
		System.out.println("bookdao ....");
	}

	public void init(){
		System.out.println("init ...");
	}

	public void destroy(){
		System.out.println("destory ...");
	}
}
