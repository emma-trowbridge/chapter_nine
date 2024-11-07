package com.bignerdranch.android.chapter_nine

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    @Test
    fun testCrimeDetailFragmentUIElements() {
        //launch fragment in a container
        val scenario = FragmentScenario.launchInContainer(CrimeDetailFragment::class.java)

        //verify EditText for crime title is displayed
        onView(withId(R.id.crime_title)) //replaces with actual EditText ID
            .check(matches(isDisplayed()))

        //check the Checkbox
        onView(withId(R.id.crime_solved))
            .perform(click())
            .check(matches(isChecked()))

        //access fragment prop to verify values
        scenario.onFragment { fragment ->
            //access the crime prop to check values
            assert(fragment.crime.title == "New Crime Title")
            assert(fragment.crime.isSolved)
        }
    }
}