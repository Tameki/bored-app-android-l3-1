package com.geektech.boredapp.intro;

import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

import com.geektech.boredapp.R;
import com.geektech.boredapp.main.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class IntroActivityTest {

    @Rule
    public ActivityTestRule<IntroActivity> activityRule =
            new ActivityTestRule<>(
                    IntroActivity.class,
                    true,
                    false
            );

    @Before
    public void setUp() {
        Intent intent = new Intent();
        activityRule.launchActivity(intent);
    }

    @Test
    public void testNextButtonClick() throws InterruptedException {
        onView(withId(R.id.intro_next)).perform(click());

        Thread.sleep(200L);

        onView(withText(R.string.title_activity_intro_page_2))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testMainActivityLaunchOnIntroFinish() throws InterruptedException {
        onView(withId(R.id.intro_next)).perform(click());
        Thread.sleep(200L);
        onView(withId(R.id.intro_next)).perform(click());
        Thread.sleep(200L);

        Intents.init();

        onView(withId(R.id.intro_next)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));

        Intents.release();
    }
}