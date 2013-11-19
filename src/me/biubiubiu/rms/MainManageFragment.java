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
import me.biubiubiu.rms.util.*;
import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;
import com.loopj.android.http.*;
import android.content.ComponentName;
import android.content.pm.*;

public class MainManageFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private BlockAdapter mAdapter;

    static public final String[][] TITLES = {
        {"仓库管理", "Warehousing Managemengt"},
        {"订单管理", "Warehousing Managemengt"},
        {"录音查询", "Warehousing Managemengt"},
        {"视频监控", "Warehousing Managemengt"},
        {"安防报警", "Warehousing Managemengt"},
        {"ip拨号", "Warehousing Managemengt"},
    };

    static public final int[] IMAGE_RES = {
        R.drawable.main_repo,
        R.drawable.main_order,
        R.drawable.main_audio,
        R.drawable.main_monitor,
        R.drawable.main_alert,
        R.drawable.main_ip_dialer,
    };

    public MainManageFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        GridView grid = (GridView)inflater.inflate(
                R.layout.repo_manage_fragment, container, false);
        mAdapter = new BlockAdapter(getActivity(), TITLES, IMAGE_RES);
        grid.setAdapter(mAdapter);
        grid.setOnItemClickListener(this);

        return grid;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int pos, long id) {
        switch (pos) {
            case 0:
                Intent intent = new Intent(getActivity(), SubMainActivity.class);
                intent.putExtra("content", "repo");
                startActivity(intent);
                break;

            case 1:
                intent = new Intent(getActivity(), SubMainActivity.class);
                intent.putExtra("content", "order");
                startActivity(intent);
                break;

            case 2:
                intent = new Intent(getActivity(), SubMainActivity.class);
                intent.putExtra("content", "audio");
                startActivity(intent);
                break;

            case 3:
                launchEyeCloud();
                break;

            case 4:
                intent = new Intent(getActivity(), SubMainActivity.class);
                intent.putExtra("content", "video");
                startActivity(intent);
                break;
                
            case 5:
                new AlertDialog.Builder(getActivity())
                    .setMessage("功能未开通")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                /* User clicked OK so do some stuff */
                            }
                        })
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                /* User clicked Cancel so do some stuff */
                            }
                        })
                    .show();

                break;
        }
    }

    private void launchEyeCloud() {
        if (isPackageExisted("com.vMEyeCloud")) {
            ComponentName cn = new ComponentName("com.vMEyeCloud", "com.vMEyeCloud.AcLogin");
            Intent intent = new Intent();
            intent.setComponent(cn);
            startActivity(intent);
        } else {
            showEyeCloudDialog();
        }
    }

    public boolean isPackageExisted(String targetPackage){
        List<ApplicationInfo> packages;
        PackageManager pm;
        pm = getActivity().getPackageManager();        
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if(packageInfo.packageName.equals(targetPackage)) return true;
        }        
        return false;
    }

    private void showEyeCloudDialog() {
        new AlertDialog.Builder(getActivity())
            .setMessage("你尚未安装vMEyeCloud")
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    Uri uri = Uri.parse("http://192.241.196.189:8000/vMEyeCloud.apk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                     /* User clicked OK so do some stuff */
                }
            })
        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                /* User clicked Cancel so do some stuff */
            }
        })
        .show();
    }
}
