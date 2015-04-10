package com.kuyu.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String处理类
 * @author fangzhengyou
 *
 */
public class StringUtil {
	// 这边增加所有的符号,例如要加一个'则变成[(.|,|\"|\\?|!|:|')],如果是特殊符号要加转换 \
	private static Pattern p1 = Pattern.compile("[(.|,|\"|\\?|!|:;'：)]");
	// //先去掉标点,再合并空格
	private static Pattern p2 = Pattern.compile("   {2,}");
	private static String regEx = "[-\\\\_\"\\`~!@#$%^&*()+=|{}':;',//[//]\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？ ]";
	private static Pattern p3 = Pattern.compile(regEx);
	private static Pattern p4 = Pattern.compile("\\d");
	public static String filterSign(String str) {
		return p2.matcher(p1.matcher(str).replaceAll("")).replaceAll("");
	}

	/**
	 * 去掉字符中特需字符
	 * @param str
	 * @return
	 */
	public static String stringFilterForNormal(String str) { 
		Matcher m = p3.matcher(str);
		return m.replaceAll("").trim();
	}
	public static String clearNum(String str){
		return p4.matcher(str).replaceAll("").trim();
	}
	
	public static String randomCode(){
		Random random = new Random();
		int val = random.nextInt(999999);
		if (val<10){
			return "00000"+val;
		}else if (val<100){
			return "0000"+val;
		}else if (val<1000){
			return "000"+val;
		}else if (val<10000){
			return "00"+val;
		}else if (val<100000){
			return "0"+val;
		}
		return String.valueOf(val);
	}
	
	public static String formatSize(long size){
		if (size>=1024*1024){
			float fl = size/(1024*1024f);
			DecimalFormat b = new DecimalFormat("###.##");  
			  return String.format("%sMB", b.format(fl));
		}else{
			float fl = size/1024f;
			DecimalFormat b = new DecimalFormat("###.##");  
			  return String.format("%sKB", b.format(fl));
		}
	}

	/**
	 * 去掉号码前缀 +86
	 * @return
	 */
	public static String trimPhone(String phone){
		if (phone==null){
			return phone;
		}
		if (phone.startsWith("+86")){
			phone = phone.substring(3);
		}
		phone = stringFilterForNormal(phone);
		return phone;
	}
	
 	/**
 	 * 转换InputStream到String
 	 * @param is
 	 * @return
 	 */
 	public static String convertStreamToString(InputStream is) {
 		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line = null;

			try {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "/n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return sb.toString();	
 	}	
}
