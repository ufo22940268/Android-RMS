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

import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;

public class SetupPermissionActivity extends BaseActivity  {
    
    private String mUserId;
    private String mEndPoint;
    private String mEtag;
    private String mAction;
    private ListView mListView;
    private String[] LABELS = {
        "查看",
        "添加",
        "删除",
        "审核",
    };

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        mUserId = getIntent().getExtras().getString("user_id");
        mEndPoint = getIntent().getExtras().getString("end_point");
        mEtag = getIntent().getExtras().getString("etag");
        mAction = getIntent().getExtras().getString("action");
        setContentView(R.layout.list);

        mListView = (ListView)findViewById(R.id.list);
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, LABELS));
        mListView.setItemsCanFocus(false);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            Map<String, String> params = new HashMap<String, String>();
            params.put("etag", mEtag);
            params.put("_id", mUserId);

            Map<String, String> updates = new HashMap<String, String>();
            updates.put(mAction + "_permission",  String.valueOf(getPermissionValue()));
            
            mHttp.update(mEndPoint, params, updates, new ResponseHandler() {
                @Override
                public void onSuccess(String result) {
                    Toast.makeText(SetupPermissionActivity.this,
                        "更新成功", Toast.LENGTH_LONG).show();
                    finish();
                }
            });
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private int getPermissionValue() {
        SparseBooleanArray arr = mListView.getCheckedItemPositions();
        int v = 0;        
        for (int i = 0; i < arr.size(); i ++) {
            if (arr.get(i)) {
                v += 1;
            }
            v *= 10;
        }
        return v;
    }
}
