package com.newegg.tr.dagger2prac.presenter.internal;

import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.presenter.SettingPresenter;
import com.newegg.tr.dagger2prac.view.SettingView;

import javax.inject.Inject;

/**
 * Created by william on 15/2/3.
 */
public class SettingPresenterImpl implements SettingPresenter {

    SettingView mView;
    Config mConfig;

    @Inject
    public SettingPresenterImpl(SettingView view, Config config){
        mView = view;
        mConfig = config;
    }

    @Override
    public String getUserName() {
        return mConfig.getUserName();
    }

    @Override
    public void setUserName(String name) {
        mConfig.setUserName(name);
        mView.updateUserName(name);
    }
}
