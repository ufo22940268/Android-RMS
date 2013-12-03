/*
 * EntityMap.java
 * Copyright (C) 2013 garlic <garlic@localhost>
 *
 * Distributed under terms of the MIT license.
 */


package me.biubiubiu.rms.model;

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
import me.biubiubiu.rms.R;
import android.content.res.TypedArray;

import java.util.*;

/*
 * This map is label and value pairs. The value is the data stored
 * in database and the label is used to display.
 */
public class EntityMap {

    protected HashMap<String, String> mMap = new HashMap<String, String>();

    public EntityMap() {
    }

    public void put(String label, String value) {
        mMap.put(label, value);
    }

    public HashMap<String, String> getMap() {
        return mMap;
    }

    public String getValue(String label) {
        return mMap.get(label);
    }

    public String getLabel(String value) {
        for (String mk : mMap.keySet()) {
            String mv = mMap.get(mk);
            if (mv.equals(value)) {
                return mk;
            }
        }

        throw new RuntimeException("Value can't be found in map");
    }
}


