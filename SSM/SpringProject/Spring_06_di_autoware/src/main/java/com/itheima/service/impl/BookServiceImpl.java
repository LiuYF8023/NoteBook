package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Override
	public void save() {
		System.out.println("service ...");
	}
}
