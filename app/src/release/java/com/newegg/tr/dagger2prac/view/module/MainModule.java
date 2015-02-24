package com.newegg.tr.dagger2prac.view.module;

import com.newegg.tr.dagger2prac.model.action.Action;
import com.newegg.tr.dagger2prac.model.action.ActionModel;
import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.model.message.MessageModel;
import com.newegg.tr.dagger2prac.model.message.Messenger;
import com.newegg.tr.dagger2prac.presenter.MainPresenter;
import com.newegg.tr.dagger2prac.presenter.internal.MainPresenterImpl;
import com.newegg.tr.dagger2prac.view.MainPageView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by william on 15/1/29.
 */

@Module
public class MainModule {

    private MainPageView mView;

    public MainModule(MainPageView view) {
        mView = view;
    }

    @Provides
    public Messenger messenger() {
        return new MessageModel();
    }

    @Provides
    public Action action(Messenger messageModel, Config config) {
        return new ActionModel(messageModel, config);
    }


    @Provides
    public MainPresenter presenter(Action model) {
        return new MainPresenterImpl(mView, model);
    }

}
