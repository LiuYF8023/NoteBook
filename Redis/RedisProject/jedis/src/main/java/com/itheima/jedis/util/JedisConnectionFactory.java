package com.itheima.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisConnectionFactory {
	public static final JedisPool jedisPool;

	static {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 最大连接
		jedisPoolConfig.setMaxTotal(8);
		// 最大空闲连接
		jedisPoolConfig.setMaxIdle(8);
		// 最小空闲连接
		jedisPoolConfig.setMinIdle(0);

		// 设置等待时长 ms
		jedisPoolConfig.setMaxWait(Duration.ofSeconds(2));

		// 创建连接池对象
		jedisPool = new JedisPool(jedisPoolConfig, "192.168.26.128", 6379, 1000, "qwer");
	}
	// 获取 jedis对象
	public static Jedis getJedis(){
		return jedisPool.getResource();
	}
}
