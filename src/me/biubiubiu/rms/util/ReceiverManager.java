package me.biubiubiu.rms.util;

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
import android.text.TextUtils;

import java.util.*;

import org.json.*;
import me.biubiubiu.rms.R;

public class ReceiverManager {

    private Context mContext;
    private List<OnReceiveListener> mListeners = new ArrayList<OnReceiveListener>();

    public ReceiverManager(Context context) {
        mContext = context;
    }

    public void registerReceiver(String action) {
        IntentFilter filter = new IntentFilter(action);
        mContext.registerReceiver(mReceiver, filter);
    }

    public BroadcastReceiver mReceiver = new BroadcastReceiver () {
        @Override
        public void onReceive(Context context, Intent intent) {
            for (OnReceiveListener listener : mListeners) {
                listener.onReceive(intent);
            }
        }
    };

    public void setOnReceiveListener(OnReceiveListener listener) {
        mListeners.add(listener);
    }

    public void unregisterReceiver() {
       mContext.unregisterReceiver(mReceiver); 
    }

     public interface OnReceiveListener { 
         public void onReceive(Intent intent);
     }
}
