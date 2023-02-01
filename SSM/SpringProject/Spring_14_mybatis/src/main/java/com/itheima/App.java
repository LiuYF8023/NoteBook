package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {
		// 1、创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2、加载mybatis-config.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml.bak");
		// 3、创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		// 4、获取SQLSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		// 5、执行相关操作
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		System.out.println("查找操作");
		List<Account> accounts = accountDao.selectAll();
		System.out.println(accounts);

		System.out.println("通过id查找");
		Account account = accountDao.selectById(1);
		System.out.println(account);

		System.out.println("删除操作");
		int delectByIdReturn = accountDao.deleteById(3);
		System.out.println(delectByIdReturn);

		System.out.println("更新操作");
		int updateReturn = accountDao.updateById("huawei",2);

		System.out.println("插入操作");
		Account accountTemp = new Account();
		accountTemp.setBrandName("asadas");
		accountTemp.setCompanyName("asadas");
		accountTemp.setDescription("asadas");
		accountTemp.setOrdered(1234);
		accountTemp.setStatus(1);
		int insertReturn = accountDao.insert(accountTemp);

		sqlSession.commit();

		sqlSession.close();
	}
}
