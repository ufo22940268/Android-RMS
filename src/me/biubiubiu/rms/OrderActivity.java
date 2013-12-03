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
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import com.andreabaccega.widget.FormEditText;

import me.biubiubiu.rms.util.HttpHandler.ResponseHandler;
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.model.*;
import com.loopj.android.http.*;

public class OrderActivity extends BaseActivity implements ActionBar.OnNavigationListener {

    private PageList mPageList;
    private OrderCheckFragment mCheckFrag;
    private String[] mItems;
    private EntityMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        mCheckFrag = new OrderCheckFragment("order", R.layout.list_item_order);
        addContainerFragment(mCheckFrag);

        setActionBarTitle("");
        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        mMap = new OrderStateMap();
        mItems = mMap.getMap().keySet().toArray(new String[]{});
        String tmp = null;
        for (int i = 0; i < mItems.length; i ++) {
            String s = mItems[i];
            if (s.equals("全部") && i != 0) {
                tmp = mItems[0];
                mItems[0] = s;
                mItems[i] = tmp;
            }
        }

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                mItems);
        ab.setListNavigationCallbacks(adapter, this);
    }

    public boolean onNavigationItemSelected(int itemPosition, long itemPositionemId) {
        String value = mMap.getValue(mItems[itemPosition]);
        if (value.equals("default")) {
            mCheckFrag.mWhere = null;
        } else {
            mCheckFrag.mWhere = "status==" + value;
        }
        mCheckFrag.refresh();
        return true;
    }
}

