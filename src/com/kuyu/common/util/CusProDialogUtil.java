package com.kuyu.common.util;


import com.kuyu.common.dialog.CusProgressDialog;

import android.content.Context;

/**
 * 自定义的一个ProgressDialog
 * @author fangzhengyou
 *
 */
public class CusProDialogUtil {
	private static CusProgressDialog progressDialog = null;

	public static void showProgressDialog(Context mContext){
		if (progressDialog == null){
			progressDialog = CusProgressDialog.createDialog(mContext);
	    	//progressDialog.setMessage(mContext.getString(R.string.is_loading));
		}
		if(progressDialog.isShowing()) return;
		progressDialog.show();
	}
	
	public static void exitProgressDialog() {
		if (progressDialog != null&&progressDialog.isShowing()){
				progressDialog.dismiss();
				progressDialog = null;
		}
	}
	
}
