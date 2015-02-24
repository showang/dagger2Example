package com.newegg.tr.dagger2prac.view;

import android.test.ActivityInstrumentationTestCase2;

import com.newegg.tr.dagger2prac.model.action.Action;
import com.newegg.tr.dagger2prac.view.activity.MainActivity;
import com.newegg.tr.dagger2prac.view.component.MainComponent;

import javax.inject.Inject;

/**
 * Created by william on 15/2/17.
 */
public class MainTestCase extends ActivityInstrumentationTestCase2<MainActivity> {

    @Inject
    protected Action mMockAction;

    public MainTestCase() {
        super(MainActivity.class);
    }


}
