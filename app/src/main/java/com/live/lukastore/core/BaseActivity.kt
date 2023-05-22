package com.live.lukastore.core

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.live.lukastore.Navigation
import com.live.lukastore.NavigationData
import com.live.lukastore.databinding.ActivityBaseBinding
import com.live.lukastore.fragment.ForgotPasswordFragment
import com.live.lukastore.fragment.SignInFragment
import com.live.lukastore.fragment.SignUpFragment
import com.live.lukastore.fragment.VerificationFragment
import com.live.lukastore.fragment.WalkthroughFragment
import com.live.lukastore.fragment.dashboard.home.HomeFragment
import com.live.lukastore.util.*
import kotlinx.coroutines.joinAll

open class BaseActivity : AppCompatActivity(), Navigation {
    lateinit var parentBinding: ActivityBaseBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentBinding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(parentBinding.root)
        toolbar = parentBinding.tb.customToolbar
        setSupportActionBar(toolbar)
        parentBinding.tb.customToolbar.hide()
        val navigationData =
            intent?.extras?.serializable(Constants.NAVIGATION_DATA) as? NavigationData
        navigationData?.let {
            showToolBar(it)
            loadFragment(it.fragmentType, it.replaceContainer)
        }
        parentBinding.tb.backButton.setOnClickListener{
            supportFragmentManager.popBackStack()
        }
    }

    private fun showToolBar(
        navigationData: NavigationData
    ) {
        parentBinding.tb.apply {
            customToolbar.shouldShow(navigationData.showToolbar)
            backButton.shouldShow(navigationData.showBackButton)
            toolbarTitle.text = navigationData.fragmentTitle
        }
    }

    private fun loadFragment(fragmentType: FragmentType,replace:Boolean, fragBundle: Bundle? = null) {
        val fragment = when (fragmentType) {
            FragmentType.LOGIN_FRAGMENT -> SignInFragment()
            FragmentType.SIGN_UP_FRAGMENT -> SignUpFragment()
            FragmentType.WALK_THROUGH -> WalkthroughFragment()
            FragmentType.FORGOT_PASSWORD -> ForgotPasswordFragment()
            FragmentType.HOME -> HomeFragment()
            FragmentType.VERIFICATION -> VerificationFragment()
            else -> {
                // if this condition is triggered then you might have missed adding a fragment in above block
                SignInFragment()
            }
        }.apply { navigate = this@BaseActivity }
        if (replace){
            replaceFragment(fragment, fragBundle)
        }else{
            addFragment(fragment, fragBundle)
        }
    }

    private fun replaceFragment(fragment: Fragment, fragBundle: Bundle? = null) {
        fragment.arguments = fragBundle
        supportFragmentManager.beginTransaction()
            .replace(parentBinding.container.id, fragment)
            .commit()
    }

    private fun addFragment(fragment: Fragment, fragBundle: Bundle? = null) {
        fragment.arguments = fragBundle
        supportFragmentManager.beginTransaction()
            .add(parentBinding.container.id, fragment)
            .addToBackStack(null)

            .commit()
    }
    override fun moveToFragment(navigationData: NavigationData) {
        showToolBar(navigationData)
        loadFragment(navigationData.fragmentType,navigationData.replaceContainer)
    }

    companion object {
        fun launch(activity: Activity) =
            activity.startActivity(Intent(activity, BaseActivity::class.java).apply {
                this.data = activity.intent.data
                activity.intent.extras?.let {
                    putExtras(it)
                }
            })
    }
}