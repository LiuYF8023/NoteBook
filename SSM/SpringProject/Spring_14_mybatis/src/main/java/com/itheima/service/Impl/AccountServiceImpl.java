package com.itheima.service.Impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao; // 自动装配，保证accountDao不会是空对象。

	@Override
	public Account selectById(int id) {
		return accountDao.selectById(id);
	}

	@Override
	public List<Account> selectAll() {
		return accountDao.selectAll();
	}

	@Override
	public int deleteById(int id) {
		return accountDao.deleteById(id);
	}

	@Override
	public int updateById(String companyName, int id) {
		return accountDao.updateById(companyName, id);
	}

	@Override
	public int insert(Account account) {
		return accountDao.insert(account);
	}
}
