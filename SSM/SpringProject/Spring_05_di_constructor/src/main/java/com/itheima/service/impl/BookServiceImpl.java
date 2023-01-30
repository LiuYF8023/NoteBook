package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;
	private UserDao userDao;


	public BookServiceImpl(BookDao bookDao, UserDao userDao) {
		this.bookDao = bookDao;
		this.userDao = userDao;
	}

	@Override
	public void save() {
		bookDao.save();
		userDao.save();
	}

}
