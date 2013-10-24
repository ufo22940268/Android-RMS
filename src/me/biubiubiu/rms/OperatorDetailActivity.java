/*
 * OperatorDetailActivity.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
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
import android.graphics.*;
import android.view.animation.*;

import java.util.*;
import org.json.*;

public class OperatorDetailActivity extends DetailActivity  {

    public void setupPermission(View v) {
        Intent intent = new Intent(this, PermissionListActivity.class); 
        startActivity(intent);
    }
}
