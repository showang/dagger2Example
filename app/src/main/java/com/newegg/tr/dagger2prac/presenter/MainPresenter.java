package com.newegg.tr.dagger2prac.presenter;

import com.newegg.tr.dagger2prac.model.action.ActionType;

/**
 * Created by william on 15/2/2.
 */
public interface MainPresenter {

    public void onActionSelected(ActionType type);

    public void calcFib(int fibNumber);

    public void updateUser();
}
