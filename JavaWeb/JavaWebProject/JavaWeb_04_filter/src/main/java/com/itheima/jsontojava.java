package com.itheima;

import com.alibaba.fastjson.JSON;

public class jsontojava {
	public static void main(String[] args) {
		// 1、将java对象转为json
		User user = new User();
		user.setName("zhangsan");
		user.setAge(12);
		String jsonStr = JSON.toJSONString(user);
		System.out.println(jsonStr);
		// 2、将json转为java对象

		User user2 = JSON.parseObject(jsonStr,User.class);
		System.out.println(user2);
	}
}
