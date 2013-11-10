/*
 * OrderCheckFragment.java
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

public class OrderCheckFragment extends CheckListFragment {

    public OrderCheckFragment(String endPoint, int itemLayout) {
        super(endPoint, itemLayout);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.order_check_list, menu);
    }

    @Override
    public Map<String, Map<String, String>> getProjection() {
        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();

        Map<String, String> m = new HashMap<String, String>();
        m.put("1", "通过");
        m.put("0", "未通过");
        map.put("validated", m);

        m = new HashMap<String, String>();
        m.put("default", "默认");
        m.put("wait_for_buyer", "等待买家付款");
        m.put("buyer_paid", "买家已付款");
        m.put("seller_delivered", "卖家已发货");
        m.put("repo_delivered", "仓库已发货");
        m.put("refund", "已退款");
        m.put("buyer_returned", "卖家已退货");
        map.put("status", m);

        return map;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.validate:
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
                refresh();
                break;

            case R.id.add:
                Intent intent = new Intent(getActivity(), AddActivity.class);
                intent.putExtra("end_point", "order");
                startActivity(intent);
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
        mHttp.post("validate_order", params);
    }
}
