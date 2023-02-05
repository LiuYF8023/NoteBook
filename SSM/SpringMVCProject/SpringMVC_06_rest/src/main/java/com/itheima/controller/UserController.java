package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/users")
public class UserController {
	// 查询所有
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String save(){
		System.out.println("user save...");
		return "{'module':'user save'}";
	}

	// 删除
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id){
		System.out.println("user delete..." + id);
		return "{'module':'user delete'}";
	}

	// 更新
	@PutMapping
	public String update(@RequestBody User user){
		System.out.println("user save..." + user);
		return "{'module':'user save'}";
	}

	// 条件查找
	@GetMapping("/{id}")
	public String getById(Integer id){
		System.out.println("user save..." + id);
		return "{'module':'user getById'}";
	}
	// 条件查找
	@GetMapping
	public String getAll(){
		System.out.println("user save...");
		return "{'module':'user getall'}";
	}
}
