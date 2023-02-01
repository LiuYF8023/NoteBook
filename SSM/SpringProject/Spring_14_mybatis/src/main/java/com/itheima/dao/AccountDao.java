package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountDao {
	@Select("select * from tb_brand where id = #{id}")
	Account selectById(int id);

	@Select("select * from tb_brand")
	List<Account> selectAll();

	@Delete("delete from tb_brand where id = #{id}")
	int deleteById(int id);

	@Update("update tb_brand set company_name = #{companyName} where id = #{id}")
	int updateById(@Param("companyName") String companyName,@Param("id") int id);

	@Insert("insert into tb_brand (brand_name, company_name, ordered, description, status) VALUES (#{brandName},#{companyName},#{ordered},#{description},#{status})")
	int insert(Account account);
}
