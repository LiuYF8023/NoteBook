package com.itheima.dao.Impl;

import com.itheima.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
//@Scope("singleton") 单例
//@Scope("prototype")
public class BookDaoImpl implements BookDao {
	@Override
	public void save() {
		System.out.println("dao ...");
	}
	@PostConstruct
	public void init(){
		System.out.println("init ...");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("destory ...");
	}
}
