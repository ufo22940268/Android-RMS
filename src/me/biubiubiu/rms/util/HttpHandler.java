/*
 * HttpHandler.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
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

public class HttpHandler {

    static public final boolean DEBUG = true;
    static public final String TAG = "HttpHandler";
    static public final String BASE_URL = "http://192.168.1.101:5000/";
    private Context mContext;

    public HttpHandler(Context context) {
        mContext = context;
    }

    public void get(String endPoint, final ResponseHandler handler) {
        get(endPoint, null, handler);
    }

    public void get(String endPoint, final Map<String, String> entity, final ResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("asdf", "asdf");
        String url = getUrl(endPoint);
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String response) {
                if (DEBUG) {
                    Log.d(TAG, "++++++++++++++++++++response:" + response);
                }

                handler.onSuccess(response);
            }

        @Override
        public void onFailure(Throwable e, String response) {
            if (DEBUG) {
                Log.d(TAG, "++++++++++++++++++++response failed:" + response);
            }
        }
        });
    }

    public void add(String endPoint, final Map<String, String> entity, final ResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("asdf", "asdf");
        RequestParams params = new RequestParams();
        JSONObject jo = new JSONObject(entity);
        params.put("item1", jo.toString());
        client.addHeader("Content-Type", "application/x-www-form-urlencoded");
        String url = BASE_URL + endPoint;
        if (DEBUG) {
            Log.d(TAG, "++++++++++++++++++++url:" + url);
        }
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String response) {
                if (DEBUG) {
                    Log.d(TAG, "++++++++++++++++++++response:" + response);
                }

                handler.onSuccess(response);
            }

        @Override
        public void onFailure(Throwable e, String response) {
            if (DEBUG) {
                Log.d(TAG, "++++++++++++++++++++response failed:" + response);
            }
        }

        });
    }

    public static class ResponseHandler {

        public void onSuccess(String result) {
        }

        public void onFinish() {
        }
    }

    public static String getUrl(String end) {
        String url = BASE_URL + end;
        if (DEBUG) {
            Log.d(TAG, "++++++++++++++++++++url:" + url);
        }
        return url;
    }
}
