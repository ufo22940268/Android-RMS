/*
 * ItemBaseActivity.java
 * Copyright (C) 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
package me.biubiubiu.rms;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.content.res.*;
import android.app.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;

import java.util.*;
import org.json.*;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import com.andreabaccega.widget.FormEditText;

import java.util.*;
import java.lang.reflect.*;
import org.json.*;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;

public class ItemBaseActivity extends BaseActivity {

    protected Map<String, String> mItemMap;
    protected Map<Integer, String> mLoadedMap;
    protected String mId;
    protected String mEndPoint;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        mEndPoint = extra.getString("end_point");
        mId = extra.getString("_id");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadById(mEndPoint, mId);
    }

    protected void loadById(String endPoint, String _id) {
        new HttpHandler(this).get(endPoint, 1,  new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                List<Map<String, String>> list = Parser.items(result);
                if (list != null && list.size() > 0) {
                    Map<String, String> item = list.get(0);
                    mItemMap = item;
                    String[] keys = item.keySet().toArray(new String[]{});
                    int[] resIds = getResIds(keys);
                    mLoadedMap = getLoadedMap(keys, resIds);
                    for (int i = 0; i < keys.length; i ++) {
                        int id = resIds[i];
                        String value = item.get(keys[i]);
                        View view = findViewById(id);
                        if (view != null && view instanceof TextView) {
                            //TODO Extract as a method and put it into ViewUtils.
                            if (view instanceof MapEntityView) {
                                ((MapEntityView)view).setLabelFromRemote(value);
                            } else {
                                ((TextView)view).setText(value);
                            }
                        }
                    }
                }
            }
        });
    }

    protected boolean isLoaded() {
        return mItemMap != null;
    }

    private Map<Integer, String> getLoadedMap(String[] keys, int[] ids) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < keys.length; i ++) {
            if (ids[i] != -1) {
                map.put(ids[i], keys[i]);
            }
        }
        return map;
    }

    protected int[] getResIds(String[] keys) {
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
