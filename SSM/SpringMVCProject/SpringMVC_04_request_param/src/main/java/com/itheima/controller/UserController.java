package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

	@RequestMapping("/commonParam")
	@ResponseBody
	public String commonParam(@RequestParam("username") String name, int age) throws UnsupportedEncodingException {
		System.out.println("接受前端返回的参数 name = " + name);
		System.out.println("接受前端返回的参数 age = " + age);
		return "{'module':'common param'}";
	}

	// POJO 实体类对象参数
	@RequestMapping("/pojoParam")
	@ResponseBody
	public String pojoParam(User user){
		System.out.println("pojo参数传递" + user);
		return "{'module':'pojo param'}";
	}

	// POJO 实体类嵌套对象参数
	@RequestMapping("/pojoNextParam")
	@ResponseBody
	public String pojoNextParam(User user){
		System.out.println("pojo参数传递" + user);
		return "{'module':'pojo param'}";
	}

	// array
	@RequestMapping("/arrayParam")
	@ResponseBody
	public String arrayParam(String[] likes){
		System.out.println("数组参数传递" + Arrays.toString(likes));
		return "{'module':'array param'}";
	}

	// array
	@RequestMapping("/listParam")
	@ResponseBody
	public String listParam(@RequestParam List<String> likes){
		System.out.println("数组参数传递" + likes);
		return "{'module':'array param'}";
	}

	// array
	@RequestMapping("/jsonParam")
	@ResponseBody
	public String jsonParam(@RequestBody List<String> likes){
		System.out.println("数组参数传递" + likes);
		return "{'module':'array param'}";
	}

	@RequestMapping("/jsonNestParam")
	@ResponseBody
	public String jsonNestParam(@RequestBody User user){
		System.out.println("pojo参数传递" + user);
		return "{'module':'pojo param'}";
	}

	@RequestMapping("/dateParam")
	@ResponseBody
	public String dataParam(Date date,
							@DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
							@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date date2){
		System.out.println("date传递" + date);
		System.out.println("date传递" + date1);
		System.out.println("date传递" + date2);
		return "{'module':'pojo param'}";
	}
}
