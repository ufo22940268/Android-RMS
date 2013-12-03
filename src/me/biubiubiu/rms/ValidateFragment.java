/*
 * ValidateFragment.java
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
import me.biubiubiu.rms.*;
import me.biubiubiu.rms.util.*;
import com.loopj.android.http.*;

public class ValidateFragment extends CheckListFragment {

    public ValidateFragment(String endPoint, int itemLayout) {
        super(endPoint, itemLayout);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.validate_check_list, menu);
    }

    public PageList getPageList() {
        return mPageList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                CheckListAdapter adapter = (CheckListAdapter)mAdapter;
                Integer[] poses = adapter.getCheckedPositions();
                if (poses.length == 0) {
                    Toast.makeText(getActivity(),
                        "请先选择", Toast.LENGTH_LONG).show();
                    break;
                }

                String[] ids = new String[poses.length];
                for (int i = 0; i < poses.length; i ++) {
                    ids[i] = getDataList().get(poses[i]).get("_id");
                }

                validate(ids);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void validate(String[] ids) {
        JSONArray ja = new JSONArray();
        for (String id : ids) {
            ja.put(id);
        }
        RequestParams params = new RequestParams(); 
        params.put("ids", ja.toString());
        mHttp.post("validate_import", params);
    }
}
