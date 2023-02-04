package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 4、定义一个Servlet容器启动的配置类，在里面加载spring配置
//public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
//
//	// 加载springmvc的容器配置
//	@Override
//	protected WebApplicationContext createServletApplicationContext() {
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(SpringMvcConfig.class);
//		return ctx;
//	}
//
//	// 设置哪些请求之归springmvc处理
//	@Override
//	protected String[] getServletMappings() {
//		return new String[]{"/"}; // / 表示所有请求
//	}
//
//	// 加载spring容器配置
//	@Override
//	protected WebApplicationContext createRootApplicationContext() {
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(SpringConfig.class);
//		return ctx;
//	}
//}

public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SpringConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}