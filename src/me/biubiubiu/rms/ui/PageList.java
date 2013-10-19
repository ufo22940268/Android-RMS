/*
 * PageList.java
 * Copyright (C) 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
package me.biubiubiu.rms.ui;

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
import java.text.*;

import org.json.*;

import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;

public class PageList extends FrameLayout {

    private String mEndPoint;
    private int mItemLayout;
    private ListView mListView;
    private MyAdapter mAdapter;

    public PageList(Context context, AttributeSet attr) {
        super(context, attr);
        mAdapter = new MyAdapter();
    }

    public void condition(String endPoint, int itemLayout) {
        mEndPoint   = endPoint;
        mItemLayout = itemLayout;
        start();
    }

    private void start() {
        new HttpHandler(getContext()).get(mEndPoint, new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                mAdapter.setList(Parser.items(result));
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.page_list, this);
        mListView = (ListView)findViewById(R.id.list);
        mListView.setAdapter(mAdapter);
        ViewUtils.setEmptyView(getContext(), mListView, R.layout.empty_progress);

    }

    public class MyAdapter extends BaseAdapter {

        private List<Map<String, String>> mList;

        private void setList(List<Map<String, String>> list) {
            mList = list;
        }

        public int getCount() {
            if (mList == null) {
                return 0;
            } else {
                return mList.size();
            }
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
                view = LayoutInflater.from(getContext()).inflate(mItemLayout, parent, false);
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
}


