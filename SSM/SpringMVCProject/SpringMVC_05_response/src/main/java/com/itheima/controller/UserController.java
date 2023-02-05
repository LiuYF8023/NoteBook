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
	@RequestMapping("/jumpToPage")
	public String jumpToPage(){
		return "page.jsp";
	}

	@RequestMapping("/toText")
	@ResponseBody
	public String toText(){
		return "hello world!";
	}

	@RequestMapping("/toJsonPOJO")
	@ResponseBody
	public User toJsonPOJO(){
		User user = new User();
		user.setname("zhangsan");
		user.setAge(15);
		return user;
	}
}
