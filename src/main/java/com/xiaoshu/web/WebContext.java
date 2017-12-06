package com.xiaoshu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
