package karthyks.gamer.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.github.karthyks.gamer.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import karthyks.gamer.BaseActivity
import karthyks.gamer.home.HomeActivity
import karthyks.gamer.login.facebook.clear
import karthyks.gamer.login.facebook.redirectActivityResultToFacebookLogin
import karthyks.gamer.login.view.hideAllFabs
import karthyks.gamer.login.view.launchAllFabs
import karthyks.gamer.login.view.showFacebookButton
import com.github.karthyks.networkstatus.NetworkStatus
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : BaseActivity() {

    var loginProvider: LoginProvider? = null

    private lateinit var auth: FirebaseAuth
    private lateinit var snackBar: Snackbar

    private lateinit var networkStatus: NetworkStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        snackBar = Snackbar.make(parentLayout, "Network Unavailable!", Snackbar.LENGTH_INDEFINITE)
        networkStatus = NetworkStatus(this) { isAvailable ->
            if (isAvailable) {
                callAfter(1000) {
                    snackBar.dismiss()
                }
            } else {
                snackBar.show()
            }
        }

        auth = FirebaseAuth.getInstance()

        callAfter(2000) {
            verifyLogin()
        }

        fab_facebook.setOnClickListener {
            loginProvider = Facebook(auth, btnFbLogin, ::onLoginResult)
            hideAllFabs()
            showFacebookButton(true)
        }

        fab_google.setOnClickListener {
            hideAllFabs()
        }

        fab_email.setOnClickListener {
            hideAllFabs()
        }

        fab_phone.setOnClickListener {
            hideAllFabs()
        }

        fab_microsoft.setOnClickListener {
            hideAllFabs()
        }

        fab_yahoo.setOnClickListener {
            hideAllFabs()
        }

        fab_twitter.setOnClickListener {
            hideAllFabs()
        }

        fab_github.setOnClickListener {
            hideAllFabs()
        }

        btnCancel.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginProvider?.let {
            when (it) {
                is Facebook -> {
                    it.redirectActivityResultToFacebookLogin(requestCode, resultCode, data)
                }
                is Twitter -> {

                }
                is Github -> {

                }
                is Phone -> {

                }
                is Email -> {

                }
                is Microsoft -> {

                }
                is Yahoo -> {

                }
                is Google -> {

                }
            }
        }
    }

    private fun verifyLogin() {
        progress.isVisible = false
        if (auth.currentUser != null) {
            launchApp()
        } else {
            launchAllFabs()
        }
    }

    private fun launchApp() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (loginProvider == null) {
            super.onBackPressed()
            return
        }
        loginProvider?.let {
            when (it) {
                is Facebook -> {
                    showFacebookButton(false)
                    it.clear()
                }
                is Twitter -> {

                }
                is Github -> {

                }
                is Phone -> {

                }
                is Email -> {

                }
                is Microsoft -> {

                }
                is Yahoo -> {

                }
                is Google -> {

                }
            }
        }.also {
            launchAllFabs()
            loginProvider = null
        }
    }

    private fun onLoginResult(result: Task<AuthResult>) {
        if (result.isSuccessful) {
            btnFbLogin.isVisible = false
            btnCancel.isVisible = false
            launchApp()
        } else {
            Log.d("OnLoginResult", "Exception ${result.exception}")
        }
    }
}