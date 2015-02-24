package com.newegg.tr.dagger2prac.model.config;

/**
 * Created by william on 15/2/3.
 */
public class ConfigManager implements Config {

    private final static String DEFAULT_USER = "William";

    private String mUserName = DEFAULT_USER;

    @Override
    public String getUserName() {
        return mUserName;
    }

    @Override
    public void setUserName(String userName) {
        mUserName = userName;
    }
}
