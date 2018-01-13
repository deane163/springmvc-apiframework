/**
 * 
 */
package com.xiaoshu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * @Date : Create in 2018年1月13日 下午3:39:27
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */


public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public Object execute(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("开始执行日记记录...");
        
        // 将日志数据加入到任务队列，进行批量的提交处理
        Object object = pjp.proceed();
        return object;
    }
}
