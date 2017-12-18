package com.xiaoshu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description : WebContext管理
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月15日下午4:53:35
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public class WebContext {

	private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
	
	private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<HttpServletResponse>();
	
	public static void init (HttpServletRequest req, HttpServletResponse res){
		requestHolder.set(req);
		responseHolder.set(res);
	}
	
	public static void destory(){
		
		requestHolder.remove();
		responseHolder.remove();
		
	}

	public static HttpServletRequest getRequest() {
		return requestHolder.get();
	}


	public static HttpServletResponse getResponse() {
		return responseHolder.get();
	}

	
}
