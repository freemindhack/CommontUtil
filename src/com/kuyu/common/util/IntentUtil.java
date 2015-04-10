package com.kuyu.common.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

/**
 * 各种Intent的跳转
 * @author fangzhengyou
 *
 */
public class IntentUtil {
	
	/**
	 * 取得系统设定的intent
	 * @return
	 */
	public static Intent getSettingIntent(){
		int currentapiVersion=android.os.Build.VERSION.SDK_INT;
		Intent intent = null;
        if(currentapiVersion < 11){ 
            intent = new Intent(); 
            intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings"); 
        }else{ 
            //3.0以后 
            //intent = new Intent( android.provider.Settings.ACTION_WIRELESS_SETTINGS); 
            intent = new Intent( android.provider.Settings.ACTION_SETTINGS); 
        }
        return intent;
	}
	
	public static Intent newMaketIntent(String pkg){
		//方法一
//		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(playAppUrl)); 
//		browserIntent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity"); 
//		browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
//		startActivity(browserIntent);
		//方法二
		//String component = "com.wandoujia.phoenix2/com.wandoujia.phoenix2.ui.WelcomeActivity";
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id="+pkg));
		return intent;
	}
	
	public static Intent newMarketIntent2(String pkg){
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+pkg)); 
		browserIntent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity"); 
		browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return browserIntent;
	}
	
	/**
	 * 
	 * <p>Description: 调用照相机拍照</p>
	 * <p>Copyright: Copyright (c) 2011</p>
	 * <p>Company: Huatek</p>
	 * <p>CreateTime: Dec 11, 2013 2:24:45 PM</p>
	 * @author Fred.Ren
	 * @version 1.0.0.0
	 * @param uri 拍照后的输出路径
	 */
	@SuppressLint("ShowToast")
	public static void toCamera(Context context, Uri uri) {
		try {
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			//告诉相机拍摄完毕输出图片到指定的Uri
			intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uri);
			((Activity) context).startActivityForResult(intent, 1);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(context, "找不到照相机", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 
	 * <p>Description: 裁剪拍照后的图片的回调方法</p>
	 * <p>Copyright: Copyright (c) 2011</p>
	 * <p>Company: Huatek</p>
	 * <p>CreateTime: Dec 27, 2013 3:45:24 PM</p>
	 * @author Fred.Ren
	 * @version 1.0.0.0
	 * @param context 环境变量
	 * @param currentImageBitmap 当前图片的位图
	 * @param currentImageUri 当前图片的uri地址
	 * @param withheight 输入大小
	 * @param outUri 输入Uri
	 */
	public static void cropCameraPhoto(Context context, Bitmap currentImageBitmap, Uri currentImageUri, int withheight, Uri outUri) {
		// Intent intent = getCropImageIntent(data);
		Intent intent = buildCropIntent(context, currentImageBitmap, currentImageUri, withheight, outUri);
		((Activity) context).startActivityForResult(intent, 3023);
	}

	/**
	 * 
	 * <p>Description: 剪裁方法</p>
	 * <p>Copyright: Copyright (c) 2011</p>
	 * <p>Company: Huatek</p>
	 * <p>CreateTime: Dec 27, 2013 3:36:47 PM</p>
	 * @author Fred.Ren
	 * @version 1.0.0.0 
	 * @param context 环境变量
	 * @param currentImageBitmap 当前要操作的图片的位图
	 * @param currentImageUri 当前要操作的图片的uri地址
	 * @param withheight 输入图片的大小
	 * @param outUri 处处图片的uri地址
	 * @return 意图
	 */
	private static Intent buildCropIntent(Context context, Bitmap currentImageBitmap, Uri currentImageUri, int withheight, Uri outUri) {
		//缓存Uri
		//		Uri cacheUri = Uri.fromFile(new File(SdcardUtil.getCropCachePath(context) + "/" + cacheName));
		//		Uri cacheUris = cacheUri;

		Intent intent = new Intent("com.android.camera.action.CROP");
		if (currentImageUri != null) {
			intent.setDataAndType(currentImageUri, "image/*");
		}
		if (currentImageBitmap != null) {
			intent.setType("image/*");
			intent.putExtra("data", currentImageBitmap);
		}
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", withheight);
		intent.putExtra("outputY", withheight);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, outUri);
		intent.putExtra("return-data", true);//true 不反悔uri，false 返回uri
		return intent;
	}

	// /////////////////////camera end//////////////////////////

	// /////////////////////cameraPhoto start////////////////////
	/**
	 * 
	 * <p>Description:  调用图库选择图片</p>
	 * <p>Copyright: Copyright (c) 2011</p>
	 * <p>Company: Huatek</p>
	 * <p>CreateTime: Dec 27, 2013 3:43:32 PM</p>
	 * @author Fred.Ren
	 * @version 1.0.0.0
	 * @param context
	 */
	public static void toImage(Context context) {
		try {
			Intent intentFromGallery = new Intent();
			intentFromGallery.setType("image/*");
			// 设置文件类型
			intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
			((Activity) context).startActivityForResult(intentFromGallery, 0);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(context, "找不到图库", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 
	 * <p>Description: 裁剪图库图片的回调方法</p>
	 * <p>Copyright: Copyright (c) 2011</p>
	 * <p>Company: Huatek</p>
	 * <p>CreateTime: Dec 27, 2013 3:41:58 PM</p>
	 * @author Fred.Ren
	 * @version 1.0.0.0
	 * @param context 环境变量
	 * @param currentImageBitmap 当前要操作的图片的位图
	 * @param currentImageUri 当前要操作的图片的Uri地址
	 * @param withheight 输入图片的大小
	 * @param outUri 输入图片的uri地址
	 */
	public static void cropImagePhoto(Context context, Bitmap currentImageBitmap, Uri currentImageUri, int withheight, Uri outUri) {
		// Intent intent = startPhotoZoom(uri);
		Intent intent = buildCropIntent(context, currentImageBitmap, currentImageUri, withheight, outUri);
		((Activity) context).startActivityForResult(intent, 3021);
	}
}
