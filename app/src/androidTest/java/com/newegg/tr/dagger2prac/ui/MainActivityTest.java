package com.newegg.tr.dagger2prac.ui;

import android.test.suitebuilder.annotation.LargeTest;

import com.newegg.tr.dagger2prac.R;
import com.newegg.tr.dagger2prac.view.component.MainComponent;
import com.newegg.tr.dagger2prac.view.MainTestCase;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by william on 15/2/3.
 */

@LargeTest
public class MainActivityTest extends MainTestCase {



    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
        MainComponent.Initializer.mInstance.inject(this);
    }

    public void testByeAction() {

        String mockResult = "Bye William!!(This is Mock Data)";
        when(mMockAction.bye()).thenReturn(mockResult);

        onView(withId(R.id.mainPage_actionSpinner)).perform(click());
        onView(withText("Bye")).perform(click());

        onView(withId(R.id.mainPage_messageText)).check(matches(withText(mockResult)));
    }

    public void testFibAction() {
        onView(withId(R.id.mainPage_actionSpinner)).perform(click());
        onView(withText("Fibonacci")).perform(click());

        when(mMockAction.calcFibNumber(5)).thenReturn(77);
        when(mMockAction.calcFibNumber(10)).thenReturn(99);

        onView(withId(R.id.mainPage_inputEditText)).perform(typeText("5"));
        onView(withId(R.id.mainPage_submitButton)).perform(click());

        onView(withId(R.id.mainPage_messageText)).check(matches(withText("77")));

        onView(withId(R.id.mainPage_inputEditText)).perform(clearText(), typeText("10"));
        onView(withId(R.id.mainPage_submitButton)).perform(click());

        onView(withId(R.id.mainPage_messageText)).check(matches(withText("99")));
    }

    public void testStartSettingPage() {

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(withText("Settings")).perform(click());

        onView(withText("User Name:")).check(matches(isDisplayed()));

    }

    public void testFibError() {

        when(mMockAction.calcFibNumber(anyInt())).thenReturn(-1);

        onView(withId(R.id.mainPage_actionSpinner)).perform(click());
        onView(withText("Fibonacci")).perform(click());

        onView(withId(R.id.mainPage_inputEditText)).perform(typeText("0"));
        onView(withId(R.id.mainPage_submitButton)).perform(click());

        onView(withId(R.id.mainPage_messageText)).check(matches(withText("Error!!!!")));
    }

    public void testFibNoInputError(){

        onView(withId(R.id.mainPage_actionSpinner)).perform(click());
        onView(withText("Fibonacci")).perform(click());

        onView(withId(R.id.mainPage_submitButton)).perform(click());

        onView(withId(R.id.mainPage_messageText)).check(matches(withText("Error!!!!")));
    }

}
