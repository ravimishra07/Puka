package com.live.lukastore.LogInSignUpSection.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.lukastore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }
}