package com.newegg.tr.dagger2prac.view;

/**
 * Created by william on 15/2/2.
 */
public interface MainPageView {

    public void showActionResultText(String resultText);

    public void showInputMethodView(boolean isShow);

    public void showLoading();

    public void hideLoading();

    public void onActionError();
}
