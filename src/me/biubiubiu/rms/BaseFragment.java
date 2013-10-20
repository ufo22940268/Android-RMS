package me.biubiubiu.rms;

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
import org.json.*;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;

public class BaseFragment extends Fragment {

    protected Resources mRes;
    protected HttpHandler mHttp;


    public BaseFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        mRes = getActivity().getResources();
        mHttp = new HttpHandler(getActivity());
        setHasOptionsMenu(true);
    }

    protected void startFragment(Fragment f) {
        Activity a = getActivity();
        if (a != null) {
            FragmentActivity act = (FragmentActivity)a;
            FragmentManager fragmentManager = act.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                .replace(R.id.content_frame, f)
                .addToBackStack(null)
                .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
