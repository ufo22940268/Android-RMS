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


public class AddActivity extends BaseActivity  {

    protected String mEndPoint;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        mEndPoint = extra.getString("end_point");
        setContentView(R.layout.container);
        int layout = ViewUtils.getLayoutRes("update_" + mEndPoint + "_fragment");
        AddFragment frag = new AddFragment(layout, false);
        addContainerFragment(frag);
        
        String title = mEndPoints.getTitle(mEndPoint);
        setActionBarTitle("添加" + title);
    }
}
