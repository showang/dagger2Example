package com.newegg.tr.dagger2prac.view.module;

import com.newegg.tr.dagger2prac.model.action.Action;
import com.newegg.tr.dagger2prac.presenter.MainPresenter;
import com.newegg.tr.dagger2prac.presenter.internal.MainPresenterImpl;
import com.newegg.tr.dagger2prac.view.MainPageView;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by william on 15/2/17.
 */
@Module
public class TestMainModule {
    MainPageView mView;

    @Mock
    Action mActionModel;

    public TestMainModule(MainPageView view) {
        mView = view;
        MockitoAnnotations.initMocks(this);
    }

    @Provides
    @Singleton
    public MainPresenter getPresenter(Action action) {

        return new MainPresenterImpl(mView, action);
    }

    @Provides
    @Singleton
    public Action getAction() {
        return mActionModel;
    }
}
