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

public class AddProductFragment extends BaseFragment {

    private Form mForm;

    public AddProductFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        setHasOptionsMenu(true);
        ViewGroup parent = (ViewGroup)inflater.inflate(R.layout.add_product_fragment, container, false);
        mForm = (Form)parent.findViewById(R.id.form);
        return parent;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("++++++++++++++++++++" + "onOptionsItemSelected" + "++++++++++++++++++++");
        mHttp.add("import", mForm.collect(), new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
            }
        });
        return true;
    }

    //private void validateAll() {
        //ViewGroup root = (ViewGroup)this.getWindow().getDecorView();
        ////List<FormEditText> views = new ArrayList<FormEditText>();
        //List<FormEditText> views = ViewUtils.getTypeViews(root, FormEditText.class);

        //for (FormEditText view : views) {
            //System.out.println("++++++++++++++++++++id:" + mRes.getResourceEntryName(view.getId()) + "++++++++++++++++++++");
            //if (!view.testValidity()) {
                //break;
            //}
        //}
    //}

}
