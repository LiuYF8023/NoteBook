package com.itheima.controller;

import com.itheima.exception.BussinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
	// 系统异常
	@ExceptionHandler(SystemException.class)
	public Result doSystemException(SystemException e){
		// 1、记录日志

		// 2、发送消息给运维

		// 3、发送邮件给开发人员

		return new Result(e.getCode(),null,e.getMessage());
	}

	// 业务异常
	@ExceptionHandler(BussinessException.class)
	public Result doBusinessException(BussinessException e){
		return new Result(e.getCode(),null,e.getMessage());
	}

	// 第三类 处理所有异常
	@ExceptionHandler(Exception.class)
	public Result doException(Exception e){
//		System.out.println("处理异常");
//		return new Result(666,null,"处理异常");
		return new Result(Code.SYSTEM_UNKNOW,null,"系统繁忙");
	}
}
