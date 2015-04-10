package com.kuyu.common.util;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.kuyu.common.R;

/**
 * 自定义ActionBar，整个Layout都自定义,要求API min=11
 * @author fangzhengyou
 * 目前推出三种样式，需要修改请自行修改Layout
 * 1、一个返回按钮，标题左对齐：actionbar_return
 * 2、一个返回按钮，标题左对齐，右边有提交按钮：actionbar_return_submit
 * 3、一个搜索框，一个搜索按钮：actionbar_research
 */
@SuppressLint("NewApi") 
public class CusActionBarUtil {
	
	public static final int ACTIONBAR_RETURN = 0;
	public static final int ACTIONBAR_RETURN_SUBMIT = 1;
	public static final int ACTIONBAR_RESEARCH = 2;

	/**
	 * 一个返回按钮，标题左对齐
	 * @param context
	 * @param actionBar
	 * @param title
	 * @param actionbartype
	 */
	public static void makeReturnActionBar(Context context,ActionBar actionBar, String title, int actionbartype) {
		actionBar.setDisplayHomeAsUpEnabled(true);
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = mInflater.inflate(R.layout.actionbar_return, null);
		
		TextView tvTitle = (TextView) v.findViewById(R.id.action_bar_text);
		if(tvTitle!=null){
			tvTitle.setText(title);
			tvTitle.setSelected(true);
		}
		actionBar.setCustomView(v, new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT));
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
	}

	/**
	 * 一个返回按钮，标题左对齐，右边有提交按钮
	 * @param context
	 * @param actionBar
	 * @param title
	 * @param btnText
	 * @param actionbartype
	 */
	public static void makeReturnSubmitActionBar(Context context,ActionBar actionBar, String title,String btnText ,int actionbartype) {
		actionBar.setDisplayHomeAsUpEnabled(true);
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = mInflater.inflate(R.layout.actionbar_return_submit, null);

		TextView tvTitle = (TextView) v.findViewById(R.id.action_bar_text);
		if(tvTitle!=null){
			tvTitle.setText(title);
			tvTitle.setSelected(true);
		}	
		
		TextView tvSubmit=(TextView)v.findViewById(R.id.tv_submit);
		if(tvSubmit!=null){
			tvSubmit.setText(btnText);
			tvSubmit.setSelected(true);
		}
		
		actionBar.setCustomView(v, new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT));
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
	}

	/**
	 * 一个搜索框，一个搜索按钮
	 * @param context
	 * @param actionBar
	 * @param title
	 */
	public static void makeResearchActionBar(Context context,ActionBar actionBar, String title) {
		actionBar.setDisplayHomeAsUpEnabled(true);
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = mInflater.inflate(R.layout.actionbar_research, null);
		
		actionBar.setCustomView(v, new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT));
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
	}
	
}
