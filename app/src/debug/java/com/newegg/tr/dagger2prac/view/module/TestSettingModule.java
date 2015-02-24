package com.newegg.tr.dagger2prac.view.module;

import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.model.config.ConfigManager;
import com.newegg.tr.dagger2prac.presenter.SettingPresenter;
import com.newegg.tr.dagger2prac.presenter.internal.SettingPresenterImpl;
import com.newegg.tr.dagger2prac.view.SettingView;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.when;

/**
 * Created by william on 15/2/13.
 */
@Module
public class TestSettingModule {


    public final static String INIT_NAME = "大中天";
    SettingView mView;
    @Mock
    Config mMockConfig;
    private boolean mIsMock;

    public TestSettingModule(SettingView view, boolean isMock) {
        mView = view;
        mIsMock = isMock;
        MockitoAnnotations.initMocks(this);
        when(mMockConfig.getUserName()).thenReturn(INIT_NAME);
    }

    @Singleton
    @Provides
    public SettingPresenter provideSettingPresenter(Config config) {
        return new SettingPresenterImpl(mView, config);
    }

    @Singleton
    @Provides
    public Config provideConfig() {
        return (mIsMock) ? mMockConfig : new ConfigManager();
    }

}
