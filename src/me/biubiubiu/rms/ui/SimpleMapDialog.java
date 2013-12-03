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
import me.biubiubiu.rms.model.*;

public class SimpleMapDialog extends MapDialog {

    public SimpleMapDialog(Context context, String end, EntityView ev) {
        super(context, end, ev);
    }

    public void init(EntityMap em) {
        mMap = em.getMap();
    }
}
