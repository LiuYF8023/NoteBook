package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/books")
public class BookController {
	@GetMapping("/{id}")
	public String getById(@PathVariable Integer id) {
		System.out.println("id = " + id);
		return "hello spring boot!";
	}
}
