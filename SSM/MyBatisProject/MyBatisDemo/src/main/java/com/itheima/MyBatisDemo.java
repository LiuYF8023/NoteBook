package com.itheima;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
	public static void main(String[] args) throws Exception {

		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、执行sql
		List<User> users = sqlSession.selectList("test.selectAll");

		for (User user : users) {
			System.out.println(user);
		}

		// 4、释放资源
		sqlSession.close();
	}
}
