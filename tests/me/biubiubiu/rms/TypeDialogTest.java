/*
 * TypeDialogTest.java
 * Copyright (C) 2013 garlic <garlic@localhost>
 *
 * Distributed under terms of the MIT license.
 */
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
import android.text.TextUtils;

import java.util.*;
import java.net.*;
import java.io.*;
import java.text.*;

import org.json.*;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.Before;
import org.robolectric.Robolectric;
import org.robolectric.shadows.*;
import com.loopj.android.http.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.robolectric.shadows.*;
import static org.robolectric.Robolectric.*;
import static org.fest.assertions.api.ANDROID.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.fest.assertions.api.Assertions.*;

import com.loopj.android.http.*;
import org.json.*;
import java.util.*;

import me.biubiubiu.rms.ui.*;
import me.biubiubiu.rms.*;


@RunWith(RobolectricTestRunner.class)
public class TypeDialogTest {
    private Activity mAct;

    @Before
    public void setUp() throws Exception {
        mAct = Robolectric.buildActivity(Activity.class).create().get();
    }

    @Test
    public void testCustomDialog() throws Exception  {
        EntityView ev = new EntityView(mAct);
        new TypeDialog(mAct, "import", ev).show();
        ShadowAlertDialog dialog = shadowOf(ShadowAlertDialog.getLatestAlertDialog());

        CharSequence[] items = dialog.getItems();
        assertThat(items[items.length - 1]).isEqualTo("自定义");
    }

    @Test
    public void testAddType() throws Exception  {
        EntityView ev = new EntityView(mAct);
        TypeDialog td = new TypeDialog(mAct, "import", ev);

        td.addType("new_type");
        List<String> l = new ArrayList<String>();
        l.add("new_type");
        assertThat(td.readItems()).isEqualTo(l);

        td.show();
        ShadowAlertDialog dialog = shadowOf(ShadowAlertDialog.getLatestAlertDialog());
        
        dialog.clickOnItem(0);
        assertThat(ev.getValue()).isEqualTo("new_type");
    }
}
