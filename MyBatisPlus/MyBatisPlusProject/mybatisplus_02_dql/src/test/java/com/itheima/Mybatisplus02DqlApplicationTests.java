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
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

	@Autowired
	private UserDao userDao;
	@Test
	void testGetAll() {
		// 设置查询条件
//		QueryWrapper qw = new QueryWrapper();
//		qw.lt("age",5);
//		List<User> users = userDao.selectList(qw);
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
//		uq.setAge(10);
		uq.setAge2(30);

		// null 判定
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//		lqw.lt(User::getAge,uq.getAge2()); // 小于30
//		lqw.gt(User::getAge,uq.getAge()); // 大于10
//		List<User> users = userDao.selectList(lqw);
//		for (User user : users) {
//			System.out.println(user);
//		}
//
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//		lqw.lt(uq.getAge2() != null,User::getAge,uq.getAge2()); // 小于30
//		lqw.gt(uq.getAge() != null,User::getAge,uq.getAge()); // 大于10
//		List<User> users = userDao.selectList(lqw);
//		for (User user : users) {
//			System.out.println(user);
//		}

		// 查询投影 lambda方式
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//		lqw.select(User::getId,User::getName);
//		List<User> users = userDao.selectList(lqw);
//		for (User user : users) {
//			System.out.println(user);
//		}

//		QueryWrapper<User> qw = new QueryWrapper<User>();
//		qw.select("id","name");
//		List<User> users2 = userDao.selectList(qw);
//		for (User user : users2) {
//			System.out.println(user);
//		}

//		QueryWrapper<User> qw = new QueryWrapper<User>();
//		qw.select("count(*) as count");
//		List<Map<String, Object>> maps = userDao.selectMaps(qw);
//		System.out.println(maps);

		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
		// = 条件
		lqw.eq(User::getName,"Tom");
		User user = userDao.selectOne(lqw);

		// 范围查询 lt le gt ge between
		lqw.between(User::getAge,10,30);

		// 模糊匹配
		lqw.like(User::getName,"T"); //
		lqw.likeLeft(User::getName,"om"); // %om
		lqw.likeRight(User::getName,"To"); // To%
		System.out.println(user);

	}

}
