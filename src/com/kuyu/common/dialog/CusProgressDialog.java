
package com.kuyu.common.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuyu.common.R;

/**
 * 转圈圈对话框
 * @author fangzhengyou
 *
 */
public class CusProgressDialog extends Dialog {
	private static CusProgressDialog customProgressDialog = null;
	
	public CusProgressDialog(Context context){
		super(context);
	}
	
	public CusProgressDialog(Context context, int theme) {
        super(context, theme);
    }
	
	public static CusProgressDialog createDialog(Context context){
		customProgressDialog = new CusProgressDialog(context,R.style.CustomProgressDialog);
		customProgressDialog.setContentView(R.layout.dialog_progress_loading);
		customProgressDialog.setCanceledOnTouchOutside(false);
		customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
		customProgressDialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_progress_bg_selector);
		return customProgressDialog;
	}
 
    public void onWindowFocusChanged(boolean hasFocus){
    	
    	if (customProgressDialog == null){
    		return;
    	}
    	
        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.loadingImageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }
 
    public CusProgressDialog setTitile(String strTitle){
    	return customProgressDialog;
    }
    
    public CusProgressDialog setMessage(String strMessage){
    	TextView tvMsg = (TextView)customProgressDialog.findViewById(R.id.id_tv_loadingmsg);
    	if (tvMsg != null){
    		tvMsg.setText(strMessage);
    	}
    	return customProgressDialog;
    }
}
