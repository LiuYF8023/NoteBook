package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisDemo2 {
	public static void main(String[] args) throws Exception {

		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.selectAll();
		for (User user : users) {
			System.out.println(user);
		}

		// 4、释放资源
		sqlSession.close();
	}
}
