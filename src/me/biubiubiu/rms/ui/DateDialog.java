/*
 * DateDialog.java
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
import android.text.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;

import java.util.*;
import java.text.*;

import me.biubiubiu.rms.R;

public class DateDialog extends Dialog {
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;

    private TextView mDateView;

    public DateDialog(Context context, TextView view) {
        super(context);

        mDateView = view;

        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup parent = (ViewGroup)inflater.inflate(R.layout.date_and_time, null);

        final Calendar today = Calendar.getInstance();
        DatePicker dateView = new DatePicker(getContext());
        dateView.init(today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH),
                mDateSetListener);
        dateView.setCalendarViewShown(false);
        parent.addView(dateView);
        parent.addView(new TimePicker(getContext()));

        setContentView(parent);
    }

    private DatePicker.OnDateChangedListener mDateSetListener =
        new DatePicker.OnDateChangedListener() {

            public void onDateChanged(DatePicker view, int year, int monthOfYear,
                    int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                updateDisplay();
            }
        };

    private TimePicker.OnTimeChangedListener mTimeSetListener =
        new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                updateDisplay();
            }
        };

    private void updateDisplay() {
        Calendar cal = Calendar.getInstance();
        cal.set(mYear, mMonth, mDay, mHour, mMinute);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String ft = sdf.format(cal.getTime());
        mDateView.setText(ft);
    }
}
