package com.newegg.tr.dagger2prac.view;

import android.test.ActivityInstrumentationTestCase2;

import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.view.activity.SettingActivity;

import javax.inject.Inject;

/**
 * Created by william on 15/2/16.
 */
public class SettingTestCase extends ActivityInstrumentationTestCase2<SettingActivity> {

    @Inject
    protected Config mMockConfig;

    public SettingTestCase() {
        super(SettingActivity.class);
    }
}
