package com.newegg.tr.dagger2prac.model;

import com.newegg.tr.dagger2prac.model.message.MessageModel;
import com.newegg.tr.dagger2prac.model.message.Messenger;

import junit.framework.TestCase;

/**
 * Created by william on 15/2/3.
 */
public class MessageModelTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testHelloMessage(){
        Messenger m = new MessageModel();

        assertEquals("Hello %s!", m.getHelloFormat());
    }

    public void testByeMessage(){
        Messenger m = new MessageModel();

        assertEquals("Bye %s!!", m.getByeFormat());
    }
}
