package com.bignerdranch.android.chapter_nine

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    @Test
    fun testCheckBoxAndEditTextUpdateCrime() {
        // Launch the CrimeDetailFragment with MainActivity as the host
        val scenario = launchFragmentInContainer<CrimeDetailFragment>(
            themeResId = R.style.Theme_Chapter_nine
        )

        // Verify that the fragment's views are initialized
        scenario.onFragment { fragment ->
            // checks that the crimeTitle EditText is hooked up
            assertNotNull(fragment.binding.crimeTitle)

            // checks that the crimeSolved CheckBox is hooked up
            assertNotNull(fragment.binding.crimeSolved)

            //assertNotNull = checks if view binding within fragment is not NULL

            // sets the EditText and CheckBox values
            fragment.binding.crimeTitle.setText("New Crime Title")
            fragment.binding.crimeSolved.isChecked = true

            // verifies that the Crime object is updated
            assertEquals("New Crime Title", fragment.crime.title)
            assertTrue(fragment.crime.isSolved)
        }
    }
}