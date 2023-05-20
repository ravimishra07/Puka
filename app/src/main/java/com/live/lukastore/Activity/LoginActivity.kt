package com.live.lukastore.LogInSignUpSection.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.live.lukastore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        binding.btnSignUp.setOnClickListener {

        }
    }
}