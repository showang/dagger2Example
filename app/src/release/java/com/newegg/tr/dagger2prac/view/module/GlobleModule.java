package com.newegg.tr.dagger2prac.view.module;

import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.model.config.ConfigManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by william on 15/2/10.
 */
@Module
public class GlobleModule {

    @Provides
    @Singleton
    public Config provideConfig(){
        return new ConfigManager();
    }

}
