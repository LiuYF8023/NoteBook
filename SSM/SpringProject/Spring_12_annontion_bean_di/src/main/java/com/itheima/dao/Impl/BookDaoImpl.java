package com.itheima.dao.Impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("bookDao1")
public class BookDaoImpl implements BookDao {
	@Value("${name}")
	private String name;
	@Override
	public void save() {
		System.out.println("dao ..." + name);
	}
}
