package karthyks.gamer.login.facebook

import android.content.Intent
import android.util.Log
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import karthyks.gamer.login.Facebook


fun Facebook.initialize() {
    facebookLoginButton.setReadPermissions("email", "public_profile")
    facebookLoginButton.registerCallback(manager, loginCallback)
}

fun Facebook.redirectActivityResultToFacebookLogin(
    requestCode: Int,
    resultCode: Int,
    data: Intent?
) {
    manager.onActivityResult(requestCode, resultCode, data)
}

fun Facebook.clear() {
    facebookLoginButton.clearPermissions()
    facebookLoginButton.unregisterCallback(manager)
}

fun Facebook.handleAccessToken(
    token: AccessToken?
) {
    Log.d("FacebookLogin", "handleAccessToken $token")
    if (token == null) {
        return
    }
    val credential = FacebookAuthProvider.getCredential(token.token)
    auth.signInWithCredential(credential)
        .addOnCompleteListener {
            result(it)
        }
}