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

public class EntityView extends TextView {

    private String mValue;

    public EntityView(Context context) {
        super(context);
    }

    public EntityView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public void setLabel(String s) {
        setText(s);
    }

    public void setValue(String v) {
        mValue = v;
    }

    public String getValue() {
        return mValue;
    }
}
