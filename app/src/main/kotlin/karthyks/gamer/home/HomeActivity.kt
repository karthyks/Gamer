package karthyks.gamer.home

import android.content.Intent
import android.os.Bundle
import com.github.karthyks.gamer.R
import com.google.firebase.auth.FirebaseAuth
import karthyks.gamer.BaseActivity
import karthyks.gamer.login.LoginActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        auth = FirebaseAuth.getInstance()
        tvUsername.text = auth.currentUser?.displayName ?: "UnKnown"

        btnLogout.setOnClickListener {
            auth.signOut()
            relaunchApp()
        }
    }

    private fun relaunchApp() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}