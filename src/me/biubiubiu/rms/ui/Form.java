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

import android.support.v4.app.Fragment;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.model.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;
import org.apache.commons.lang3.time.DateFormatUtils; 


public class Form extends TableLayout implements View.OnClickListener {

    static public final int[] TYPE_RES = {
        R.id.type,
    };

    private TextView mTimeView;
    private String mEndPoint;
    private boolean mInitData;
    private HttpHandler mHttp;

    public Form(Context context, AttributeSet attr) {
        super(context, attr);
		TypedArray typedArray = context.obtainStyledAttributes(attr, R.styleable.Form);
		mEndPoint = typedArray.getString(R.styleable.Form_endPoint);
		mInitData = typedArray.getBoolean(R.styleable.Form_initData, true);
		typedArray.recycle();
        mHttp = new HttpHandler(context);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        initViews();

        if (mInitData) {
            initData();
        }
    }

    private void initData() {
        final Calendar today = Calendar.getInstance();
        if (findViewById(R.id.time) != null) {
            mTimeView= (TextView)findViewById(R.id.time);
            mTimeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new DateDialog(getContext(), (TextView)view);
                    dialog.show();
                }
            });

            registerClick(R.id.operator);

            //String fd = DateFormatUtils.format(today, "yyyy-MM-dd HH:mm");
            //mTimeView.setText(fd);
        }

        for (int res : TYPE_RES) {
            registerTypeListener(res);
        }

        //TODO Refactor to make it satify to register
        //all kinds of MapDialog.
        registerMapListener(R.id.status);

        //Init snum.
        View v = findViewById(R.id.snum);
        if (v != null) {
            TextView snumView = (TextView)v;
            snumView.setText(generateSn(mEndPoint.toUpperCase()));
        }
    }

    private void registerTypeListener(int res) {
        final View v = findViewById(res);
        final String end = mEndPoint;
        if (v != null && v instanceof EntityView) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CustomDialog dialog = new CustomDialog(getContext(), end, (EntityView)v);
                    dialog.show();
                }
            });
            
        }
    }

    private void registerMapListener(int res) {
        final View v = findViewById(res);
        final String end = mEndPoint;
        if (v != null && v instanceof EntityView) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrderStatusDialog dialog = new OrderStatusDialog(getContext(), end, (EntityView)v);
                    dialog.show();
                }
            });
            
        }
    }

    private void initViews() {
        initProductSnum();
    }

    private void initProductSnum() {
        View view = findViewById(R.id.scan);
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    private void registerClick(int res) {
        View view = findViewById(res);
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    private void selectOperator(final View view) {
        mHttp.get_all_operator(new ResponseHandler() {
            public void onSuccess(String result) {
                List<Map<String, String>> dataList = Parser.items(result);
                final List<String> names = new ArrayList<String>();
                for (Map<String, String> item: dataList) {
                    names.add(item.get("name"));
                }

                if (names.size() == 0) {
                    return;
                }

                new AlertDialog.Builder(getContext())
            .setTitle("选择操作员")
            .setItems(names.toArray(new String[]{}), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    ((TextView)view).setText(names.get(which));
                }
            }).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.operator:
                selectOperator(view);
                break;
            case R.id.scan:
                Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
                ((Activity)getContext()).startActivityForResult(intent, Constants.REQUEST_SCAN);
                break;
        }
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
        return ViewUtils.collectForm(this);
    }

    public void setProductSnum(String s) {
        View view = findViewById(R.id.product_snum);
        if (view != null) {
            ((TextView)view).setText(s);
        }
    }
}
