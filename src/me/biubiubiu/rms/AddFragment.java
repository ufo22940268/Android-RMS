package me.biubiubiu.rms;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.view.inputmethod.*;
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
import me.biubiubiu.rms.model.*;
import com.andreabaccega.widget.FormEditText;

public class AddFragment extends BaseFragment {

    private Form mForm;
    private int mLayout;
    private boolean mInTab;
    private String mEndPoint;

    public AddFragment(int layout){
        mLayout = layout;
        mInTab = true;
    }

    public AddFragment(int layout, boolean inTab){
        mLayout = layout;
        mInTab = inTab;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        ViewGroup parent = (ViewGroup)inflater.inflate(mLayout, container, false);
        mForm = (Form)parent.findViewById(R.id.form);
        mEndPoint = mForm.getEndPoint();
        return parent;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {

            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                          Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mForm.getWindowToken(), 0);

            Map<String, String> data = mForm.collect();
            if (validateAll()) {
                mHttp.add(mForm.getEndPoint(), data, new ResponseHandler() {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(getActivity(),
                            "添加成功", Toast.LENGTH_LONG).show();
                        if (!mInTab) {
                            finish();
                        }

                        Activity act = getActivity();
                        if (act != null) {
                            act.sendBroadcast(new Intent(mEndPoint));
                        }
                    }
                });
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private boolean validateAll() {
        ViewGroup root = mForm;
        List<FormEditText> views = ViewUtils.getTypeViews(root, FormEditText.class);
        for (FormEditText view : views) {
            if (view.getId() != R.id.comment && !view.testValidity()) {
                view.requestFocus();
                return false;
            }
        }

        return  true;
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_SCAN) {
            String barcode = data.getExtras().getString("SCAN_RESULT");
            mForm.setProductSnum(barcode);
            loadProduct(barcode);
        }
    }

    protected void loadProduct(String snum) {
        new HttpHandler(getActivity()).getSearch("product", 1, "snum==" + snum,  new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                if (isFinished()) {
                    return;
                }

                List<Map<String, String>> list = Parser.items(result);
                if (list != null && list.size() > 0) {
                    Map<String, String> item = list.get(0);

                    Map<String, String> remoteLocalMap = new HashMap<String, String>();
                    remoteLocalMap.put("color", "color");
                    remoteLocalMap.put("property", "property");

                    for (String key: remoteLocalMap.keySet()) {
                        String value = remoteLocalMap.get(key);
                        int id = ViewUtils.getIdRes(key);
                        View v = mForm.findViewById(id);
                        if (v != null && v instanceof TextView) {
                            ((TextView)v).setText(value);
                        }
                    }
                }
            }
        });
    }
}
