package com.xiaoshu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static ThreadLocal<SimpleDateFormat> simpleThreadLocal = new ThreadLocal<SimpleDateFormat>(){
		
		@Override
	    protected SimpleDateFormat initialValue() {
	    	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    }
	};
	
	/**

     * 获取当前日期与时间，通过时间戳实现日期的转换

     */
    public static String getCurrentDateTime(Long timeStamp) {
        return getCurrentDateTime(new Date(timeStamp));
    }
    
	/**

     * 获取当前日期与时间，通过时间进行日期的转换

     */
    public static String getCurrentDateTime(Date date){
    	return simpleThreadLocal.get().format(date);
    }
    
}
