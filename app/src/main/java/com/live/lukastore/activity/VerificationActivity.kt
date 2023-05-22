package com.live.lukastore.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.lukastore.R
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.databinding.ActivityForgotBinding
import com.live.lukastore.databinding.ActivityVerificationBinding
import com.live.lukastore.fragment.VerificationFragment
import com.live.lukastore.util.show

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tb.customToolbar.show()
        binding.tb.toolbarTitle.text = getString(R.string.verification)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnVerify.setOnClickListener {
                DashboardActivity.launch(this@VerificationActivity)
            }
            tb.backButton.setOnClickListener {
                finish()
            }
        }
    }
       companion object {
        fun launch(activity: Activity) =
            activity.startActivity(Intent(activity, VerificationActivity::class.java).apply {
                this.data = activity.intent.data
                activity.intent.extras?.let {
                    putExtras(it)
                }
            })
    }
}