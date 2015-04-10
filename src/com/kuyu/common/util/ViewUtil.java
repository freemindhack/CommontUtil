package com.kuyu.common.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
/**
 * 对View的操作
 * @author fangzhengyou
 *
 */
public class ViewUtil {

  	/**
  	 * 设置View的大小
  	 * @param v
  	 * @param W
  	 * @param H
  	 */
	public static void changeWH(View v,int W,int H)
	{
		LayoutParams params = (LayoutParams)v.getLayoutParams();
	    params.width = W;
	    params.height = H;
	    v.setLayoutParams(params);
	}
	
	/**
	 * 设置View的高度
	 * @param v
	 * @param H
	 */
	public static void changeH(View v,int H)
	{
		LayoutParams params = (LayoutParams)v.getLayoutParams();
	    params.height = H;
	    v.setLayoutParams(params);
	}
}
