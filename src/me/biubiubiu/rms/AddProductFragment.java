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

import android.support.v4.app.Fragment;

public class AddProductFragment extends BaseFragment {

    private ViewGroup mContainer;
    private String[] TITLE_CATEGORY_1 = {
        "入库单号",
        "入库日期",
        "入库类型",
        "采购人员",
        "操作人员",
        "供应单位",
        "产品编号",
        "产品名称",
        "颜色",
        "属性",
        "备注",
    };

    private String[] TITLE_CATEGORY_2 = {
        "单位",
        "数量",
    };

    public AddProductFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        ViewGroup parent = (ViewGroup)inflater.inflate(R.layout.add_product_fragment, container, false);
        //mContainer = (ViewGroup)parent.findViewById(R.id.container);
        //for (String title : TITLE_CATEGORY_1) {
            //View view = inflater.inflate(R.layout.item_import_category_1, container, false);
            //((TextView)view.findViewById(R.id.label)).setText(title);
            //mContainer.addView(view);
        //}

        //TextView tv = (TextView)inflater.inflate(R.layout.label_text, container, false);
        //tv.setText("入库状态显示栏");
        //mContainer.addView(tv);

        //for (String title : TITLE_CATEGORY_2) {
            //View view = inflater.inflate(R.layout.item_import_category_1, container, false);
            //((TextView)view.findViewById(R.id.label)).setText(title);
            //mContainer.addView(view);
        //}
        
        return parent;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
