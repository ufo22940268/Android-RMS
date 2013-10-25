/*
 * CheckListAdapter.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
 *
 * Distributed under terms of the MIT license.
 */

package me.biubiubiu.rms.ui;

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
import java.text.*;

import org.json.*;

import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;
import me.biubiubiu.rms.R;

public class CheckListAdapter extends PageListAdapter {

    private Map<Integer, Boolean> checkMap = new HashMap<Integer, Boolean>();

    public CheckListAdapter(Context context, int layout) {
        super(context, layout);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        CheckBox cb = (CheckBox)view.findViewById(R.id.check_box);
        cb.setVisibility(View.VISIBLE);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkMap.put(position, isChecked);
            }
        });

        Boolean b = checkMap.get(position);
        if (b == null || b == false) {
            cb.setChecked(false);
        } else {
            cb.setChecked(true);
        }

        return view;
    }

    public void checkAll() {
        for (int i = 0; i < getCount(); i ++) {
            checkMap.put(i, true);
        }

        notifyDataSetChanged();
    }

    public void uncheckAll() {
        for (int i = 0; i < getCount(); i ++) {
            checkMap.put(i, false);
        }

        notifyDataSetChanged();
    }

    public Integer[] getCheckedPositions() {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer key : checkMap.keySet()) {
            if (checkMap.get(key)) {
                list.add(key);
            }
        }
        return list.toArray(new Integer[]{});
    }
}
