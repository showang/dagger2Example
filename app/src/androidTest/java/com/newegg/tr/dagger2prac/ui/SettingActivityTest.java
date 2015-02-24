package com.newegg.tr.dagger2prac.ui;

import com.newegg.tr.dagger2prac.R;
import com.newegg.tr.dagger2prac.view.component.SettingComponent;
import com.newegg.tr.dagger2prac.view.SettingTestCase;
import com.newegg.tr.dagger2prac.view.module.TestSettingModule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

/**
 * Created by william on 15/2/13.
 */
public class SettingActivityTest extends SettingTestCase {


    String changedName = "William";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
        SettingComponent.Initializer.mInstance.inject(this);
    }


    public void testChangeName() {

        onView(withId(R.id.settingPage_userNameTextView)).check(matches(withText(TestSettingModule.INIT_NAME)));

        onView(withId(R.id.settingPage_changeUserNameButton)).perform(click());

        onView(withId(R.id.settingPage_dialogRenameEditText)).perform(clearText(), typeText(changedName));

        onView(withText("OK")).perform(click());

        when(mMockConfig.getUserName()).thenReturn(changedName);

        onView(withId(R.id.settingPage_userNameTextView)).check(matches(withText(changedName)));
    }

}
