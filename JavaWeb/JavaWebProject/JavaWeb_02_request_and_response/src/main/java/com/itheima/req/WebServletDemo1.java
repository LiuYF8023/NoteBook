package com.itheima.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo4")
public class WebServletDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 使用request对象，获取请求数据
		// 格式 url?name=XXX
		String name = req.getParameter("name");

		// 将获取的数据输出到页面中
		resp.setHeader("content-type","text/html;charset=utf-8");
		resp.getWriter().write(name + "你好！");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
