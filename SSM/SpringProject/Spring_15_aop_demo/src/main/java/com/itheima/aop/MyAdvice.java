package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

	@Pointcut("execution(* com.itheima.dao.BookDao.update())")
//	@Pointcut("execution(* com.*.*.*.update())")
//	@Pointcut("execution(* com.*.*.*.*.update())")
//	@Pointcut("execution(* *..update())")
	private void pt() {
		System.out.println("pt ...");
	}

	@Before("pt()")
	public void before() {
		System.out.println(System.currentTimeMillis());
	}

	@After("pt()")
	public void after() {
		System.out.println(System.currentTimeMillis());
	}

	@Around("pt()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before...");
		// 表示对原始操作的调用
		Object ret = pjp.proceed();
		System.out.println("around after...");
		return ret;
	}



}
