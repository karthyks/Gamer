package karthyks.gamer.login.view

import android.animation.Animator
import com.google.android.material.floatingactionbutton.FloatingActionButton
import karthyks.gamer.login.LoginActivity
import kotlinx.android.synthetic.main.activity_login.*

internal fun LoginActivity.animateCenterImage(reverse: Boolean = false) {
    val rotationY = if(reverse) 0f else 360f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    img_center.animate()
        .rotation(rotationY)
        .alpha(alpha)
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun LoginActivity.animateFacebookFab(reverse: Boolean = false) {
    val x = if (reverse) -100f else 300f
    val y = if (reverse) 0f else -400 / 1.5f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_facebook.animate()
        .translationX(x)
        .translationY(y)
        .alpha(alpha)
        .setListener(onAnimationEnd {
            fab_facebook.isClickable = !reverse
        })
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun LoginActivity.animateTwitterFab(reverse: Boolean = false) {
    val x = if (reverse) -100f else 400f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_twitter.animate()
        .translationX(x)
        .alpha(alpha)
        .setListener(onAnimationEnd {
            fab_twitter.isClickable = !reverse
        })
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun LoginActivity.animateYahooFab(reverse: Boolean = false) {
    val x = if (reverse) -100f else 300f
    val y = if (reverse) 0f else 400 / 1.5f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_yahoo.animate()
        .translationX(x)
        .setListener(onAnimationEnd {
            fab_yahoo.isClickable = !reverse
        })
        .translationY(y)
        .alpha(alpha)
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun LoginActivity.animateMicrosoftFab(reverse: Boolean = false) {
    val y = if (reverse) 0f else 400f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_microsoft.animate()
        .translationY(y)
        .alpha(alpha)
        .setListener(onAnimationEnd {
            fab_microsoft.isClickable = !reverse
        })
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun LoginActivity.animatePhoneFab(reverse: Boolean = false) {
    val x = if (reverse) 100f else -300f
    val y = if (reverse) 0f else 400 / 1.5f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_phone.animate()
        .translationX(x)
        .translationY(y)
        .alpha(alpha)
        .setListener(onAnimationEnd {
            fab_phone.isClickable = !reverse
        })
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun LoginActivity.animateEmailFab(reverse: Boolean = false) {
    val x = if (reverse) 100f else -400f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_email.animate()
        .translationX(x)
        .setListener(onAnimationEnd {
            fab_email.isClickable = !reverse
        })
        .alpha(alpha)
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()

}

internal fun LoginActivity.animateGoogleFab(reverse: Boolean = false) {
    val x = if (reverse) 100f else -300f
    val y = if (reverse) 0f else -400 / 1.5f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_google.animate()
        .translationX(x)
        .translationY(y)
        .alpha(alpha)
        .setListener(onAnimationEnd {
            fab_google.isClickable = !reverse
        })
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun LoginActivity.animateGithubFab(reverse: Boolean = false) {
    val y = if (reverse) 0f else -400f
    val alpha = if (reverse) 0f else 1f
    val startDelay = if (reverse) 200L else 500L

    fab_github.animate()
        .translationY(y)
        .setListener(onAnimationEnd {
            fab_github.isClickable = !reverse
        })
        .alpha(alpha)
        .setStartDelay(startDelay)
        .setDuration(500)
        .start()
}

internal fun onAnimationEnd(
    callback: () -> Unit
) = object : Animator.AnimatorListener {

    override fun onAnimationEnd(animation: Animator?) {
        callback()
    }

    override fun onAnimationCancel(animation: Animator?) {

    }

    override fun onAnimationStart(animation: Animator?) {

    }

    override fun onAnimationRepeat(animation: Animator?) {

    }
}

internal fun LoginActivity.launchAllFabs() {
    animateCenterImage()
    animateFacebookFab()
    animateTwitterFab()
    animateEmailFab()
    animatePhoneFab()
    animateGithubFab()
    animateYahooFab()
    animateGoogleFab()
    animateMicrosoftFab()
}

internal fun LoginActivity.hideAllFabs() {
    animateCenterImage(true)
    animateFacebookFab(true)
    animateTwitterFab(true)
    animateEmailFab(true)
    animatePhoneFab(true)
    animateGithubFab(true)
    animateYahooFab(true)
    animateGoogleFab(true)
    animateMicrosoftFab(true)
}