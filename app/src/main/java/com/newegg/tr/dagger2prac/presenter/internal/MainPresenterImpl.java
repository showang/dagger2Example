package com.newegg.tr.dagger2prac.presenter.internal;

import android.os.AsyncTask;
import android.util.Log;

import com.newegg.tr.dagger2prac.model.action.Action;
import com.newegg.tr.dagger2prac.model.action.ActionType;
import com.newegg.tr.dagger2prac.presenter.MainPresenter;
import com.newegg.tr.dagger2prac.view.MainPageView;

import javax.inject.Inject;

/**
 * Created by william on 15/2/2.
 */
public class MainPresenterImpl implements MainPresenter {

    private final static ActionType DEFAULT_ACTION = ActionType.HELLO;

    MainPageView mView;
    Action mModel;

    ActionType currentAction = DEFAULT_ACTION;

    @Inject
    public MainPresenterImpl(MainPageView view, Action model) {
        mModel = model;
        mView = view;
    }

    @Override
    public void onActionSelected(ActionType type) {
        String result = "Error";
        boolean isShowInputMethod = false;
        currentAction = type;
        switch (type){
            case HELLO:
                result = mModel.hello();
                isShowInputMethod = false;
                break;
            case BYE:
                result = mModel.bye();
                isShowInputMethod = false;
                break;
            case FIBONACCI:
                result = mModel.fibonacci();
                isShowInputMethod = true;
                break;
        }
        Log.e("MainPresenterImpl", "onActionSelected: " + result);
        mView.showInputMethodView(isShowInputMethod);
        mView.showActionResultText(result);
    }

    @Override
    public void calcFib(final int fibNumber) {
        Log.e("MainPresenterImpl", "calcFib: " + fibNumber);
        mView.showLoading();

        new AsyncTask<Void, Void, Integer>(){

            @Override
            protected Integer doInBackground(Void... params) {
                return mModel.calcFibNumber(fibNumber);
            }

            @Override
            protected void onPostExecute(Integer result) {
                super.onPostExecute(result);

                if(result == -1) {
                    mView.onActionError();
                }else {
                    mView.showActionResultText(result.toString());
                }
                mView.hideLoading();
            }
        }.execute();
    }



    @Override
    public void updateUser() {
        onActionSelected(currentAction);
    }

}
