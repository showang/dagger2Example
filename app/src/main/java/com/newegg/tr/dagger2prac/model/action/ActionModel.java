package com.newegg.tr.dagger2prac.model.action;

import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.model.message.Messenger;

import javax.inject.Inject;

/**
 * Created by william on 15/1/30.
 */
public class ActionModel implements Action {

    private final Messenger mMessenger;

    private final Config mConfig;

    @Inject
    public ActionModel(Messenger messenger, Config config) {

        mMessenger = messenger;

        mConfig = config;
    }

    @Override
    public String hello() {

        return String.format(mMessenger.getHelloFormat(), mConfig.getUserName());
    }

    @Override
    public String bye() {

        return String.format(mMessenger.getByeFormat(), mConfig.getUserName());
    }

    @Override
    public String fibonacci() {

        return mMessenger.getFibInitMessage();

    }

    @Override
    public int calcFibNumber(int input) {

        if(input <=0 )
            return -1;

        return fibMethod(input);
    }

    private int fibMethod(int n){
        if(n <= 0)
            throw new IllegalArgumentException("Input must be positive integer");
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        return fibMethod(n-2) + fibMethod(n-1);
    }


}
