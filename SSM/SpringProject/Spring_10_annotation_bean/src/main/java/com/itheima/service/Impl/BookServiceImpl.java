package com.itheima.service.Impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BookServiceImpl implements BookService {
	private BookDao bookDao;
	@Override
	public void save() {
		System.out.println("service ...");
		bookDao.save();
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
