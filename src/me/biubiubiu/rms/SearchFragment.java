package me.biubiubiu.rms;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.app.*;
import android.text.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;

import java.util.*;
import org.json.*;

import android.support.v4.app.Fragment;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.model.*;
import com.andreabaccega.widget.FormEditText;
import org.apache.commons.lang3.time.DateFormatUtils; 

public class SearchFragment extends BaseFragment implements View.OnClickListener {

    private String mEndPoint;
    private Form mForm;

    public SearchFragment(String endPoint){
        mEndPoint = endPoint;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        int layout = ViewUtils.getLayoutRes(mEndPoint + "_search");
        ViewGroup parent = (ViewGroup)inflater.inflate(layout, container, false);
        mForm = (Form)parent.findViewById(R.id.form);
        parent.findViewById(R.id.do_search).setOnClickListener(this);

        initData();

        return parent;
    }

    private void initData() {
        initTimeView(R.id.from);
        initTimeView(R.id.to);
        initScanView();
    }

    private void initScanView() {
        View view = mForm.findViewById(R.id.product_snum);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
                    ((Activity)getActivity()).startActivityForResult(intent, Constants.REQUEST_SCAN);
                }

            });
        }
    }

    private void initTimeView(int id) {
        View view = mForm.findViewById(id);
        if (view != null) {
            final TextView tv = (TextView)view;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new DateDialog(getActivity(), tv);
                    dialog.show();
                }

            });
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.do_search:
                if (mForm == null) {
                    return;
                }

                Map<String, String> map = collectSearchMap();
                String where = HttpHandler.buildWhere(map);
                Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                intent.putExtra("end_point", mEndPoint);
                intent.putExtra("where", where);
                startActivity(intent);
                break;
        }
    }

    private Map<String, String> collectSearchMap() {
        Map<String, String> map = mForm.collect();

        //TODO Handle begin and end.
        map.remove("from");
        map.remove("to");

        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            if (TextUtils.isEmpty(map.get(key))) {
                iter.remove();
            }
        }

        return map;
    }
}
