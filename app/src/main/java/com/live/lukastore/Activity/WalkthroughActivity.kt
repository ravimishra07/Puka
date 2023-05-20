package com.live.lukastore.LogInSignUpSection.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.lukastore.databinding.ActivityWalkthoroughBinding

class WalkthroughActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWalkthoroughBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalkthoroughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClicks()
    }

    private fun onClicks() {
     binding.btnSignIn.setOnClickListener {
         startActivity(Intent(this, LoginActivity::class.java))
     }
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }
}