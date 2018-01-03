package com.xiaoshu.exception;

import java.io.Serializable;

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
 * @Description : 对业务抛出异常的类名称
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月3日下午1:49:56
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
public class BussinessException extends RuntimeException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public BussinessException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BussinessException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public BussinessException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public BussinessException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
