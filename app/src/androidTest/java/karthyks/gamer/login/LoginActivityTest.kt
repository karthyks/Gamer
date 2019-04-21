package karthyks.gamer.login


import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.github.karthyks.gamer.R
import karthyks.gamer.login.extensions.matchView
import karthyks.gamer.login.extensions.performClick
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class LoginActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<LoginActivity>()

    @Test
    fun checkProgressBarIsShown() {
        R.id.progress.matchView().check(matches(isDisplayed()))
    }

    @Test
    fun checkProgressBarIsHidden() {
        Thread.sleep(3000)
        R.id.progress.matchView().check(matches(not(isDisplayed())))
    }

    @Test
    fun checkIfAllFabButtonsAreHiddenInitially() {
        R.id.fab_phone.matchView().check(matches(not((withAlpha(1f)))))
        R.id.fab_email.matchView().check(matches(not((withAlpha(1f)))))
        R.id.fab_facebook.matchView().check(matches(not((withAlpha(1f)))))
        R.id.fab_github.matchView().check(matches(not((withAlpha(1f)))))
        R.id.fab_twitter.matchView().check(matches(not((withAlpha(1f)))))
        R.id.fab_google.matchView().check(matches(not((withAlpha(1f)))))
        R.id.fab_microsoft.matchView().check(matches(not((withAlpha(1f)))))
        R.id.fab_yahoo.matchView().check(matches(not((withAlpha(1f)))))
    }

    @Test
    fun showFbLoginButtonOnFabFacebookClick() {
        Thread.sleep(3000)
        R.id.fab_facebook.performClick()
        R.id.btnFbLogin.matchView().check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun showAllFabsAfterCancelingFbLogin() {
        Thread.sleep(3000)
        R.id.fab_facebook.performClick()
        R.id.btnFbLogin.matchView().check(matches(isCompletelyDisplayed()))
        R.id.btnCancel.performClick()
        R.id.fab_phone.matchView().check(matches((withAlpha(1f))))
        R.id.fab_email.matchView().check(matches((withAlpha(1f))))
        R.id.fab_facebook.matchView().check(matches((withAlpha(1f))))
        R.id.fab_github.matchView().check(matches((withAlpha(1f))))
        R.id.fab_twitter.matchView().check(matches((withAlpha(1f))))
        R.id.fab_google.matchView().check(matches((withAlpha(1f))))
        R.id.fab_microsoft.matchView().check(matches((withAlpha(1f))))
        R.id.fab_yahoo.matchView().check(matches((withAlpha(1f))))
    }
}