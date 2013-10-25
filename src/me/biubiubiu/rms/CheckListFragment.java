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

public class CheckListFragment extends BaseFragment {

    static public final String[] MORE_TITLES = {
        "全选",
        "全部取消",
        "反选",
        "完成审核",
    };

    private ListView mListView;
    private ArrayAdapter mAdapter;
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
        ViewGroup parent = (ViewGroup)inflater.inflate(R.layout.check_list_fragment, container, false);
        mPageList = (PageList)parent.findViewById(R.id.page_list);
        mPageList.condition(mEndPoint, mItemLayout, null);
        mPageList.disableClick();
        mListView = mPageList.getListView();
        return parent;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.check_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.more:
                View anchor = item.getAnchorView(); 
                ListPopupWindow popup = new ListPopupWindow(getActivity());
                popupsetAnchorView(anchor);

                ArrayAdapter  adapter = new ArrayAdapter(getActivity(),
                        android.R.layout.simple_list_item_1,
                        MORE_TITLES;
                popup.setAdapter(adapter);
                show();
                break;
        }
    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        //if (item.getItemId() == R.id.refresh) {
            //if (mPageList != null) {
                //mPageList.load();
            //}
            //return true;
        //} else {
            //return super.onOptionsItemSelected(item);
        //}
    //}

}

