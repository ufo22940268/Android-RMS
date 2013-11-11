/*
 * TypeDialog.java
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

import java.util.*;

import me.biubiubiu.rms.R;

public class TypeDialog {

    private String mEndPoint;
    private Builder mBuilder;
    private AlertDialog mDialog;
    private EntityView mEntityView;
    private Context mContext;

    public TypeDialog(Context context, String end, EntityView ev) {
        mContext = context;
        mBuilder = new Builder(context);
        
        mEndPoint = end;
        mEntityView = ev;


        final List<String> items = new ArrayList<String>();
        items.add("自定义");
        mBuilder.setItems(items.toArray(new String[]{}), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which == items.size() - 1) {
                    if (mDialog != null) {
                        mDialog.dismiss();
                    }
                    showCustomDialog();
                } else {
                    String v = items.get(which);
                    setValue(v, v);
                }
            }
        });
    }

    private SharedPreferences getPref() {
        return getSharedPreferences(mEndPoint, 0);
    }


    private String readPref() {
        return getPref().getString();
    }

    private void addPref() {
        String raw = readPref();
        String[] oa = raw.spilit(raw, ",");
        String[] na = new String[oa.length + 1];
        System.arraycopy(oa, 0, na, 0, oa.length);
        return getPref().getString();
    }

    public void addType(String type) {
        addPref(type);
    }

    private void showCustomDialog() {
        LayoutInflater factory = LayoutInflater.from(mContext);
        final View textEntryView = factory.inflate(R.layout.alert_dialog_text_entry, null);
        final TextView field = (TextView)textEntryView.findViewById(R.id.value);
        new AlertDialog.Builder(mContext)
            .setTitle("输入自定义类型")
            .setView(textEntryView)
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String v = field.getText().toString();
                    //mEntityView.setText(v);
                }
            })
        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                /* User clicked cancel so do some stuff */
            }
        })
        .show();
    }

    public void setValue(String label, String value) {
        mEntityView.setLabel(label);
        mEntityView.setValue(value);
    }

    public void show() {
        mDialog = mBuilder.show();
    }
}
