package com.live.lukastore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.live.lukastore.R
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.databinding.ActivityWalkthoroughBinding
import com.live.lukastore.util.Constants
import com.live.lukastore.util.FragmentType

//class WalkThroughActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityWalkthoroughBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityWalkthoroughBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        //showToolBar(false)
//        onClicks()
//    }
//
//    private fun onClicks() {
//     binding.btnSignIn.setOnClickListener {
//         intent?.apply {
//             putExtra(Constants.FRAGMENT_TYPE,FragmentType.LOGIN_FRAGMENT)
//             putExtra(Constants.FRAGMENT_TITLE,getString(R.string.sign_in))
//         }
//         BaseActivity.launch(this)
//     }
//        binding.tvSignUp.setOnClickListener {
//            startActivity(Intent(this, SignUpActivity::class.java))
//        }
//    }
//}