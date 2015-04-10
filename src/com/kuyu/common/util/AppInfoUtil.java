package com.kuyu.common.util;

import java.util.List;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

/**
 * 获取应用信息
 * @author fangzhengyou
 *
 */
public class AppInfoUtil {
	
	private AppInfoUtil()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");

	}
	
	/**
	 * 获取应用程序名称
	 */
	public static String getAppName(Context context)
	{
		try
		{
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			int labelRes = packageInfo.applicationInfo.labelRes;
			return context.getResources().getString(labelRes);
		} catch (NameNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取版本号
	 * 
	 * @return 当前应用的版本号
	 */
	public static String getVersion(Context context) {
		String verison="";
		try {
			PackageManager manager = context.getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
			String version = info.versionName;
			return version;
		} catch (Exception e) {
			e.printStackTrace();
			return verison;
		}
	}
	
	/**
	 * 判断Activity是否在栈顶
	 * 
	 * @return true or false
	 */
	public static boolean isForeground(String PackageName,String activityName,Context context){
		  ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		  List< ActivityManager.RunningTaskInfo > task = manager.getRunningTasks(1);
		  ComponentName componentInfo = task.get(0).topActivity;
		  if(componentInfo.toString().equals(activityName)) return true;
		  return false;
	}
	
	/**
	 * 取得app图标
	 * @param ctx
	 * @param pkg
	 * @return
	 */
	public static Drawable getIcon(Context ctx,String pkg){
		try{
			PackageInfo info = ctx.getPackageManager().getPackageInfo(pkg,0);
			Drawable d = info.applicationInfo.loadIcon(ctx.getPackageManager());
			return d;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
    /**
     * 添加应用到桌面快捷方式
     * @param ctx
     * @param name
     * @param icon
     * @param duplicate
     * @param intent
     */
	public static void addSelfShortcut(Context ctx,String name,Parcelable icon,boolean duplicate,Intent intent) {
		Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
		// 显示的名字
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,name);
		// 显示的图标
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
		// 不允许重复创建
		shortcut.putExtra("duplicate", duplicate);
		// 这个是快捷方式所实现的功能
		intent.setAction(Intent.ACTION_MAIN);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
		// 发送广播用以创建shortcut
		ctx.sendBroadcast(shortcut);
	}
	
    /**
     * 添加应用到桌面快捷方式
     * @param ctx
     * @param nameId
     * @param iconId
     * @param duplicate
     * @param intent
     */
	public static void addSelfShortcut(Context ctx,int nameId,int iconId,boolean duplicate,Intent intent) {
		String name=ctx.getString(nameId);
		Parcelable icon = Intent.ShortcutIconResource.fromContext(ctx,iconId);
		addSelfShortcut(ctx,name,icon,duplicate,intent);
	}
}
