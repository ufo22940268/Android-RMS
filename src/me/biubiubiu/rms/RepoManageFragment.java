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

public class RepoManageFragment extends Fragment {

    static public final String[][] TITLES = {
        {"产品入库", "Warehousing Managemengt"},
        {"产品出库", "Warehousing Managemengt"},
        {"产品出库入库查询", "Infomation notice"},
        {"产品信息查询", "Products Management"},
        {"供应商管理", "Supplier Management"},
        {"操作员信息管理", "Operator Management"},
        {"操作员信息管理", "Operator Management"},
    };

    public RepoManageFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        ViewGroup parent = (ViewGroup)inflater.inflate(
                R.layout.repo_manage_fragment, container, false);

        Point size = new Point();

        getActivity().getWindowManager().getDefaultDisplay().getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        int halfScreenWidth = (int)(screenWidth *0.5);
        int quarterScreenWidth = (int)(halfScreenWidth * 0.5);

        for (int i = 0; i < TITLES.length; i ++) {
            String t[] = TITLES[i];
            addRow(parent, halfScreenWidth, t[0], t[1]);
        }

        return parent;
    }

    private void addRow(ViewGroup container, int width, String major, String minor) {
        View item = LayoutInflater.from(
                getActivity()).inflate(R.layout.row_item_repo_manage, container, false);
        item.getLayoutParams().width = width;
        ((TextView)item.findViewById(R.id.major)).setText(major);
        ((TextView)item.findViewById(R.id.minor)).setText(minor);
        container.addView(item);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
