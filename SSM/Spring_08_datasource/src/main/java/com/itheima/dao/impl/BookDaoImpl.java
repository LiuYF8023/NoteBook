package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

import java.util.*;

public class BookDaoImpl implements BookDao {
	private String name;
	@Override
	public void save() {
		System.out.println(name);
	}

	public void setName(String name) {
		this.name = name;
	}
}
