package com.newegg.tr.dagger2prac.model;

import com.newegg.tr.dagger2prac.model.action.Action;
import com.newegg.tr.dagger2prac.model.action.ActionModel;
import com.newegg.tr.dagger2prac.model.config.Config;
import com.newegg.tr.dagger2prac.model.message.Messenger;

import junit.framework.TestCase;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by william on 15/2/2.
 */

public class ActionModelTest extends TestCase {

    @Mock
    private Action action;
    @Mock
    private Messenger mMessenger;
    @Mock
    private Config mConfig;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    public void testHello() {
        String stubPerson = "Who is not important in this case.";
        String stubMessage = "Test Hello in stub with %s";
        String exceptResult = "Test Hello in stub with Who is not important in this case.";

        when(mMessenger.getHelloFormat()).thenReturn(stubMessage);

        when(mConfig.getUserName()).thenReturn(stubPerson);

        action = new ActionModel(mMessenger, mConfig);

        assertEquals(exceptResult, action.hello());

        verify(mConfig, times(1)).getUserName();

    }

    public void testCalcFib() {
        action = new ActionModel(mock(Messenger.class), mock(Config.class));

        assertEquals(5, action.calcFibNumber(5));

        assertEquals(8, action.calcFibNumber(6));

        assertEquals(55, action.calcFibNumber(10));

        assertEquals(-1, action.calcFibNumber(0));

        assertEquals(-1, action.calcFibNumber(-2));

    }


}
