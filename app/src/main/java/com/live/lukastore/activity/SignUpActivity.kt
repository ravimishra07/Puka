package com.live.lukastore.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.live.lukastore.R
import com.live.lukastore.databinding.ActivityLoginBinding
import com.live.lukastore.databinding.ActivitySignInBinding
import com.live.lukastore.databinding.ActivitySignUpBinding
import com.live.lukastore.fragment.VerificationFragment
import com.live.lukastore.util.show

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tb.customToolbar.show()
        binding.tb.toolbarTitle.text = getString(R.string.sign_up)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnSignUp.setOnClickListener {
                 VerificationActivity.launch(this@SignUpActivity)
            }
            tb.backButton.setOnClickListener {
                finish()
            }
        }
    }
    companion object {
        fun launch(activity: Activity) =
            activity.startActivity(Intent(activity, SignUpActivity::class.java).apply {
                this.data = activity.intent.data
                activity.intent.extras?.let {
                    putExtras(it)
                }
            })
    }
}