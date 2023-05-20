package com.live.lukastore.LogInSignUpSection.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.live.lukastore.LogInSignUpSection.Fragment.WalkthroughFragment
import com.live.lukastore.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalash)

        onClick()
    }
    private fun onClick() {
        Handler(Looper.getMainLooper()).postDelayed({
          startActivity(Intent(this, WalkthroughActivity::class.java))
        }, 3000)
    }
}