package com.newegg.tr.dagger2prac.view.component;

import android.app.Application;

import com.newegg.tr.dagger2prac.view.MainPageView;
import com.newegg.tr.dagger2prac.view.activity.MainActivity;
import com.newegg.tr.dagger2prac.view.MainTestCase;
import com.newegg.tr.dagger2prac.view.module.TestMainModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by william on 15/1/29.
 */
@Singleton
@Component(
        modules = TestMainModule.class
)
public interface MainComponent {

    void inject(MainActivity activity);

    void inject(MainTestCase testCase);

    public class Initializer {

        public static MainComponent mInstance;

        public static MainComponent init(Application app, MainPageView view) {

            MainComponent component = Dagger_MainComponent.builder()
                    .testMainModule(new TestMainModule(view))
                    .build();
            mInstance = component;
            return component;
        }
    }

}
