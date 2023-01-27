package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
	public BookDaoImpl(int i){
		System.out.println("dao is running ...");
	}
	public void save(){
		System.out.println("book dao save ... ");
	}
}
