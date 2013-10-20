/*
 * EditActivity.java
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
import org.json.*;
import java.util.*;
import java.lang.reflect.*;
import org.json.*;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;


public class EditActivity extends ItemBaseActivity  {

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.add_product_fragment);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        //mEndPoint = extra.getString("end_point");
        //mId = extra.getString("_id");
        String mEndPoint = "import";
        String mId = "5263425330bc220bf31c34e2";

        loadById(mEndPoint, mId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (!isLoaded()) {
            return false;
        }

        new HttpHandler(this).update("import", mItemMap, collectItem(), new ResponseHandler() {
            public void onSuccess(String result) {
                finish();
            }
        });
        return true;
    }
}
