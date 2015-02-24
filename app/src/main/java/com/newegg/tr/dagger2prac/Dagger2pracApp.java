package com.newegg.tr.dagger2prac;

import android.app.Application;

import com.newegg.tr.dagger2prac.view.component.*;


/**
 * Created by william on 15/2/3.
 */
public class Dagger2pracApp extends Application {

    public static boolean MOCK_MODE = true;

    GlobalComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = Dagger_GlobalComponent.create();

    }

    public GlobalComponent component() {
        return mComponent;
    }

}
