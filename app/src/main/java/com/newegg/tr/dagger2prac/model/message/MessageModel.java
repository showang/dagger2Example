package com.newegg.tr.dagger2prac.model.message;

/**
 * Created by william on 15/1/29.
 */
public class MessageModel implements Messenger {

    @Override
    public String getHelloFormat() {
        return "Hello %s!";
    }

    @Override
    public String getByeFormat() {
        return "Bye %s!!";
    }

    @Override
    public String getFibInitMessage() {
        return "Plz input a number.";
    }

    @Override
    public String getCalcText() {
        return "Calculating...";
    }
}
