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
import com.kanak.emptylayout.EmptyLayout;

public class PageList extends FrameLayout implements AdapterView.OnItemLongClickListener, View.OnClickListener, AdapterView.OnItemClickListener {

    public List<Map<String, String>> mDataList = new ArrayList<Map<String, String>>();
    private String mEndPoint;
    private ListView mListView;
    private PageListAdapter mAdapter;
    private int mPage = 1;
    private TextView mPageView;
    private String mWhere;
    private Class mCustomDetail;
    private boolean mDisableClick;
    private boolean mShowCheckBox;
    private EmptyLayout mEmptyLayout;

    public PageList(Context context, String endPoint) {
        super(context);
        mEndPoint = endPoint;
        LayoutInflater.from(getContext()).inflate(R.layout.page_list, this);
        mListView = (ListView)findViewById(R.id.list);
        mPageView = (TextView)findViewById(R.id.page);
        mEmptyLayout = new EmptyLayout(getContext(), mListView);

        initView();
    }

    //TODO Change the completed page list to using the new interface. That we need to load data by hand.
    public void setAdapter(PageListAdapter adapter) {
        mAdapter = adapter;
        getListView().setAdapter(mAdapter);
    }

    public void condition(String where) {
        condition(where, null);
    }

    public void condition(String where, Class customDetail) {
        mWhere = where;
        mCustomDetail = customDetail;
    }

    public void disableClick() {
        mDisableClick = true;
    }

    public void showCheckBox() {
         mShowCheckBox= true;
    }

    public void load() {
        if (mAdapter == null) {
            throw new RuntimeException("You haven't set adapter yet!");
        }

        clean();
        mEmptyLayout.showLoading();
        new HttpHandler(getContext()).getSearch(mEndPoint, mPage, mWhere,  new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                List<Map<String, String>> dataList = Parser.items(result);
                if (dataList.size() > 0) {
                    mAdapter.setList(dataList);
                    mDataList = dataList;
                } else {
                    // No more pages.
                    if (mPage > 1) {
                        mPage -= 1;
                        Toast.makeText(getContext(),
                            "已经最后一页了", Toast.LENGTH_LONG).show();

                        //Set original data list.
                        mAdapter.setList(mDataList);
                    }
                }

                mAdapter.notifyDataSetChanged();
                updatePage();
            }
        });
    }

    public ListView getListView() {
        return mListView;
    }

    @Override
    public void onItemClick(AdapterView parent, View view, final int pos, long id) {
        Map<String, String> item = mAdapter.getEntry(pos);
        Class detailAct = DetailActivity.class;
        if (mCustomDetail != null) {
            detailAct = mCustomDetail;
        }

        Intent intent = new Intent(getContext(), detailAct);
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

    private void initView() {
        if (!mDisableClick) {
            mListView.setOnItemLongClickListener(this);
            mListView.setOnItemClickListener(this);
        }

        findViewById(R.id.prev).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);
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

        if (mDataList.size() == 0) {
            mEmptyLayout.showEmpty();
        }
    }

    public void clean() {
        CleanableAdapter adapter = (CleanableAdapter)mListView.getAdapter();
        if (adapter == null) {
            throw new RuntimeException("You need set adapter first.");
        }

        adapter.clean();
    }
}
