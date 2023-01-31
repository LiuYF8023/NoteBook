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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Test
	public void testSelectById() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
		Brand brand = brandMapper.selectById(1);
		System.out.println(brand);

		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testSelectByCondition() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
		// 3.1 第一种传参方法
//		List<Brand> brands = brandMapper.selectByCondition(1, "华为技术有限公司", "华为");
		// 3.2 Brand brand
//		Brand brandTemp = new Brand();
//		brandTemp.setStatus(1);
//		brandTemp.setCompanyName("华为技术有限公司");
//		brandTemp.setBrandName("华为");
//		List<Brand> brands = brandMapper.selectByCondition(brandTemp);

		// 3.3 Map map
		Map<String, String> map = new HashMap<>();
		map.put("status", null);
		map.put("companyName", null);
		map.put("brandName", "华为");
		List<Brand> brands = brandMapper.selectByCondition(map);
		System.out.println(brands);

		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testSelectByConditionSingle() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		Brand brandTemp = new Brand();
//		brandTemp.setStatus(1);
//		brandTemp.setCompanyName("华为技术有限公司");
		brandTemp.setBrandName("华为");
		List<Brand> brands = brandMapper.selectByConditionSingle(brandTemp);
		System.out.println(brandTemp);

		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testAdd() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		Brand brandTemp = new Brand();
//		brandTemp.setId(4);
		brandTemp.setBrandName("byd");
		brandTemp.setCompanyName("比亚迪");
		brandTemp.setOrdered(100);
		brandTemp.setDescription("byd!!!!!!");
		brandTemp.setStatus(1);

		brandMapper.add(brandTemp);

		sqlSession.commit();
		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testAdd2() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		Brand brandTemp = new Brand();
//		brandTemp.setId(4);
		brandTemp.setBrandName("123");
		brandTemp.setCompanyName("比亚迪");
		brandTemp.setOrdered(100);
		brandTemp.setDescription("byd!!!!!!");
		brandTemp.setStatus(1);

		brandMapper.add2(brandTemp);
		Integer idReturn = brandTemp.getId();
		System.out.println(idReturn);

		sqlSession.commit();
		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testUpdate() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		Brand brandTemp = new Brand();
		brandTemp.setId(11);
		brandTemp.setBrandName("123");
		brandTemp.setCompanyName("asjfha");
		brandTemp.setOrdered(100);
		brandTemp.setDescription("afdgdfsg!!!!!!");
		brandTemp.setStatus(1);

		int updateReturn = brandMapper.update(brandTemp);
		System.out.println(updateReturn);

		sqlSession.commit();
		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testUpdate2() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		Brand brandTemp = new Brand();
		brandTemp.setId(11);
		brandTemp.setBrandName("qwegewgq");
		brandTemp.setCompanyName("qwerqwerqwerqwerqw");

		int updateReturn = brandMapper.update2(brandTemp);
		System.out.println(updateReturn);

		sqlSession.commit();
		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testDeleteById() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		int updateReturn = brandMapper.deleteById(12);
		System.out.println(updateReturn);

		sqlSession.commit();
		// 4、释放资源
		sqlSession.close();
	}

	@Test
	public void testDeleteByIds() throws Exception {
		// 1、加载MyBatis的核心配置文件，获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取SqlSession对象，用于执行sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3、获取Mapper接口的代理对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		int updateReturn = brandMapper.deleteByIds(new int[]{8,9,10,11});
		System.out.println(updateReturn);

		sqlSession.commit();
		// 4、释放资源
		sqlSession.close();
	}
}
