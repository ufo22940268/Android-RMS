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

public class AudioManageFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private BlockAdapter mAdapter;

    static public final String[][] TITLES = {
        {"录音查听", "Warehousing Managemengt"},
        {"联系人", "Warehousing Managemengt"},
    };

    static public final int[] IMAGE_RES = {
        R.drawable.menu_view_record,
        R.drawable.menu_contact,
    };

    public AudioManageFragment(){
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
                Intent intent = new Intent(getActivity(), AudioRecordActivity.class);
                intent.putExtra("title", TITLES[pos][0]);
                startActivity(intent);
                break;

            case 1:
                intent = new Intent(getActivity(), AudioRecordActivity.class);
                intent.putExtra("title", TITLES[pos][0]);
                startActivity(intent);
                break;
        }
    }
}
