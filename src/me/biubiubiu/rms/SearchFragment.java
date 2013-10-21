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
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.util.*;
import com.andreabaccega.widget.FormEditText;

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
        return parent;
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
                break;
        }
    }

    private Map<String, String> collectSearchMap() {
        Map<String, String> map = mForm.collect();

        //TODO Handle begin and end.
        map.remove("from");
        map.remove("to");

        return map;
    }
}
