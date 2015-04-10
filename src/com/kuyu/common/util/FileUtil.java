package com.kuyu.common.util;

import java.io.File;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;
/**
 * 文件处理
 * @author fangzhengyou
 *
 */
public class FileUtil {
	private static final String TAG = "FileUtil";

	public static File getCacheFile(String imageUri,String cacheDir){
		File cacheFile = null;
		try {
			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				File sdCardDir = Environment.getExternalStorageDirectory();
				String fileName = getFileName(imageUri);
				File dir = new File(sdCardDir.getCanonicalPath() + cacheDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				cacheFile = new File(dir, fileName);
				Log.i(TAG, "exists:" + cacheFile.exists() + ",dir:" + dir + ",file:" + fileName);
			}  
		} catch (IOException e) {
			e.printStackTrace();
			Log.e(TAG, "getCacheFileError:" + e.getMessage());
		}
		
		return cacheFile;
	}
	
 	public static String getFileName(String pathandname){ 
 		int start=pathandname.lastIndexOf("/");  
         int end=pathandname.lastIndexOf(".");  
         if(start!=-1 && end!=-1){  
             return pathandname.substring(start+1,end);    
         }else{  
             return null;  
         }             
 	}
}