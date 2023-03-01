package com.itheima;

import com.itheima.jedis.util.JedisConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class TestJedis {

	private Jedis jedis;

	@Before
	public void setUp() throws Exception {
		// 建立连接
//		jedis = new Jedis("192.168.26.128", 6379);
		jedis = JedisConnectionFactory.getJedis();

		// 设置密码
		jedis.auth("qwer");

		// 选择库
		jedis.select(0);

	}

	@Test
	public void test() {
		// 测试String
		// 插入数据
		String result = jedis.set("name", "张三");
		System.out.println("result = " + result);

		// 获取数据
		String name = jedis.get("name");
		System.out.println("name = " + name);
	}

	@Test
	public void testHashSet(){
		// 插入
		jedis.hset("user:1","id","1");
		jedis.hset("user:1","age","12");

		// 获取
		Map<String, String> map = jedis.hgetAll("user:1");
		System.out.println(map);
	}

	@After
	public void tearDown() throws Exception {
		// 释放资源
		if (jedis != null){
			jedis.close();
		}
	}
}
