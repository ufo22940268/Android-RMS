/*
 * OrderStatusDialog.java
 * Copyright (C) 2013 garlic <garlic@localhost>
 *
 * Distributed under terms of the MIT license.
 */
package me.biubiubiu.rms.ui;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.app.*;
import android.app.AlertDialog.Builder;
import android.os.*;
import android.text.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import me.biubiubiu.rms.R;

public class OrderStatusDialog extends MapDialog {

    public OrderStatusDialog(Context context, String end, EntityView ev) {
        super(context, end, ev);
        mMap = new HashMap<String, String>();
        mMap.put("等待买家付款", "wait_for_buyer"  );
        mMap.put("买家已付款", "buyer_paid"      );
        mMap.put("卖家已发货", "seller_delivered");
        mMap.put("已退货", "refund"          );
        mMap.put("买家已退货", "buyer_returned"  );
        mMap.put("仓库已发货", "repo_delivered"  );
	}
}


