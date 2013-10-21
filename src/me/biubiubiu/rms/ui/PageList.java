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

public class PageList extends FrameLayout implements AdapterView.OnItemLongClickListener, View.OnClickListener, AdapterView.OnItemClickListener {

    private String mEndPoint;
    private int mItemLayout;
    private ListView mListView;
    private MyAdapter mAdapter;
    private int mPage = 1;
    private TextView mPageView;

    public PageList(Context context, AttributeSet attr) {
        super(context, attr);
        mAdapter = new MyAdapter();
    }

    public void condition(String endPoint, int itemLayout) {
        mEndPoint   = endPoint;
        mItemLayout = itemLayout;
        load();
    }

    public void load() {
        new HttpHandler(getContext()).get(mEndPoint, mPage,  new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                List<Map<String, String>> list = Parser.items(result);
                if (list.size() > 0) {
                    mAdapter.setList(Parser.items(result));
                    mAdapter.notifyDataSetChanged();
                    updatePage();
                } else {
                    // No more pages.
                    if (mPage > 1) {
                        mPage -= 1;
                        Toast.makeText(getContext(),
                            "已经最后一页了", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public ListView getListView() {
        return mListView;
    }

    @Override
    public void onItemClick(AdapterView parent, View view, final int pos, long id) {
        Map<String, String> item = mAdapter.getEntry(pos);
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("end_point", mEndPoint);
        intent.putExtra("_id", item.get("_id"));

        intent.putExtra("layout", ViewUtils.getLayoutRes(mEndPoint + "_detail"));
        
        ((Activity)getContext()).startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView parent, View view, final int pos, long id) {
        new AlertDialog.Builder(getContext())
            .setTitle("操作")
            .setItems(new String[]{"删除"}, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    new HttpHandler(getContext()).delete("import", mAdapter.getEntry(pos), new ResponseHandler() {
                        public void onSuccess(String result) {
                        }
                    });

                    mAdapter.remove(pos);
                    mAdapter.notifyDataSetChanged();
                }
            })
        .show();
        return true;
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.page_list, this);
        mListView = (ListView)findViewById(R.id.list);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemLongClickListener(this);
        mListView.setOnItemClickListener(this);
        findViewById(R.id.prev).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);
        mPageView = (TextView)findViewById(R.id.page);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                mPage += 1;
                load();
                break;
            
            case R.id.prev:
                if (mPage - 1 <= 0) {
                    break;
                } else {
                    mPage -= 1;
                    load();
                }
                break;
            
        }
    }

    private void updatePage() {
        mPageView.setText("页码:" + mPage);
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

        public void remove(int pos) {
            mList.remove(pos);
        }

        private Map<String, String> getEntry(int pos) {
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


