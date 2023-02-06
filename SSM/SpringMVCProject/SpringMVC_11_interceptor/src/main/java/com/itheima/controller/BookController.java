package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

	@PostMapping
	public String save(@RequestBody Book book) {
		System.out.println("book save");
		return "save";
	}

	@PutMapping
	public String update(@RequestBody Book book) {
		System.out.println("book save");

		return "update";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		System.out.println("book save");

		return "delete";
	}

	@GetMapping("/{id}")
	public String getById(@PathVariable Integer id) {
		System.out.println("book save");

		return "getById";
	}

	@GetMapping
	public String getAll() {
		System.out.println("book save");

		return "getAll";
	}
}
