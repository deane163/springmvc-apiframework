package com.xiaoshu.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @Description : 统一对定义的业务异常进行处理
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月3日下午1:51:51
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
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
