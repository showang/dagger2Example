package com.newegg.tr.dagger2prac.view.component;


import android.app.Application;

import com.newegg.tr.dagger2prac.Dagger2pracApp;
import com.newegg.tr.dagger2prac.view.SettingView;
import com.newegg.tr.dagger2prac.view.activity.SettingActivity;
import com.newegg.tr.dagger2prac.view.module.SettingModule;
import com.newegg.tr.dagger2prac.view.scope.Setting;

import dagger.Component;

/**
 * Created by william on 15/2/3.
 */
@Setting
@Component(
        dependencies = com.newegg.tr.dagger2prac.view.component.GlobalComponent.class,
        modules = SettingModule.class
)
public interface SettingComponent {

    void inject(SettingActivity activity);

    public class Initializer {

        public static SettingComponent init(Application app, SettingView view) {

            SettingComponent component = Dagger_SettingComponent.builder()
                    .globalComponent(((Dagger2pracApp) app).component())
                    .settingModule(new SettingModule(view)).build();
            return component;
        }
    }

}
