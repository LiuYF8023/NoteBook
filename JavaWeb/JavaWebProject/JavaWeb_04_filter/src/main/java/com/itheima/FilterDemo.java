package com.itheima;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		// 1、放行前，对request数据进行处理
		System.out.println("do filter ...");

		// 放行
		filterChain.doFilter(servletRequest,servletResponse);

		// 放行后 对response数据进行出咯
		//
		System.out.println("do filter 2");
	}

	@Override
	public void destroy() {

	}
}
