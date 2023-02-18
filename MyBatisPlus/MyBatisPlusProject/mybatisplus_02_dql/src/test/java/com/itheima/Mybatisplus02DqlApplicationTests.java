package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

	@Autowired
	private UserDao userDao;
	@Test
	void testGetAll() {
		// 设置查询条件
//		QueryWrapper qw = new QueryWrapper();
//		qw.lt("age",2);
//		List<User> users = userDao.selectList(null);
//		System.out.println(users);

//		QueryWrapper<User> qw = new QueryWrapper();
//		qw.lambda().lt(User::getAge,2);
//		List<User> users = userDao.selectList(null);
//		System.out.println(users);

//		LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
//		qw.lt(User::getAge,1).or().gt(User::getAge,10); //  小于1 或者 大于10
//		List<User> users = userDao.selectList(null);
//		System.out.println(users);

		// 过滤空的查询条件
		UserQuery uq = new UserQuery();
		uq.setAge(10);
		uq.setAge2(30);

		// null 判定
		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
		lqw.lt(User::getAge,uq.getAge2()); // 小于30
		lqw.gt(User::getAge,uq.getAge()); // 大于10
		List<User> users = userDao.selectList(null);
		System.out.println(users);
	}

}
