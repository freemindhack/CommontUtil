package com.kuyu.common.dialog;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * 后台加载进度条
 * @author fang
 *
 * @param <Params>
 * @param <Result>
 */
public abstract class LoadingBar<Params, Result> extends AsyncTask<Params, Integer, Result> {
	private ProgressBar bar;
	
	public LoadingBar(Context context) {
		bar = new ProgressBar(context);
	}
	
	public LoadingBar(Context context,ProgressBar bar) {
		this.bar = bar;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
        int vlaue = values[0];  
        bar.setProgress(vlaue);  
		super.onProgressUpdate(values);
	}
}
