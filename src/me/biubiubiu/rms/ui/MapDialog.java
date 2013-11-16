/*
 * MapDialog.java
 * Copyright (C) 2013 garlic <garlic@localhost>
 *
 * Distributed under terms of the MIT license.
 */
package me.biubiubiu.rms.ui;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.app.*;
import android.app.AlertDialog.Builder;
import android.os.*;
import android.text.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import me.biubiubiu.rms.R;

public abstract class MapDialog {

    private String mEndPoint;
    private Builder mBuilder;
    private AlertDialog mDialog;
    private EntityView mEntityView;
    private Context mContext;
    private final List<String> items = new ArrayList<String>();
    protected HashMap<String, String> mMap;

    public MapDialog(Context context, String end, EntityView ev) {
        mContext = context;
        mBuilder = new Builder(context);
        
        mEndPoint = end;
        mEntityView = ev;
    }

    public void show() {
        if (mMap == null) {
            throw new RuntimeException("Do you have set map?");
        }

        final List<String> list = new ArrayList<String>(mMap.keySet());
        items.addAll(list);
        mBuilder.setItems(items.toArray(new String[]{}), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String k = list.get(which);
                String v = mMap.get(k);
                setValue(k, v);
            }
        });
        mDialog = mBuilder.show();
    }

    public void setValue(String label, String value) {
        mEntityView.setLabel(label);
        mEntityView.setValue(value);
    }
}
