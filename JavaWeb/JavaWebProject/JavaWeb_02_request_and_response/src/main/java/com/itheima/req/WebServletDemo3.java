package com.itheima.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/demo3")
public class WebServletDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求行
		System.out.println(req.getMethod());
		System.out.println(req.getContextPath());
		System.out.println(req.getRequestURL());
		System.out.println(req.getRequestURI());
		System.out.println(req.getQueryString());

		// 请求头
		System.out.println(req.getHeader("user-agent"));
		// 请求体
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post请求体
		BufferedReader reader = req.getReader();
		String line = reader.readLine();
		System.out.println(line);

	}
}
