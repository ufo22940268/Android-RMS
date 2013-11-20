/*
 * CustomDialogTest.java
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
import me.biubiubiu.rms.model.*;
import me.biubiubiu.rms.*;
import org.robolectric.annotation.Config;


@RunWith(RobolectricTestRunner.class)
public class ModelTest {
    private Activity mAct;

    @Before
    public void setUp() throws Exception {
        mAct = Robolectric.buildActivity(Activity.class).create().get();
    }

    @Test
    public void testYesOrNoView() throws Exception  {
        YesOrNoEntityView v = new YesOrNoEntityView(mAct, null);
        v.setLabelFromRemote("0");
        assertThat(v.getLabel()).isEqualTo("否");
        
        v.setLabelFromRemote("1");
        assertThat(v.getLabel()).isEqualTo("是");
    }
}
