package com.example.myapplication


import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    //serve para dizer qual vai ser a primeira tela a ser iniciada no projeto de testes
    @get:Rule
    var mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginWithSuccess() {
        onView(withText("Test App Murillo")).check(matches(isDisplayed()))
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("murillo.welsi@gmail.com"))
        onView(withId(R.id.editTextTextPassword)).perform(typeText("123456"))
        closeSoftKeyboard()
        onView(withId(R.id.button_first)).perform(click())
        onView(withText("Logged in")).check(matches(isDisplayed()))
        onView(withId(R.id.button_second)).perform(click())
        onView(withText("Test App Murillo")).check(matches(isDisplayed()))
    }
}