package com.example.danielholst.logincomponent;

/**
 * Created by danielholst on 15-12-12.
 */
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.example.danielholst.logincomponent.SignupForm.LoginForm;

import org.junit.Before;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class espressoTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public espressoTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }
/*
    public void testChangeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.class.getClass(LoginForm)))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.changeTextButton)).perform(click());

        // Check that the text was changed.
        ...
    }

*/
}