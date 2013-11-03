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

public class RepoManageFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private BlockAdapter mAdapter;

    static public final String[][] TITLES = {
        {"产品入库", "Warehousing Managemengt"},
        {"产品出库", "Warehousing Managemengt"},
        {"产品出入库查询", "Infomation notice"},
        {"产品信息查询", "Products Management"},
        {"供应商管理", "Supplier Management"},
        {"操作员信息管理", "Operator Management"},
        {"审核中心", "Auth Management"},
    };

    public RepoManageFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        GridView grid = (GridView)inflater.inflate(
                R.layout.repo_manage_fragment, container, false);
        mAdapter = new BlockAdapter(getActivity(), TITLES);
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
                if (mPermissionManager.checkPermission("import", 0)) {
                    Intent intent = new Intent(getActivity(), ImportActivity.class);
                    intent.putExtra("title", TITLES[pos][0]);
                    startActivity(intent);
                }
                break;
            case 1:
                if (mPermissionManager.checkPermission("export", 0)) {
                    Intent intent = new Intent(getActivity(), ExportActivity.class);
                    intent.putExtra("title", TITLES[pos][0]);
                    startActivity(intent);
                }
                break;

            case 2:
                if (mPermissionManager.checkPermission("search", 0)) {
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    intent.putExtra("title", TITLES[pos][0]);
                    startActivity(intent);
                }
                break;

            case 3:
                if (mPermissionManager.checkPermission("product", 0)) {
                    Intent intent = new Intent(getActivity(), ProductActivity.class);
                    intent.putExtra("title", TITLES[pos][0]);
                    startActivity(intent);
                }
                break;

            case 4:
                if (mPermissionManager.checkPermission("provider", 0)) {
                    Intent intent = new Intent(getActivity(), ProviderActivity.class);
                    intent.putExtra("title", TITLES[pos][0]);
                    startActivity(intent);
                }
                break;

            case 5:
                if (mPermissionManager.checkPermission("operator", 0)) {
                    Intent intent = new Intent(getActivity(), OperatorActivity.class);
                    intent.putExtra("title", TITLES[pos][0]);
                    startActivity(intent);
                }
                break;

            case 6:
                if (mPermissionManager.checkPermission("operator", 0)) {
                    Intent intent = new Intent(getActivity(), ValidateCenterActivity.class);
                    intent.putExtra("title", TITLES[pos][0]);
                    startActivity(intent);
                }
                break;
        }
    }
}
