package com.itheima.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/CookieA")
public class AServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 发送cookie
//		// 创建cookie对象
//		String name = "张三";
//		name = URLEncoder.encode(name,"UTF-8");
//		Cookie cookie = new Cookie("username",name);
//		// 设置存活时间 7天
//		cookie.setMaxAge(7 * 24 * 60 * 60);
//		// 发送cookie
//		response.addCookie(cookie);

		// 获取session
		HttpSession session = request.getSession();

		// 存储数据到session中
		session.setAttribute("username","zs");


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
