package com.pecpacker.africaknow_game.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.pecpacker.africaknow_game.R

class SplashSActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 5000 // 1 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_s)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, AuthActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}
