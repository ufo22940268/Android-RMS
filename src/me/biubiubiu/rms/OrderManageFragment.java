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

public class OrderManageFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private BlockAdapter mAdapter;

    static public final String[][] TITLES = {
        {"客户管理", "Warehousing Managemengt"},
        {"销售订单", "Warehousing Managemengt"},
        {"销售开销", "Infomation notice"},
    };

    public OrderManageFragment(){
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
                Intent intent = new Intent(getActivity(), CustomerActivity.class);
                intent.putExtra("title", TITLES[pos][0]);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getActivity(), OrderActivity.class);
                intent.putExtra("title", TITLES[pos][0]);
                startActivity(intent);
                break;

            case 2:
                intent = new Intent(getActivity(), OrderActivity.class);
                intent.putExtra("title", TITLES[pos][0]);
                startActivity(intent);
                break;
        }
    }
}
