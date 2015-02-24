package com.newegg.tr.dagger2prac.view.component;

import android.app.Application;

import com.newegg.tr.dagger2prac.Dagger2pracApp;
import com.newegg.tr.dagger2prac.view.MainPageView;
import com.newegg.tr.dagger2prac.view.activity.MainActivity;
import com.newegg.tr.dagger2prac.view.scope.Main;
import com.newegg.tr.dagger2prac.view.module.MainModule;

import dagger.Component;

/**
 * Created by william on 15/1/29.
 */
@Main
@Component(
        dependencies = GlobalComponent.class,
        modules = MainModule.class
)
public interface MainComponent {

    void inject(MainActivity activity);

    public class Initializer {

        public static MainComponent init(Application app, MainPageView view) {

            MainComponent component = Dagger_MainComponent.builder()
                    .globalComponent(((Dagger2pracApp) app).component())
                    .mainModule(new MainModule(view)).build();
            return component;
        }
    }
}
