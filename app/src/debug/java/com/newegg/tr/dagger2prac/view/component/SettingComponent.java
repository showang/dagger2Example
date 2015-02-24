package com.newegg.tr.dagger2prac.view.component;


import android.app.Application;

import com.newegg.tr.dagger2prac.Dagger2pracApp;
import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.view.SettingView;
import com.newegg.tr.dagger2prac.view.activity.SettingActivity;
import com.newegg.tr.dagger2prac.view.SettingTestCase;
import com.newegg.tr.dagger2prac.view.module.TestSettingModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by william on 15/2/3.
 */
@Singleton
@Component(
        modules = TestSettingModule.class
)
public interface SettingComponent {

    void inject(SettingActivity activity);

    void inject(SettingTestCase testSetting);

    Config getConfig();

    public class Initializer {
        public static SettingComponent mInstance;

        public static SettingComponent init(Application app, SettingView view) {

            SettingComponent component = Dagger_SettingComponent.builder()
                    .testSettingModule(new TestSettingModule(view, ((Dagger2pracApp) app).MOCK_MODE)).build();

            mInstance = component;
            return component;
        }

    }

}
