package com.itheima.dao.Impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao2")
public class BookDaoImpl2 implements BookDao {
	@Override
	public void save() {
		System.out.println("dao ...2");
	}
}
