package com.live.lukastore.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.live.lukastore.NavigationData
import com.live.lukastore.R
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.databinding.ActivityForgotBinding
import com.live.lukastore.util.show

class ForgotActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityForgotBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tb.customToolbar.show()
        binding.tb.toolbarTitle.text = getString(R.string.forgot_password)
        setListeners()
    }

    private fun setListeners() {
        binding.tb.backButton.setOnClickListener {
            finish()
        }
    }
    companion object {
        fun launch(activity: Activity) =
            activity.startActivity(Intent(activity, ForgotActivity::class.java).apply {
                this.data = activity.intent.data
                activity.intent.extras?.let {
                    putExtras(it)
                }
            })
    }
}