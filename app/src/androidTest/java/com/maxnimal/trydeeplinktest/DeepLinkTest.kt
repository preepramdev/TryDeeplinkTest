package com.maxnimal.trydeeplinktest

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeepLinkTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun test_open_list_activity() {

        // Given
        val deepLink = "https://www.trydeeplinktest.com/list"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))

        // When
        activityTestRule.launchActivity(intent)

        // Then
        intended(hasComponent(ListActivity::class.java.name))
    }

    @Test
    fun test_open_list_fragment() {

        // Given
        val deepLink = "https://www.trydeeplinktest.com/list"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))

        // When
        activityTestRule.launchActivity(intent)

        // Then
        //        onView(withId(R.layout.fragment_list)).check(matches(isDisplayed()))
        onView(withId(R.id.layout_list_fragment)).check(matches(isDisplayed()))
    }



    @Test
    fun test_open_detail_activity() {

        // Given
        val deepLink = "https://www.trydeeplinktest.com/list/1"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))

        // When
        activityTestRule.launchActivity(intent)

        // Then
        intended(hasComponent(DetailActivity::class.java.name))
    }
}