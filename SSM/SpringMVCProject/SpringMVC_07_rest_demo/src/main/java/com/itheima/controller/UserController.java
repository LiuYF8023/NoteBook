package com.itheima.controller;

import org.springframework.web.bind.annotation.*;

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
