package com.newegg.tr.dagger2prac.view.module;

import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.presenter.SettingPresenter;
import com.newegg.tr.dagger2prac.presenter.internal.SettingPresenterImpl;
import com.newegg.tr.dagger2prac.view.SettingView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by william on 15/2/3.
 */
@Module
public class SettingModule {
    SettingView view;

    public SettingModule(SettingView view) {
        this.view = view;
    }

    @Provides
    public SettingPresenter presenter(Config config){
        return new SettingPresenterImpl(view, config);
    }


}
