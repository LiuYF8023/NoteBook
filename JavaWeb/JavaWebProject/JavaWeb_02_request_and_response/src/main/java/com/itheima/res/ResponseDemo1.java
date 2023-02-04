package com.itheima.res;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Respdemo1")
public class ResponseDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("res1 ...");

//		// 设置响应状态码 302
//		response.setStatus(302);
//		// 设置响应头
//		response.setHeader("location","/Respdemo2");

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/Respdemo2");


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
