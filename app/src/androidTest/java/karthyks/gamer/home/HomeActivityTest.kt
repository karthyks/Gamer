package karthyks.gamer.home

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.github.karthyks.gamer.R
import karthyks.gamer.login.extensions.matchView
import karthyks.gamer.login.extensions.performClick
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class HomeActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<HomeActivity>()

    @Test
    fun checkIfUsernameIsNotEmpty() {
        R.id.tvUsername.matchView().check(matches(not(withText(""))))
    }

    @Test
    fun checkLoginActivityIsLaunchingAfterLogout() {
        R.id.btnLogout.performClick()
        R.id.progress.matchView().check(matches(isDisplayed()))
    }
}