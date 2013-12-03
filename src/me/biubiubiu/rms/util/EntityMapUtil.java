/*
 * MapUtils.java
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
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.model.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;
import org.apache.commons.lang3.time.DateFormatUtils; 



public class EntityMapUtil {

    //Get map from type of entity view type.
    public static EntityMap getMap(String type) {
        if ("yes_or_no".equals(type)) {
            return new YesOrNoMap();
        } else if ("export_state".equals(type)) {
            return new ExportStateMap();
        } else if ("import_state".equals(type)) {
            return new ImportStateMap();
        } else {
            return null;
        }
    }
}


