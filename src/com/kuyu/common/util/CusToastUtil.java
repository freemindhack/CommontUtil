package com.kuyu.common.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kuyu.common.R;
/**
 * 自定义Toast
 * @author fangzhengyou
 * 
 * 若要更改自定义格式可以在layout中修改，或者在showText()方法中修改；
 * 
 * 这个类除了能自定义Toast外，还可以在非UI线程中调用；
 */
public class CusToastUtil {

	public static final int ONE_SECOND = 1 * 1000;
	public static final int TWO_SECOND = 2 * 1000;
	public static final int THREE_SECOND = 3 * 1000;
	private static Toast toast;

	/**
	 * 显示自定义Toast
	 * @param context
	 * @param msg 字符串
	 * @param duration
	 */
	public static void showText(final Context context, final String msg,final int duration) {
		Handler handler = new Handler(Looper.getMainLooper());
		handler.post(new Runnable() {
			@Override
			public void run() {
				if (null == context) return;
				if (toast == null)toast = new Toast(context);
				
				View view = LayoutInflater.from(context).inflate(R.layout.dialog_toast, null);
				TextView message = (TextView) view.findViewById(R.id.tv_msg);
				message.setText(msg);
				
				toast.setGravity(Gravity.CENTER, Gravity.FILL_HORIZONTAL,Gravity.FILL_VERTICAL);
				toast.setDuration(duration);
				toast.setView(view);
				toast.show();
			}
		});
	}

	/**
	 * 显示自定义Toast
	 * @param context
	 * @param resId 字符串id
	 * @param duration
	 */
	public static void showText(final Context context, final int resId,final int duration) {
		String msg=context.getString(resId);
		showText(context,msg,duration);
	}
}
