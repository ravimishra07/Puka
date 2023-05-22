package com.live.lukastore.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.live.lukastore.NavigationData
import com.live.lukastore.R
import com.live.lukastore.core.BaseActivity

import com.live.lukastore.databinding.ActivityLoginBinding
import com.live.lukastore.fragment.SignInFragment
import com.live.lukastore.fragment.VerificationFragment
import com.live.lukastore.util.FragmentType
import com.live.lukastore.util.show

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tb.customToolbar.show()
        binding.tb.toolbarTitle.text = getString(R.string.sign_in)
        setListeners()
    }

    private fun setListeners() {

        binding.apply {
            tb.backButton.setOnClickListener {
                finish()
            }
            tvForgotPassword.setOnClickListener {
                ForgotActivity.launch(this@LoginActivity)
            }
            btnLoginIn.setOnClickListener{
                VerificationActivity.launch(this@LoginActivity)
            }
        }

    }
    companion object {
        fun launch(activity: Activity) =
            activity.startActivity(Intent(activity, LoginActivity::class.java).apply {
                this.data = activity.intent.data
                activity.intent.extras?.let {
                    putExtras(it)
                }
            })
    }
}