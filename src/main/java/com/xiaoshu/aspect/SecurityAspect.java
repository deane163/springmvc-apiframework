/**
 * 
 */
package com.xiaoshu.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xiaoshu.annotation.Authorization;
import com.xiaoshu.security.TokenManager;

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
 * @Description : 
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月16日 下午3:04:27
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public class SecurityAspect {
	
	private TokenManager tokenManager;
	/**
	 * @param tokenManager the tokenManager to set
	 */
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}


	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		// 从切点上获取目标方法
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		// 若目标方法忽略了安全性检查，则直接调用目标方法
		if (!method.isAnnotationPresent(Authorization.class)
				&& !method.getClass().isAnnotationPresent(Authorization.class)) {
			return joinPoint.proceed();
		}

		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        String token = getAuthentication(request);
	    //如果无效则抛出异常

		if(StringUtils.isEmpty(token) || !tokenManager.checkToken(token)){
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token is null or Token is invalid");
			return null;
		}
		//如果app_token 有效则继续执行方法
		return joinPoint.proceed();
	}
	
	
	//从头部或者cookies中获得Token信息
	private String getAuthentication(HttpServletRequest request) {
		String authentication = request.getHeader(TokenManager.SECURITY_USER_TOKEN);
		if (authentication == null) {
			Cookie[] cookies = request.getCookies();
			if (cookies == null) {
                return null;
            }
			for (Cookie cookie : cookies) {
				if (TokenManager.SECURITY_USER_TOKEN.equals(cookie.getName())) {
					authentication = cookie.getValue();
					break;
				}
			}
		}
		return authentication;
	}
	
}
