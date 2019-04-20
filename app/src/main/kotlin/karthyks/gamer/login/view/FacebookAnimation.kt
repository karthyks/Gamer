package karthyks.gamer.login.view

import androidx.core.view.isVisible
import karthyks.gamer.login.Facebook
import karthyks.gamer.login.LoginActivity
import karthyks.gamer.login.facebook.initialize
import kotlinx.android.synthetic.main.activity_login.*

internal fun LoginActivity.showFacebookButton(show: Boolean = true) {
    if (show) {
        (loginProvider as? Facebook)?.initialize()
        btnFbLogin.isVisible = true
        btnFbLogin.animate()
            .alpha(1f)
            .setStartDelay(800)
            .setListener(onAnimationEnd {
                btnCancel.isVisible = true
            })
            .setDuration(500)
            .start()
    } else {
        btnFbLogin.animate()
            .alpha(0f)
            .setListener(onAnimationEnd {
                btnFbLogin.isVisible = show
                btnCancel.isVisible = false
            })
            .setStartDelay(0)
            .setDuration(100)
            .start()
    }
}