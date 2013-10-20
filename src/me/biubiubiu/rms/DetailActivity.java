/*
 * DetailActivity.java
 * Copyright (C) 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
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
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;

import java.util.*;
import java.lang.reflect.*;
import org.json.*;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;


public class DetailActivity extends BaseActivity  {

    private String mId;
    private String mEndPoint;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.detail_activity);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        //mEndPoint = extra.getString("end_point");
        //mId = extra.getString("_id");
        mEndPoint = "import";
        mId = "5263425330bc220bf31c34e2";

        load();
    }

    private void load() {
        new HttpHandler(this).get(mEndPoint, 1,  new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                List<Map<String, String>> list = Parser.items(result);
                if (list != null && list.size() > 0) {
                    Map<String, String> item = list.get(0);
                    String[] keys = item.keySet().toArray(new String[]{});
                    int[] resIds = getResIds(keys);
                    for (int i = 0; i < keys.length; i ++) {
                        int id = resIds[i];
                        String value = item.get(keys[i]);
                        System.out.println("++++++++++++++++++++key:" + keys[i] + "++++++++++++++++++++");
                        System.out.println("++++++++++++++++++++value:" + value + "++++++++++++++++++++");
                        View view = findViewById(id);
                        if (view != null) {
                            ((TextView)view).setText(value);
                        }
                    }
                }
            }
        });
    }

    private int[] getResIds(String[] keys) {
        try {
            int[] ids = new int[keys.length];
            R.id ft = new R.id();
            int i = 0;
            for (String key : keys) {
                Field f = null;
                try {
                    f =ft.getClass().getField(key);
                } catch (Exception e) {
                }

                if (f == null) {
                    ids[i] = -1;
                } else {
                    int res = (Integer)f.get(ft);
                    ids[i] = res;
                }
                i += 1;
            }

            return ids;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
