/*
 * CheckListFragment.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
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
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.util.ReceiverManager.OnReceiveListener;

public class CheckListFragment extends BaseFragment {

    static public final String[] MORE_TITLES = {
        "全选",
        "全部取消",
        "反选",
        "完成审核",
    };

    private ListView mListView;
    public CheckListAdapter mAdapter;
    private PageList mPageList;
    private String mEndPoint;
    private int mItemLayout;
    private String mWhere;
    private Class mCustomDetail;

    public CheckListFragment(String endPoint, int itemLayout) {
        mEndPoint = endPoint;
        mItemLayout = itemLayout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPageList = new PageList(getActivity(), mEndPoint);
        if (mAdapter == null) {
            mAdapter = new CheckListAdapter(getActivity(), mItemLayout, getProjection());
            mPageList.setAdapter(mAdapter);
        } else {
            mPageList.setAdapter(mAdapter);
        }
        mListView = mPageList.getListView();
        mPageList.load();
        mReceiverManager.registerReceiver(mEndPoint);
        mReceiverManager.setOnReceiveListener(new OnReceiveListener() {
            @Override
            public void onReceive(Intent intent) {
                mPageList.load();
            }
        });
        return mPageList;
    }

    public Map<String, Map<String, String>> getProjection() {
        return null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.check_all:
                mAdapter.checkAll();
                break;

            case R.id.uncheck_all:
                mAdapter.uncheckAll();
                break;

            case R.id.refresh:
                refresh();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void refresh() {
        if (mPageList != null) {
            mPageList.load();
        }
    }

    protected List<Map<String, String>> getDataList() {
        return mPageList.mDataList;
    }
}
