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

public class GetPasswordActivity extends BaseActivity {

    private EditText mNameView;
    private EditText mMobileView; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_password);
        mNameView = (EditText)findViewById(R.id.name);
        mMobileView = (EditText)findViewById(R.id.mobile);
    }

    public void login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void submit(View view) {
        String name = mNameView.getText().toString();
        String mobile = mMobileView.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mobile)) {
            Toast.makeText(this,
                "请输入用户名和手机号", Toast.LENGTH_LONG).show();
            return;
        }

        mHttp.getPassword(name, mobile, new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jo = new JSONObject(result);
                    String pwd = jo.optJSONObject("_item").optString("password");
                    new AlertDialog.Builder(GetPasswordActivity.this)
                            .setMessage("你的密码是" + pwd)
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                    new AlertDialog.Builder(GetPasswordActivity.this)
                            .setMessage("用户名或者手机号不正确")
                            .show();
                }
            }
        });
    }
}
