/*
 * BaseActivity.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
 *
 * Distributed under terms of the MIT license.
 */

package me.biubiubiu.rms;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.content.res.*;
import android.app.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.view.inputmethod.*;

import java.util.*;
import org.json.*;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import com.andreabaccega.widget.FormEditText;

import java.util.*;
import java.lang.reflect.*;
import org.json.*;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.model.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;
import com.kanak.emptylayout.EmptyLayout;

public class BaseActivity extends ActionBarActivity {

    protected Resources mRes;
    protected HttpHandler mHttp;
    protected EndPoints mEndPoints;
    private EmptyLayout mEmptyLayout;
    protected PermissionManager mPermissionManager;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRes = getResources();
        mHttp = new HttpHandler(this);
        mEndPoints = new EndPoints();
        mPermissionManager = PermissionManager.newInstance(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            try {
                actionBar.setDisplayHomeAsUpEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void startActivity(Intent intent, String end, int pos) {
        if (mPermissionManager.checkPermission(end, pos)) {
            Toast.makeText(this,
                    "没有权限", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void addContainerFragment(Fragment frag) {
        getSupportFragmentManager()
            .beginTransaction().add(R.id.container, frag).commit();
    }

    protected void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void setProductSnum(String s) {
        View view = findViewById(R.id.product_snum);
        if (view != null) {
            ((TextView)view).setText(s);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken() , 0);
    }
}
