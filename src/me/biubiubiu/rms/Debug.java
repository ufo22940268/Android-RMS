/*
 * Debug.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
 *
 * Distributed under terms of the MIT license.
 */
package me.biubiubiu.rms;

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
import me.biubiubiu.rms.ui.*;

public class Debug {

    public static boolean DEBUG_INIT_PERMISSION;

    public static String LOGIN_REPONSE = ""
        + "    {"
        + "        \"msg\": \"login succeed\","
        + "            \"status\": 200,"
        + "            \"token\": \"Basic azpr\","
        + "            \"info\": {"
        + "                \"provider_permission\": \"1111\","
        + "            \"verify_permission\": \"111\","
        + "            \"order_permission\": \"1111\","
        + "            \"ip_tel_permission\": \"11\","
        + "            \"query_permission\": \"1\","
        + "            \"operator_permission\": \"1111\","
        + "            \"product_permission\": \"1111\","
        + "            \"open_order_permission\": \"1111\","
        + "            \"import_permission\": \"1111\","
        + "            \"export_permission\": \"1111\","
        + "            \"recorder_permission\": \"11\","
        + "            \"video_permission\": \"1\","
        + "            \"contact_permission\": \"1111\","
        + "            \"customer_permission\": \"1111\""
        + "        }"
        + "    }";

    public static void mockPermission(Context context) {
        PermissionManager manager = PermissionManager.newInstance(context);
        manager.loads(LOGIN_REPONSE);
    }
}


