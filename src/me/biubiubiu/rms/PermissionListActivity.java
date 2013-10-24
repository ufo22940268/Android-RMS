/*
 * SetupPermissionActivity.java
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

public class PermissionListActivity extends BaseActivity implements AdapterView.OnItemClickListener  {

    private ListView mListView;
    private ArrayAdapter mAdapter;
    private Map<String, String> mEndMap;
    private String mUserId;
    private String mEndPoint;
    private String mEtag;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);

        mUserId = "5268804bacef1825fedd5f16";
        mEndPoint = "operator";
        mEtag = "001cc4fb83ed19f441efbff97609531917c77dab";

        setContentView(R.layout.list);
        mListView = (ListView)findViewById(R.id.list);
        mEndMap = mEndPoints.getPermissions();
        mAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mEndMap.values().toArray());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int pos, long id) {
        Intent intent = new Intent(this, SetupPermissionActivity.class);                                
        intent.putExtra("user_id", mUserId);
        intent.putExtra("end_point", mEndPoint);
        String text = ((TextView)view).getText().toString();
        intent.putExtra("action", getAction(text));
        intent.putExtra("etag", mEtag);
        startActivity(intent);
    }

    private String getAction(String value) {
        for (String key : mEndMap.keySet()) {
            if (mEndMap.get(key).equals(value)) {
                return key;
            }
        }

        return null;
    }
}
