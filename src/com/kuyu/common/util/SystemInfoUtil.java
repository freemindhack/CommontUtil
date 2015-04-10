package com.kuyu.common.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * 获取系统信息
 * @author fangzhengyou
 *
 */
public class SystemInfoUtil {

	/**
	 * 判断系统是否联网
	 * @param context 
	 */
	public static boolean isNetworkConnected(Context context) { 
	     if (context != null) { 
	         ConnectivityManager mConnectivityManager = (ConnectivityManager) context 
	                 .getSystemService(Context.CONNECTIVITY_SERVICE); 
	         NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo(); 
	         if (mNetworkInfo != null) { 
	             return mNetworkInfo.isAvailable(); 
	         } 
	     } 
	     return false; 
	}
	
	/**
	 * 取得imsi号码
	 * @param ctx
	 * @return
	 */
	public static String getImsi(Context ctx){
		TelephonyManager mTelephonyMgr = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
		String imsi = mTelephonyMgr.getSubscriberId();
		if(imsi == null){
			imsi ="";
		}
		return imsi;
	}
	
	/**
	 * 取得imei号码
	 * @param ctx
	 * @return
	 */
	public static String getImei(Context ctx){
		TelephonyManager mTelephonyMgr = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
		String imei=mTelephonyMgr.getDeviceId();
		if(imei == null){
			imei ="";
		}
		return imei;
	}
	
	/**
	 * 取得本机ip地址
	 * @return
	 */
    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("WifiPreference IpAddress", ex.toString());
        }
        return null;
    }	
    
	/**
	 * 判断是否是wifi连接
	 */
	public static boolean isWifi(Context context)
	{
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (cm == null)
			return false;
		return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;

	}
	
}
