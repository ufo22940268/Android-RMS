/*
 * EndPoints.java
 * Copyright (C) 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
package me.biubiubiu.rms.model;
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


public class EndPoints {

    private Map<String, String> mEndPoints = new HashMap<String, String>();

    public EndPoints() {
        mEndPoints.put("provider", "供应商");    
        mEndPoints.put("import", "入库");    
        mEndPoints.put("export", "出库");    
        mEndPoints.put("customer", "客户");    
        mEndPoints.put("operator", "操作员");    
        mEndPoints.put("product", "产品");    
        mEndPoints.put("order", "订单");    
    }
 
    public Map<String, String> getTitleMap() {
        return mEndPoints;   
    }

    public String getTitle(String endPoint) {
        return mEndPoints.get(endPoint);
    }

    public String get(String endPoint) {
        return getTitle(endPoint);
    }
}


