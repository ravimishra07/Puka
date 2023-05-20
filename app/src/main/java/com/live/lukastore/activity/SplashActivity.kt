package com.live.lukastore.activity

import android.os.Bundle
import android.view.View
import com.live.lukastore.NavigationData
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.databinding.ActivitySpalashBinding
import com.live.lukastore.util.Constants
import com.live.lukastore.util.FragmentType
import com.live.lukastore.util.delay

class SplashActivity : BaseActivity() {
    lateinit var binding: ActivitySpalashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parentBinding.tb.customToolbar.visibility = View.GONE
        onClick()
    }
    private fun onClick() {
        delay(3000) {
            val navigationData = NavigationData(FragmentType.HOME,false)
            intent?.apply {
                putExtra(Constants.NAVIGATION_DATA, navigationData)
            }
            launch(this)
        }
    }
}