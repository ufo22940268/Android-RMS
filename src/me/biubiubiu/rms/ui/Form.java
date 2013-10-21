/*
 * Form.java
 * Copyright (C) 2013 garlic <garlic@meishixing>
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

import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;

public class Form extends TableLayout {

    private TextView mTimeView;
    private String mEndPoint;

    public Form(Context context, AttributeSet attr) {
        super(context, attr);
		TypedArray typedArray = context.obtainStyledAttributes(attr, R.styleable.Form);
		mEndPoint = typedArray.getString(R.styleable.Form_endPoint);
        System.out.println("++++++++++++++++++++mEndPoint:" + mEndPoint + "++++++++++++++++++++");
		typedArray.recycle();
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        autoInit();
    }

    private void autoInit() {
        final Calendar today = Calendar.getInstance();
        mTimeView= (TextView)findViewById(R.id.time);
        mTimeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new DateDialog(getContext(), (TextView)view);
                dialog.show();
            }
        });

        //Init snum.
        TextView snumView = (TextView)findViewById(R.id.snum);
        snumView.setText(generateSn(mEndPoint.toUpperCase()));
    }

    public String getEndPoint() {
        return mEndPoint;
    }

    private String generateSn(String prefix) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);
        String ft = sdf.format(cal.getTime());
        return prefix + "_NS" + ft;
    }

    public Map<String, String> collect() {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < getChildCount(); i ++) {
            ViewGroup row = (ViewGroup)getChildAt(i);
            if (row.getChildCount() >= 2) {
                View field = row.getChildAt(1);
                if (field instanceof TextView) {
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
