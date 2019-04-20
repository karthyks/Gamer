package karthyks.gamer.login

import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import karthyks.gamer.login.facebook.handleAccessToken

sealed class LoginProvider(val auth: FirebaseAuth, val result: (Task<AuthResult>) -> Unit)

class Facebook(
    auth: FirebaseAuth,
    val facebookLoginButton: LoginButton,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback) {

    init {
        LoginManager.getInstance().logOut()
    }

    val manager: CallbackManager by lazy {
        CallbackManager.Factory.create()
    }

    val loginCallback by lazy {
        object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult?) {
                Log.d("Login", "Access Token $result")
                handleAccessToken(result?.accessToken)
            }

            override fun onCancel() {
                Log.d("Login", "Access Token Canceled")
            }

            override fun onError(error: FacebookException?) {
                Log.d("Login", "Access Token $error")
            }
        }
    }
}

class Twitter(
    auth: FirebaseAuth,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback)

class Google(
    auth: FirebaseAuth,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback)

class Github(
    auth: FirebaseAuth,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback)

class Yahoo(
    auth: FirebaseAuth,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback)

class Microsoft(
    auth: FirebaseAuth,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback)

class Email(
    auth: FirebaseAuth,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback)

class Phone(
    auth: FirebaseAuth,
    callback: (Task<AuthResult>) -> Unit = {}
) : LoginProvider(auth, callback)