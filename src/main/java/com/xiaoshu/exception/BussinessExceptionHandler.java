package com.xiaoshu.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BussinessExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@ExceptionHandler()
	public R handlerBussinessException(BussinessException exception){
		logger.info("开始统一处理业务异常信息");
		R r = new R();
		r.put("code", exception.getCode());
		r.put("msg", exception.getMessage());
		return r;
	}
}
