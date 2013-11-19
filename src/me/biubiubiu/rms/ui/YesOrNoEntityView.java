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

public class YesOrNoEntityView extends MapEntityView {

    private EntityMap mMap;

    public YesOrNoEntityView(Context context, AttributeSet attr) {
        super(context, attr);
        mMap = new YesOrNoMap();
    }
}


