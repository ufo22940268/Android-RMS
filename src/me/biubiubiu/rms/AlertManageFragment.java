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

public class AlertManageFragment extends BaseFragment {

    private ListView mListView;

    private String[] LABELS = {
        "温度报警",
        "湿度报警",
        "停电报警",
        "移动侦测",
        "视频遮挡",
        "视频丢失",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        mListView = (ListView)inflater.inflate(R.layout.list, container, false);
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, LABELS));
        mListView.setItemsCanFocus(false);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        return mListView;
    }
}
