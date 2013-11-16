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
import me.biubiubiu.rms.R;
import me.biubiubiu.rms.ui.*;


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

    public static void setEmptyView(Context context, ListView listView, int layout) {
        View empty = LayoutInflater.from(context).inflate(
                layout, listView, false);
        empty.setVisibility(View.GONE);
        ((ViewGroup)listView.getParent()).addView(empty);
        listView.setEmptyView(empty);
    }

    public static String getFormValue(View view) {
        if (view == null) {
            return null;
        }

        if (view instanceof TextView) {
            return ((TextView)view).getText().toString();
        } else {
            return null;
        }
    }

    public static int getLayoutRes(String name) {
        R.layout ft = new R.layout();    
        try {
            return (Integer)ft.getClass().getField(name).get(ft);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Resouce name not founded.");
        }
    }

    public static Map<String, String> collectForm(ViewGroup parent) {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < parent.getChildCount(); i ++) {
            ViewGroup row = (ViewGroup)parent.getChildAt(i);
            if (row.getChildCount() >= 2) {
                View field = row.getChildAt(1);
                if (field instanceof EntityView) {
                    map.put(ViewUtils.getKey(field), ((EntityView)field).getValue());
                } else if (field instanceof TextView) {
                    String value = ((TextView)field).getText().toString();
                    map.put(ViewUtils.getKey(field), value);
                } else if (field instanceof Spinner) {
                    //TODO 
                }
            }
        }

        return map;
    }
}
