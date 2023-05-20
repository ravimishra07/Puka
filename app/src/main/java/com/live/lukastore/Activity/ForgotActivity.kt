package com.live.lukastore.LogInSignUpSection.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.lukastore.R
import com.live.lukastore.databinding.ActivityForgotBinding


class ForgotActivity : AppCompatActivity() {
    private lateinit var binding:ActivityForgotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityForgotBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}