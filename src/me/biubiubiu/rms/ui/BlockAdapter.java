/*
 * BlockAdapter.java
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
import org.json.*;

import android.support.v4.app.Fragment;


public class BlockAdapter extends BaseAdapter {
    
    private String[][] mTitles;
    private Context mContext;

    public BlockAdapter(Context context, String[][] titles) {
        mTitles = titles;
        mContext = context;
    }

    public int getCount() {
        return mTitles.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getBlock(mTitles[position][0], mTitles[position][1]);
    }

    private View getBlock(String major, String minor) {
        View item = LayoutInflater.from(
                mContext).inflate(R.layout.row_item_repo_manage, null, false);
        ((TextView)item.findViewById(R.id.major)).setText(major);
        ((TextView)item.findViewById(R.id.minor)).setText(minor);
        return item;
    }

}

