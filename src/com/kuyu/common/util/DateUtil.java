package com.kuyu.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

import android.util.Log;
/**
 * 处理日期的工具
 * @author fangzhengyou
 *
 */
public class DateUtil {
	
	public static Date parseDate(String date){
		try {
			return DateUtils.parseDate(date);
		} catch (DateParseException e) {
			Log.d("DateUtil", e.getMessage());
			return null;
		}
	}
	/**
	 * 取得当前时间
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		return formatter.format(curDate);
	}
	
	/**
	 * 取得年
	 * @return
	 */
	public static int getYear(){
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		return y;
	}
	
	/**
	 * 取得月
	 * @return
	 */
	public static int getMonth(){
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH) + 1;
		return m;
	}
	
	/**
	 * 取得日
	 * @return
	 */
	public static int getDay(){
		Calendar calendar = Calendar.getInstance();
		int d = calendar.get(Calendar.DAY_OF_MONTH);		
		return d;
	}
	
	/**
	 * 取得年
	 * @param calendar
	 * @return
	 */
	public static int getYear(Calendar calendar){
		int y = calendar.get(Calendar.YEAR);
		return y;
	}
	
	/**
	 * 取得月
	 * @param calendar
	 * @return
	 */
	public static int getMonth(Calendar calendar){
		int m = calendar.get(Calendar.MONTH) + 1;
		return m;
	}
	
	/**
	 * 取得日
	 * @param calendar
	 * @return
	 */
	public static int getDay(Calendar calendar){
		int d = calendar.get(Calendar.DAY_OF_MONTH);		
		return d;
	}
	
	/**
	 * 创建日历对象
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static Calendar getCalendar(int year, int month, int day, int hour,
			int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		return calendar;
	}	
}
