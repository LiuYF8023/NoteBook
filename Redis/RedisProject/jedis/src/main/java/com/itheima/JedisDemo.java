package com.itheima;

import redis.clients.jedis.Jedis;

public class JedisDemo {
	public static void main(String[] args) {
		// 建立连接
		Jedis jedis = new Jedis("192.168.26.128", 6379);

		// 设置密码
		jedis.auth("qwer");

		// 选择库
		jedis.select(0);

		// 测试String
		// 插入数据
		String result = jedis.set("name", "张三");
		System.out.println("result = " + result);

		// 获取数据
		String name = jedis.get("name");
		System.out.println("name = " + name);

		// 释放资源
		if (jedis != null){
			jedis.close();
		}
	}
}
