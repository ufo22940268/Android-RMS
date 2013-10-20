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

public class RepoListFragment extends BaseFragment {

    private ListView mListView;
    private ArrayAdapter mAdapter;
    private PageList mPageList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup parent = (ViewGroup)inflater.inflate(R.layout.repo_status_fragment, container, false);
        mPageList = (PageList)parent.findViewById(R.id.page_list);
        mPageList.condition("import", R.layout.list_item_repo_status);
        mListView = mPageList.getListView();
        return parent;
    }

    private ListView getListView() {
        return mListView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity().getActionBar().setSubtitle("Long press to start selection");
    }
}

