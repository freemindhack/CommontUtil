package com.kuyu.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.kuyu.common.R;

/**
 * 确认窗口
 * @author Administrator
 *
 */
public class LoadingDialog extends Dialog{
	private String title;
	public LoadingDialog(Context context, int theme,String title) {
		super(context,theme);
		this.title = title;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_loading,null);
		TextView titleView = (TextView)view.findViewById(R.id.tv_title);
//		Button okButton = (Button)view.findViewById(R.id.bt_ok);
//		Button cancelButton = (Button)view.findViewById(R.id.bt_cancel);
		//titleView.setText(String.format(title, item.getRingName()));
		titleView.setText(title);
		setContentView(view);
//		okButton.setOnClickListener(this);
//		cancelButton.setOnClickListener(this);
		
	}

}