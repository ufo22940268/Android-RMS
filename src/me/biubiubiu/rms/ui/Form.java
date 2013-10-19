/*
 * Form.java
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
import java.text.*;

import org.json.*;

import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;

public class Form extends TableLayout {

    private TextView mTimeView;

    public Form(Context context, AttributeSet attr) {
        super(context, attr);
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
        if (getContext() instanceof ImportActivity) {
            snumView.setText(generateSn("IMPORT"));
        }
    }

    private String generateSn(String prefix) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);
        String ft = sdf.format(cal.getTime());
        return prefix + "_NS" + ft;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, int monthOfYear,
                        int dayOfMonth) {
                    //mYear = year;
                    //mMonth = monthOfYear;
                    //mDay = dayOfMonth;
                    //updateDisplay();
                }
            };
}
