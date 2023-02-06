package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
	@PostMapping
	// 保存功能
	public String save(Book book){
		System.out.println("book save" + book);
		return "{'module':'book save success'}";
	}

	@GetMapping
	// 获取全部功能
	public List<Book> getAll(){
		List<Book> bookList = new ArrayList<>();
		Book book1 = new Book();
		book1.setType("asdasf");
		book1.setName("sdfhhsdhsdf");
		book1.setDescription("asdasasdf");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setType("asdasf");
		book2.setName("sdfhhsdhsdf");
		book2.setDescription("asdasasdf");
		bookList.add(book2);

		return bookList;
	}
}
