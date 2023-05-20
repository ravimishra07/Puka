package com.live.lukastore.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.live.lukastore.R
import com.live.lukastore.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
     lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
       // setSupportActionBar(binding)
    }
}