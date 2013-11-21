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

public class AlertManageFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private AlertAdapter mAdapter;

    static public final int STATE_ALERT = 0;
    static public final int STATE_CHECKING = 1;
    static public final int STATE_SAFE = 2;

    private String[] LABELS = {
        "库存报警",
        "温度报警",
        "湿度报警",
        "停电报警",
        "移动侦测",
        "视频遮挡",
        "视频丢失",
    };

    static public final int[][] states = {
        {STATE_CHECKING, 0},
        {STATE_CHECKING, 0},
        {STATE_CHECKING, 0},
        {STATE_CHECKING, 0},
        {STATE_CHECKING, 0},
        {STATE_CHECKING, 0},
        {STATE_CHECKING, 0},
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        mListView = (ListView)inflater.inflate(R.layout.list, container, false);
        mListView.setOnItemClickListener(this);
        mAdapter = new AlertAdapter<String>(getActivity(),
                                R.layout.list_item_alert, android.R.id.text1, LABELS);
        mListView.setAdapter(mAdapter);
        return mListView;
    }

    @Override
    public void onResume() {
        super.onResume();
        checkAlerts();
    }

    private void checkAlerts() {
        checkProductAlerts();

        for (int i = 1; i < states.length; i ++) {
            states[i][0] = STATE_SAFE;
        }
    }

    private void checkProductAlerts() {
        new HttpHandler(getActivity()).get("warning_product", new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                if (isFinished()) {
                    return;
                }

                int size = Parser.items(result).size();
                if (size == 0) {
                    states[0][0] = STATE_SAFE;
                } else {
                    states[0][0] = STATE_ALERT;
                    states[0][1] = size;
                }

                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int pos, long id) {
        checkPosition(pos, AlertProductActivity.class);
    }

    private void checkPosition(int pos, Class cls) {
        if (states[pos][0] == STATE_ALERT) {
            Intent intent = new Intent(getActivity(), cls);
            startActivity(intent);
        }
    }

    public class AlertAdapter<T> extends ArrayAdapter<T> {

        public AlertAdapter(Context a,
                                int b, int c, T[] d) {
            super(a, b, c,d);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            TextView stateView = (TextView)view.findViewById(R.id.state);
            int[] state = states[position];
            if (state[0] == STATE_SAFE) {
                setSafe(stateView, "没有警报");
            } else if (state[0] == STATE_ALERT) {
                setWarningCount(stateView, state[1]);
            }
            return view;
        }
    }

    private void setWarningCount(TextView tv, int count) {
       tv.setTextColor(mRes.getColor(R.color.red)); 
       tv.setText("你有" + count + "条安全警报");
    }

    private void setSafe(TextView tv, String s) {
       tv.setTextColor(mRes.getColor(R.color.green)); 
       tv.setText(s);
    }
}
