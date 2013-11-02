/*
 * EndPointManager.java
 * Copyright (C) 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
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
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;

import java.util.*;
import com.loopj.android.http.*;
import org.json.*;

public class PermissionManager {

    private Context mContext;

    public String[] PERMISSION_ENDS = {
        "provider",
        "verify",
        "order",
        "ip_tel",
        "query",
        "operator",
        "product",
        "open_order",
        "import",
        "export",
        "recorder",
        "video",
        "contact",
        "customer",
    };

    private Map<String, String> mPerms = new HashMap<String, String>();
    private static PermissionManager mInstance;

    private PermissionManager(Context context) {
        mContext = context;
    }

    public static PermissionManager newInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PermissionManager(context);
        }
        return mInstance;
    }

    public void loads(String result) {
        try {
            JSONObject jo = new JSONObject(result);
            JSONObject perms =  jo.optJSONObject("info");
            for (String end : PERMISSION_ENDS) {
                String key = buildKey(end);
                String p = perms.getString(key);
                mPerms.put(key, p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String buildKey(String key) {
        return key + "_permission";
    }

    private Boolean[] getPermission(String end) {
        String key = buildKey(end);
        String p = mPerms.get(key);
        if (p == null) {
            throw new RuntimeException("Can't find permission key for " + key);
        }

        List<Boolean> ps = new ArrayList<Boolean>();
        for (int i = 0; i < p.length(); i ++) {
            if (p.charAt(i) == '0') {
                ps.add(false);
            } else {
                ps.add(true);
            }
        }
        
        return ps.toArray(new Boolean[]{});
    }

    public boolean checkPermission(String end, int pos) {
        Boolean[] perms = getPermission(end);
        if (perms.length <= pos) {
            throw new RuntimeException("Position execeed permission array.");
        }

        boolean p = perms[pos];
        if (!p) {
            Toast.makeText(mContext,
                "没有权限", Toast.LENGTH_LONG).show();
        }
        return p;
    }
}
