/*
 * EyeCloud.java
 * Copyright (C) 2013 ccheng <ccheng@cchengs-MacBook-Pro.local>
 *
 * Distributed under terms of the MIT license.
 */

package me.biubiubiu.rms.util;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.app.*;
import android.os.*;
import android.text.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;

import java.util.*;

import me.biubiubiu.rms.R;
import android.content.ComponentName;
import android.content.pm.*;

public class EyeCloud {

    private Context mContext;

	public EyeCloud(Context context) {
		mContext = context;
	}

    public void launch() {
        if (isPackageExisted("com.vMEyeCloud")) {
            ComponentName cn = new ComponentName("com.vMEyeCloud", "com.vMEyeCloud.AcLogin");
            Intent intent = new Intent();
            intent.setComponent(cn);
            mContext.startActivity(intent);
        } else {
            showEyeCloudDialog();
        }
    }


    public boolean isPackageExisted(String targetPackage){
        List<ApplicationInfo> packages;
        PackageManager pm;
        pm = mContext.getPackageManager();        
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if(packageInfo.packageName.equals(targetPackage)) return true;
        }        
        return false;
    }
    private void showEyeCloudDialog() {
        new AlertDialog.Builder(mContext)
            .setMessage("你尚未安装vMEyeCloud")
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    Uri uri = Uri.parse("http://192.241.196.189:8000/vMEyeCloud.apk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mContext.startActivity(intent);
                     /* User clicked OK so do some stuff */
                }
            })
        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                /* User clicked Cancel so do some stuff */
            }
        })
        .show();
    }

}


