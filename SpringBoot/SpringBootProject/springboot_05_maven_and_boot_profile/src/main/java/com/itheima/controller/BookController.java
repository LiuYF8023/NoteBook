package com.itheima.controller;

import com.itheima.domain.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/books")
public class BookController {

	@Autowired
	private Enterprise enterprise;

	@GetMapping("/{id}")
	public String getById(@PathVariable Integer id) {
		System.out.println(enterprise);
		return "hello spring boot!";
	}
}
