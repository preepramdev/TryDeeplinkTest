package com.maxnimal.trydeeplinktest

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.intent.Intents
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
    fun test_open_list_page() {

        // Given
        val deepLink = "https://www.trydeeplinktest.com/list"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))

        // When
        activityTestRule.launchActivity(intent)

        // Then
    }

    @Test
    fun test_open_detail_page() {

        // Given
        val deepLink = "https://www.trydeeplinktest.com/list/1"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))

        // When
        activityTestRule.launchActivity(intent)

        // Then
    }
}