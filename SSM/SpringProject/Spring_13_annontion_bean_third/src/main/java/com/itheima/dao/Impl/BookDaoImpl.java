package com.itheima.dao.Impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Override
	public void save() {
		System.out.println("dao ...");
	}
}
