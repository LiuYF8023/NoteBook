package com.itheima.service;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountService {
	Account selectById(int id);

	List<Account> selectAll();

	int deleteById(int id);

	int updateById(@Param("companyName") String companyName, @Param("id") int id);

	int insert(Account account);
}
