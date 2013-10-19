/*
 * Parser.java
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
import android.text.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;

import java.util.*;
import org.json.*;

public class Parser {

    public static List<Map<String, String>> items(String resp) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>(); 
        try {
            JSONObject jo = new JSONObject(resp);
            JSONArray items = jo.optJSONArray("_items");
            if (items != null) {
                for (int i = 0; i < items.length(); i ++)  {
                    Map<String, String> map = new HashMap<String, String>();
                    JSONObject item = items.optJSONObject(i);
                    Iterator iter = item.keys();
                    String key;
                    while(iter.hasNext()) {
                        key = (String)iter.next();
                        String value = item.optString(key);
                        map.put(key, value);
                    }
                    list.add(map);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}


