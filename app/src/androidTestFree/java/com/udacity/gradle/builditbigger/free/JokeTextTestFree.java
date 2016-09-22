package com.udacity.gradle.builditbigger.free;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.free.MainActivityFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokeTextTestFree {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testClickButtonAndJokeText() {
        MainActivityFragment fragment = (MainActivityFragment) mActivityTestRule.getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
        onView(withId(R.id.btn_joke)).perform(ViewActions.click());
        if (fragment != null) {
            if (fragment.mIsInterstitialLoaded) {
                Espresso.pressBack();
            }
        }
        onView(withId(R.id.tv_joke)).check(matches(not(withText(""))));
    }
}