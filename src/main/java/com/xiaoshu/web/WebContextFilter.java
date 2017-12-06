package com.xiaoshu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

 * 用于管理 WebContext 对象的生命周期

 * @author Administrator

 *

 */
public class WebContextFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//省略
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("管理 Webcontext");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		WebContext.init(request, response);
		if(request.getMethod().equalsIgnoreCase("OPTIONS")){
			return;
		}
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			WebContext.destory();
		}
	}

	@Override
	public void destroy() {
		//省略

	}

}