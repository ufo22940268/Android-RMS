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

public class PageListAdapter extends BaseAdapter {

    private List<Map<String, String>> mList;
    private int mItemLayout;
    private Context mContext;

    public PageListAdapter(Context context, int layout) {
        mItemLayout = layout;
        mContext = context;
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
                tv.setText(map.get(key));
            }
        }

        return view;
    }
}

