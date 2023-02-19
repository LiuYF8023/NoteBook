package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Mybatisplus03DmlApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	void testSave() {
		User user = new User();
		user.setId(666L);
		user.setName("黑马");
		user.setPassword("itheima");
		user.setAge(12);
		user.setTel("4006");
		int res = userDao.insert(user);
		System.out.println(res);
	}

	@Test
	void testDelete() {
		userDao.deleteById(1L);
	}

	@Test
	void testUpdate() {
		User user = new User();
		user.setName("1L");
		user.setPassword("itheima");
		user.setAge(12);
		user.setTel("4006");
		userDao.updateById(user);
	}

	@Test
	void testDeleteMore() {
		List<Long> list = new ArrayList<>();
		list.add(2L);
		list.add(3L);
		list.add(666L);
		int delRes = userDao.deleteBatchIds(list);
		System.out.println(delRes);
	}

}
