package com.itheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

	@Autowired
	private UserDao userDao;
	@Test
	void testGetAll() {
		List<User> users = userDao.selectList(null);
		System.out.println(users);
	}

	@Test
	void testInsert() {
		User user = new User();
		user.setId(3L);
		user.setAge(13);
		user.setName("xiaoming");
		user.setPassword("ajshfgaj");
		int res = userDao.insert(user);
		System.out.println(res);
	}

	@Test
	void testDeleteById() {
		int res = userDao.deleteById(1626563824146468866L);
		System.out.println(res);
	}

	@Test
	void testUpdateById() {
		User user = new User();
		user.setId(2L);
		user.setAge(13);
		user.setName("xiaoming2");
		user.setPassword("ajshfgaj");
		int res = userDao.updateById(user);
		System.out.println(res);
	}

	@Test
	void testGetById() {
		User user = userDao.selectById(2L);
		System.out.println(user);
	}

	@Test
	void testGetByPage() {
		// 开启拦截器,开启分页
		IPage page = new Page(1, 1);
		userDao.selectPage(page,null);
		System.out.println("当前页码值" + page.getCurrent());
		System.out.println("每页多少" + page.getSize());
		System.out.println("一共多少页" + page.getPages());
		System.out.println("一共多少条数据" + page.getTotal());
		System.out.println("数据" + page.getRecords());
	}

}
