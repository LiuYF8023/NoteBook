package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/CookieB")
public class BServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie1 : cookies) {
//			if (cookie1.getName().equals("username")) {
//				System.out.println(cookie1.getName() + " " + URLDecoder.decode(cookie1.getValue()));
//			}
//		}
		// 获取session对象
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("username"));

		session.invalidate();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
