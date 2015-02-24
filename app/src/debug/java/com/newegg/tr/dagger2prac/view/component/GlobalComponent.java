package com.newegg.tr.dagger2prac.view.component;

import com.newegg.tr.dagger2prac.Dagger2pracApp;
import com.newegg.tr.dagger2prac.view.module.GlobleModule;
import com.newegg.tr.dagger2prac.model.config.Config;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by william on 15/2/10.
 */
@Singleton
@Component(
        modules = GlobleModule.class
)
public interface GlobalComponent {

    public void inject(Dagger2pracApp app);

    public Config getConfig();

}
