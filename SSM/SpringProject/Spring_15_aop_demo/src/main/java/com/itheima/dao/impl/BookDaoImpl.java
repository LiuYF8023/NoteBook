package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	@Override
	public void save() {
		System.out.println(System.currentTimeMillis());
		System.out.println("save ...");
	}

	@Override
	public void update() {
		System.out.println("update ...");
	}
}
