/*
 * ViewUtils.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
 *
 * Distributed under terms of the MIT license.
 */
package me.biubiubiu.rms.util;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.content.res.*;
import android.app.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;

import java.util.*;
import org.json.*;


public class ViewUtils {

    public static <T> List<T> getTypeViews(ViewGroup root, Class<T> cls) {
        return getTypeViews(root, cls, null);
    }

    public static <T> List<T> getTypeViews(ViewGroup root, Class<T> cls, String key) {
        List<T> list = new ArrayList<T>();
        getTypeViews(list, root, cls, key);
        return list;
    }

    public static <T> void getTypeViews(List<T> views, ViewGroup root, Class<T> cls, String key) {

        Resources res = root.getContext().getResources();

        if (root.getChildCount() == 0) {
            return;
        } 

        for (int i = 0; i < root.getChildCount(); i ++) {
            View child = root.getChildAt(i);
            if (cls.isInstance(child)) {
                if (key == null || key.equals(getKey(child))) {
                    views.add((T)child);
                }
            }

            if (child instanceof ViewGroup) {
                getTypeViews(views, (ViewGroup)child, cls, key);
            }
        }
    }

    public static String getKey(View view) {
        Resources res = view.getContext().getResources();
        return res.getResourceEntryName(view.getId());
    }
}


