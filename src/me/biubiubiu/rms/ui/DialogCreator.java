/*
 * DialogCreator.java
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
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.content.res.TypedArray;

import java.util.*;
import java.text.*;

import org.json.*;

import android.support.v4.app.Fragment;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.model.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;
import org.apache.commons.lang3.time.DateFormatUtils; 

public class DialogCreator {

    private Context mContext;
    private String mEnd;
    private EntityView mEv;

    public DialogCreator(Context context, String end, EntityView ev) {
        mContext = context;
        mEnd     = end;
        mEv      = ev;
    }

    public EntryDialog createDialog(String type) {
        EntityMap map  = EntityMapUtil.getMap(type);
        if (map != null) {
            SimpleMapDialog smd =  new SimpleMapDialog(mContext, mEnd, mEv);
            smd.init(map);
            return smd;
        } else {
            return new CustomDialog(mContext, mEnd, mEv);
        }
    }
}


