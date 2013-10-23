/*
 * AddOperatorActivity.java
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
import android.text.*;
import android.graphics.*;
import android.view.animation.*;

import java.util.*;
import org.json.*;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;

public class AddOperatorActivity extends AddActivity  {

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        ViewGroup parent = (ViewGroup)findViewById(R.id.container);
        Button btn = (Button)LayoutInflater.from(this).inflate(R.layout.big_button, parent, false);
        btn.setText("权限设置");
        parent.addView(btn);
    }
}
