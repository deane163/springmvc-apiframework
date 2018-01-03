package com.xiaoshu.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

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
 * @Description : ApplicationContext 工具类实现
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月2日下午8:41:48
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext myApplicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// 获得容器的上下文
		myApplicationContext = applicationContext;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		return (T)myApplicationContext.getBean(beanName);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName, Object... objects){
		return (T)myApplicationContext.getBean(beanName, objects);
	}
	
	
	public static <T> T getBean(Class<T> requiredClass){
		return myApplicationContext.getBean(requiredClass);
	}

	public static <T> T getBean(Class<T> requiredClass, Object... objects ){
		return myApplicationContext.getBean(requiredClass, objects);
	}
}
