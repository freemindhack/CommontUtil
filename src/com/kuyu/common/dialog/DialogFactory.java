package com.kuyu.common.dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * setTitle ：为对话框设置标题
setIcon ：为对话框设置图标
setMessage：为对话框设置内容
setView ： 给对话框设置自定义样式
setItems ：设置对话框要显示的一个list，一般用于显示几个命令时
setMultiChoiceItems ：用来设置对话框显示一系列的复选框
setNeutralButton    ：普通按钮

setPositiveButton   ：给对话框添加"Yes"按钮
setNegativeButton ：对话框添加"No"按钮
create ： 创建对话框
show ：显示对话框
 * @author fang
 *
 */
public class DialogFactory {
	
	/**
	 * 创建对话框
	 * @param ctx
	 * @param title
	 * @param message
	 * @return
	 */
	public static AlertDialog newAlertDialog(Context ctx,String title,String message){
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(title);//设置标题
        builder.setMessage(message);//设置提示消息		
		return builder.create();
	}
	
	/**
	 * 创建对话框
	 * @param ctx
	 * @param title
	 * @param message
	 * @return
	 */
	public static AlertDialog newAlertDialog(Context ctx,int title,int message){
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(ctx.getString(title));//设置标题
        builder.setMessage(ctx.getString(message));//设置提示消息		
		return builder.create();
	}
	
	
	public static ProgressDialog newProgressDialog(Context ctx){
		ProgressDialog dialog = new ProgressDialog(ctx);
		return dialog;
		
	}
}
