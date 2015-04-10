package com.kuyu.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * 待提示框的异步操作对象 <br>
 * 主要作用:对需要异步操作的逻辑,进行弹出等待对话框处理,处理完毕自动关闭等待对话框
 * 
 * @author 林佛权
 * 
 * @param <Params>
 * @param <Progress>
 * @param <Result>
 */
public abstract class LoadingAsyncTask<Params, Progress, Result> extends
		AsyncTask<Params, Progress, Result> {
	protected Context ctx;
	private Dialog dialog;

	public LoadingAsyncTask(Context ctx,int theme, String title) {
		this.ctx = ctx;
		dialog = new LoadingDialog(ctx, theme, title);
	}

	public LoadingAsyncTask(Dialog dialog) {
		this.dialog = dialog;
	}

	@Override
	protected void onCancelled() {
		super.onCancelled();
		dialog.cancel();
	}

	@Override
	protected void onPostExecute(Result result) {
		super.onPostExecute(result);
		dialog.dismiss();
	}

	@Override
	protected void onPreExecute() {
		dialog.show();
		super.onPreExecute();
	}
	public void setTitle(String title){
		dialog.setTitle(title);
	}
}
