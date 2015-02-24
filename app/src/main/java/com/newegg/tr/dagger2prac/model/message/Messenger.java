package com.newegg.tr.dagger2prac.model.message;

import dagger.Component;

/**
 * Created by william on 15/1/29.
 */
public interface Messenger {

    public String getHelloFormat();

    public String getByeFormat();

    public String getFibInitMessage();

    public String getCalcText();
}
