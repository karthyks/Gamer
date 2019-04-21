package karthyks.gamer.login.extensions

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId

fun ViewInteraction.performClick() = perform(ViewActions.click())

fun Int.matchView(): ViewInteraction = Espresso.onView(withId(this))

fun Int.performClick() = matchView().performClick()