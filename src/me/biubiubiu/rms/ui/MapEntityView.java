/*
 * YesOrNoEntityView.java
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
import me.biubiubiu.rms.R;
import me.biubiubiu.rms.model.*;
import android.content.res.TypedArray;

import java.util.*;

public class MapEntityView extends EntityView {

    protected EntityMap mMap;

    public MapEntityView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public void setLabelFromRemote(String t) {
        if (mMap == null) {
            throw new RuntimeException("Do you initial map?");
        }

        setValueAndText(t);
    }

    /*
     *Store the value to view and get label from map
     *and display this view with the received label.
     */
    private void setValueAndText(String v) {
        setValue(v);
        setLabel(mMap.getLabel(v));
    }
}


