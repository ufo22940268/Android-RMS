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
    //static public final String BASE_URL = "http://192.168.1.101:5000/";
    static public final String BASE_URL = "http://192.241.196.189:5000/";
    private Context mContext;
    private ProgressDialog mLoadingDialog;

    public HttpHandler(Context context) {
        mContext = context;
    }

    public void get(String endPoint, int page, final ResponseHandler handler) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("max_results", "2");
        map.put("page", String.valueOf(page));
        get(endPoint, map, handler);
    }

    public void get(String endPoint, final ResponseHandler handler) {
        get(endPoint, null, handler);
    }

    public void get(String endPoint, final Map<String, String> entity, final ResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("asdf", "asdf");
        String url = getUrl(endPoint);
        RequestParams params = new RequestParams();
        putParams(params, entity);
        params.put("sort", "[(\"_id\", -1)]");

        final String fullUrl = AsyncHttpClient.getUrlWithQueryString(url, params);
        if (DEBUG) {
            Log.d(TAG, "++++++++++++++++++++full url:" + fullUrl);
        }

        showLoading();
        client.get(url, params, new MyAsyncHttpResponseHandler(handler, 0));
    }

    public void add(String endPoint, final Map<String, String> entity, final ResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("asdf", "asdf");
        RequestParams params = new RequestParams();
        addEntityToParams(entity, params);
        client.addHeader("Content-Type", "application/x-www-form-urlencoded");
        String url = BASE_URL + endPoint;
        if (DEBUG) {
            Log.d(TAG, "++++++++++++++++++++url:" + url);
        }
        client.post(url, params, new MyAsyncHttpResponseHandler(handler, 0));
    }

    public void delete(String endPoint, final Map<String, String> entity, final ResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("asdf", "asdf");
        String etag = entity.get("etag");
        client.addHeader("If-Match", etag);
        String url = getUrl(endPoint);
        url = url + "/" + entity.get("_id");

        showLoading();
        client.delete(url, new MyAsyncHttpResponseHandler(handler, 0));
    }

    public void update(String endPoint, final Map<String, String> oldItem, final Map<String, String> entity, final ResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("asdf", "asdf");
        String etag = oldItem.get("etag");
        client.addHeader("If-Match", etag);
        client.addHeader("X-HTTP-Method-Override", "PATCH");
        String url = getUrl(endPoint);
        url = url + "/" + oldItem.get("_id");
        RequestParams params = new RequestParams();
        addEntityToParams(entity, params);

        showLoading();

        client.post(url, params, new MyAsyncHttpResponseHandler(handler, 0));
    }

    private void addEntityToParams(Map<String, String> entity, RequestParams params) {
        JSONObject jo = new JSONObject();
        try {
            for (String key : entity.keySet()) {
                if (!TextUtils.isEmpty(entity.get(key))) {
                    jo.put(key, entity.get(key));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        params.put("item1", jo.toString());
    }

    class MyAsyncHttpResponseHandler extends AsyncHttpResponseHandler {

        private ResponseHandler mMyHandler;

        public MyAsyncHttpResponseHandler(ResponseHandler handler, int i) {
            mMyHandler = handler;
        }

        @Override
        public void onSuccess(String response) {
            if (DEBUG) {
                Log.d(TAG, "++++++++++++++++++++response:" + response);
            }

            mMyHandler.onSuccess(response);
            dismissLoading();
        }

        @Override
        public void onFailure(Throwable e, String response) {
            if (DEBUG) {
                Log.d(TAG, "++++++++++++++++++++response failed:" + response);
            }
            Toast.makeText(mContext,
                "出错了，请重试", Toast.LENGTH_LONG).show();
            dismissLoading();
        }
    };

    public static class ResponseHandler {

        public void onSuccess(String result) {
        }

        public void onFinish() {
        }
    }

    private void putParams(RequestParams params, Map<String, String> map) {
        if (map == null) {
            return;
        }

        for (String key : map.keySet()) {
            params.put(key, map.get(key));
        }
    }

    public static String getUrl(String end) {
        String url = BASE_URL + end;
        if (DEBUG) {
            Log.d(TAG, "++++++++++++++++++++url:" + url);
        }
        return url;
    }

    public void showLoading() {
        mLoadingDialog = new ProgressDialog(mContext);
        mLoadingDialog.setMessage("加载中");
        mLoadingDialog.setIndeterminate(true);
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.show();
    }

    public void dismissLoading() {
        try {
            if (mLoadingDialog != null) {
                mLoadingDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}