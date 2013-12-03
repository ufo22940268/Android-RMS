/*
 * YesOrNoMap.java
 * Copyright (C) 2013 garlic <garlic@localhost>
 *
 * Distributed under terms of the MIT license.
 */

package me.biubiubiu.rms.model;

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
import me.biubiubiu.rms.R;
import android.content.res.TypedArray;

import java.util.*;

public class OrderStateMap extends EntityMap {

	public OrderStateMap() {
        put("全部", "default");
        put("等待买家付款", "wait_for_buyer");
        put("买家已付款", "buyer_paid");
        put("卖家已发货", "seller_delivered");
        put("仓库已发货", "repo_delivered");
        put("已退款", "refund");
        put("卖家已退货", "buyer_returned");
	}
}


