/**
 * 
 */
package com.xiaoshu.security.impl;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

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
 * @Date : Create in 2017年12月16日 下午3:09:38
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */

public class DefaultTokenManagerImpl implements TokenManager {

	private ConcurrentHashMap<String, Object> tokenMaps = new ConcurrentHashMap<String, Object>();
	
	@Override
	public boolean checkToken(String token) {
		//判读是否存在该key，如果存在，则该Token 正确
		return tokenMaps.contains(SECURITY_USER_TOKEN + token);
	}

	@Override
	public String createToken(String userName) {
	    //创建Token，并返回
		String token = UUID.randomUUID().toString().replace("-", "");
		tokenMaps.put(SECURITY_USER_TOKEN + token, token);
		return token;
	}
	
	@Override
    public void deleteToken(String token){
	    //删除Token
	    tokenMaps.remove(SECURITY_USER_TOKEN + token); 
    }

}
