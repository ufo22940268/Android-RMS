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


public class ImportActivity extends ActionBarActivity {

    FragmentPagerAdapter mAdapter;

    private String[] TITLES = {
        "添加产品",
        "入库状态表",
        "打印列表",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.import_fragment);
         ActionBar actionBar = getSupportActionBar();
         actionBar.setDisplayHomeAsUpEnabled(true);
         actionBar.setTitle("asdfaf");
        //TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.content_indicator);
        //ViewPager pager = (ViewPager)findViewById(R.id.content_pager);

        //if (mAdapter == null) {
            //mAdapter = new ContentAdapter(getSupportFragmentManager());
        //}
        //pager.setAdapter(mAdapter);
        //indicator.setViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.imports, menu);
        return true;
    }

    //Content fragment. Used to display ticket, summary and nearby restarant.
    private class ContentAdapter extends FragmentPagerAdapter {

        public ContentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new AddProductFragment();
            } else if (position == 1) {
                return new RepoStatusFragment();
            } else if (position == 2) {
                return new PrintFragment();
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position % TITLES.length];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }
    }
}

