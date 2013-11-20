package me.biubiubiu.rms;

import java.util.Locale;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.pm.*;
import java.util.*;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public class SubMainActivity extends BaseActivity {

    private Fragment mMainFrag;
    private Fragment mRepoFrag;
    private Fragment mContactFrag;
    private Fragment mAudioFrag;
    private Fragment mVideoFrag;
    private Fragment mOrderFrag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        mRepoFrag  = new RepoManageFragment();
        mAudioFrag = new AudioManageFragment();
        mContactFrag = new ContactManageFragment();
        mVideoFrag = new VideoManageFragment();
        mOrderFrag = new OrderManageFragment();
        String content = getIntent().getStringExtra("content");
        if (content.equals("repo")) {
            add(mRepoFrag);
        } else if (content.equals("order")) {
            add(mOrderFrag);
        } else if (content.equals("audio")) {
            add(mAudioFrag);
        } else if (content.equals("video")) {
            add(mVideoFrag);
        } else {
            add(mContactFrag);
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void add(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
            .add(R.id.container, fragment).commit();
    }
}

