/*
 * PageListAdapter.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
 *
 * Distributed under terms of the MIT license.
 */

package me.biubiubiu.rms.ui;

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
import java.text.*;

import org.json.*;

import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;
import me.biubiubiu.rms.R;

public class PageListAdapter extends BaseAdapter implements CleanableAdapter {

    private List<Map<String, String>> mList = new ArrayList<Map<String, String>>();
    private int mItemLayout;
    private Context mContext;

    //The key of this projection is the entity key, and value map
    //is the dict display name and actual value.
    private Map<String, Map<String, String>> mProjection;

    public PageListAdapter(Context context, int layout) {
        mItemLayout = layout;
        mContext = context;
    }

    public PageListAdapter(Context context, int layout, Map<String, Map<String, String>> projection) {
        mItemLayout = layout;
        mContext = context;
        mProjection = projection;
    }

    public void setList(List<Map<String, String>> list) {
        mList = list;
    }

    public int getCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    public void clean() {
        mList = new ArrayList<Map<String, String>>();
        notifyDataSetChanged();
    }

    public void remove(int pos) {
        mList.remove(pos);
    }

    public Map<String, String> getEntry(int pos) {
        return mList.get(pos);
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(mItemLayout, parent, false);
        }

        Map<String, String> map = mList.get(position);
        List<TextView> views = ViewUtils.getTypeViews((ViewGroup)view, TextView.class);
        for (TextView tv : views) {
            String key = ViewUtils.getKey(tv);
            if (map.containsKey(key)) {
                String value = map.get(key);
                if (mProjection == null || mProjection.get(key) == null) {
                    tv.setText(value);
                } else {
                    String rValue = mProjection.get(key).get(value);
                    if (rValue != null) {
                        tv.setText(rValue);
                    } else {
                        tv.setText(value);
                    }
                }
            }
        }

        return view;
    }
}

