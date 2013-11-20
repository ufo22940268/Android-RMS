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

public class ContactActivity extends BaseActivity {

    private PageList mPageList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        PageListFragment frag = new PageListFragment("contact", R.layout.list_item_contact);
        addContainerFragment(frag);
        setActionBarTitle(getIntent().getStringExtra("title"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.provider, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())  {
            case R.id.add:
                Intent intent = new Intent(this, AddActivity.class);
                intent.putExtra("end_point", "contact");
                startActivity(intent);
                break;

            case R.id.search:
                intent = new Intent(this, SearchContactActivity.class);
                startActivity(intent);
                break;
            
            
        }
        return super.onOptionsItemSelected(item);
    }
}

