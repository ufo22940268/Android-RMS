package me.biubiubiu.rms;

import android.util.*;
import android.text.*;
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

public class LoginActivity extends BaseActivity {

    private EditText mNameView;
    private EditText mPwdView; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mNameView = (EditText)findViewById(R.id.name);
        mPwdView = (EditText)findViewById(R.id.password);
    }

    public void clear(View view) {
        mNameView.getText().clear();        
        mPwdView.getText().clear();        
    }

    public void submit(View view) {
        String name = mNameView.getText().toString();
        String pwd = mPwdView.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this,
                "请输入用户名和密码", Toast.LENGTH_LONG).show();
            return;
        }

        mHttp.login(name, pwd, new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                mPermissionManager.loads(result);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}
