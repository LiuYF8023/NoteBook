package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class SdrApplicationTests {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	// JSON 工具
	public static final ObjectMapper mapper = new ObjectMapper();

	@Test
	void RedisTest() {
		// 插入数据
		redisTemplate.opsForValue().set("username","张八");
		// 读取一条String类型的数据
		Object name = redisTemplate.opsForValue().get("username");
		System.out.println("name = " + name);
	}

	@Test
	void testSaveUser() {
		// 写入数据
		redisTemplate.opsForValue().set("user:100",new User("虎哥",21));
		// 获取数据
		redisTemplate.opsForValue().get("user:100");

	}

	@Test
	void testStringRedisTemplate() throws JsonProcessingException {
		// 准备对象
		User user = new User("虎哥哥",29);
		// 手动序列化
		String jsonStr = mapper.writeValueAsString(user);

		// 手写一条数据到Redis
		stringRedisTemplate.opsForValue().set("user:200",jsonStr);
		// 读取数据
		String val = stringRedisTemplate.opsForValue().get("user:200");

		// 反序列化
		User user200 = mapper.readValue(val,User.class);
		System.out.println("user200" + user200);
	}

	@Test
	void testHash() {
		stringRedisTemplate.opsForHash().put("user:400","name","虎哥");
		stringRedisTemplate.opsForHash().put("user:400","age","13");

		Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
		System.out.println("entries = " + entries);
	}

}
