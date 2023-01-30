package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
	@Test
	public void testSellectAll() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
		List<Brand> brands = brandMapper.selectAll();
		for (Brand brand : brands) {
			System.out.println(brand);
		}

		// 4、释放资源
		sqlSession.close();
	}

}
