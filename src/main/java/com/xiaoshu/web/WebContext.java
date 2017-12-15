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

	private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
	
	private static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();
	
	public static void init (HttpServletRequest req, HttpServletResponse res){
		request.set(req);
		response.set(res);
	}
	
	public static void destory(){
		
		request.remove();
		response.remove();
		
	}

	public static HttpServletRequest getRequest() {
		return request.get();
	}


	public static HttpServletResponse getResponse() {
		return response.get();
	}

	
}
