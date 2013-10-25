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

public class PageListFragment extends BaseFragment {

    private ListView mListView;
    private ArrayAdapter mAdapter;
    private PageList mPageList;
    private String mEndPoint;
    private int mItemLayout;
    private String mWhere;
    private Class mCustomDetail;

    public PageListFragment() {
    }

    public PageListFragment(String endPoint, int itemLayout) {
        mEndPoint = endPoint;
        mItemLayout = itemLayout;
    }

    public PageListFragment(String endPoint, int itemLayout, Class detailAct) {
        this(endPoint, itemLayout, null, detailAct);
    }

    public PageListFragment(String endPoint, int itemLayout, String where) {
        mEndPoint = endPoint;
        mItemLayout = itemLayout;
        mWhere = where;
    }

    public PageListFragment(String endPoint, int itemLayout, String where, Class detailAct) {
        mEndPoint = endPoint;
        mItemLayout = itemLayout;
        mWhere = where;
        mCustomDetail = detailAct;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup parent = (ViewGroup)inflater.inflate(R.layout.page_list_fragment, container, false);
        mPageList = (PageList)parent.findViewById(R.id.page_list);
        PageListAdapter adapter = new PageListAdapter(getActivity(), mItemLayout);
        mPageList.condition(mEndPoint, mWhere, mCustomDetail);
        mListView = mPageList.getListView();
        return parent;
    }

    private ListView getListView() {
        return mListView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.refresh, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            if (mPageList != null) {
                mPageList.load();
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}

