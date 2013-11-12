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

public class RecordListFragment extends PageListFragment implements AdapterView.OnItemClickListener {

    public RecordListFragment() {
    }

    public RecordListFragment(String endPoint, int itemLayout) {
        super(endPoint, itemLayout);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPageList.getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int pos, long id) {
        Map<String, String> item = getAdapter().getEntry(pos);
        Intent intent = new Intent(getActivity(), AudioRecordDetailActivity.class);
        intent.putExtra("end_point", mEndPoint);
        intent.putExtra("_id", item.get("_id"));
        intent.putExtra("layout", ViewUtils.getLayoutRes(mEndPoint + "_detail"));
        getActivity().startActivity(intent);
    }
}

