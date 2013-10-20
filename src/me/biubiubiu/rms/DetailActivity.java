/*
 * DetailActivity.java
 * Copyright (C) 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
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
import java.lang.reflect.*;
import org.json.*;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;


public class DetailActivity extends ItemBaseActivity  {

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.detail_activity);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        mEndPoint = extra.getString("end_point");
        mId = extra.getString("_id");

        loadById(mEndPoint, mId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.edit) {
            if (!isLoaded()) {
                return true;
            }

            Intent intent = new Intent(this, EditActivity.class);
            intent.putExtra("end_point", mEndPoint);
            intent.putExtra("_id", mItemMap.get("_id"));
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
