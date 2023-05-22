package com.live.lukastore.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.live.lukastore.Navigation
import com.live.lukastore.NavigationData
import com.live.lukastore.R
import com.live.lukastore.databinding.ActivityDashboardBinding
import com.live.lukastore.fragment.SignInFragment
import com.live.lukastore.fragment.dashboard.home.HomeFragment
import com.live.lukastore.fragment.dashboard.orders.OrdersFragment
import com.live.lukastore.fragment.dashboard.products.ProductsFragment
import com.live.lukastore.fragment.dashboard.profile.ProfileFragment
import com.live.lukastore.fragment.dashboard.settings.SettingsFragment
import com.live.lukastore.util.Constants
import com.live.lukastore.util.FragmentType

class DashboardActivity : AppCompatActivity(), Navigation {

    lateinit var binding: ActivityDashboardBinding
    var selectedFragment = FragmentType.MENU_HOME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationData = NavigationData(FragmentType.HOME, false)
        loadFragment(navigationData)
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            menuHome.setOnClickListener {
                openSelectedFragment(FragmentType.HOME)
            }
            menuProduct.setOnClickListener {
               // openSelectedFragment(FragmentType.MENU_PRODUCTS)
            }
            menuProfile.setOnClickListener {
               // openSelectedFragment(FragmentType.MENU_PROFILE)
            }
            menuSettings.setOnClickListener {
              //  openSelectedFragment(FragmentType.MENU_SETTING)
            }
            addProductButton.setOnClickListener {
               AddProductActivity.launch(this@DashboardActivity)
            }
        }
    }
    private fun updateBottomMenu() {
        binding.apply {
            setMenu(ivMenuHome, tvMenuHome, R.color.text_grey)
            setMenu(ivMenuProduct, tvMenuProduct, R.color.text_grey)
            setMenu(ivMenuProfile, tvMenuProfile, R.color.text_grey)
            setMenu(ivMenuSettings, tvMenuSettings, R.color.text_grey)

            when (selectedFragment) {
                FragmentType.MENU_HOME -> {
                    setMenu(ivMenuHome, tvMenuHome, R.color.app_red)
                }

                FragmentType.MENU_PRODUCTS -> {
                    setMenu(ivMenuProduct, tvMenuProduct, R.color.app_red)
                }

                FragmentType.MENU_PROFILE -> {
                    setMenu(ivMenuProfile, tvMenuProfile, R.color.app_red)
                }

                FragmentType.MENU_SETTING -> {
                    setMenu(ivMenuSettings, tvMenuSettings, R.color.app_red)
                }

                else -> {
                    setMenu(ivMenuHome, tvMenuHome, R.color.app_red)
                }

            }
        }
    }

    private fun openSelectedFragment(fragmentType: FragmentType){
        selectedFragment = fragmentType
        updateBottomMenu()
        val navigationData = NavigationData(fragmentType,false, replaceContainer = true)
        loadFragment(navigationData)
    }

    fun setMenu(iv: ImageView, tv: TextView, color: Int) {
        val tintColor = ContextCompat.getColor(this, color)
        iv.setColorFilter(tintColor)
        tv.setTextColor(tintColor)
    }

    private fun loadFragment(
        navigationData: NavigationData
    ) {
        val fragBundle = Bundle()
        fragBundle.putSerializable(Constants.NAVIGATION_DATA, navigationData)
        val fragment = when (navigationData.fragmentType) {
            FragmentType.HOME -> HomeFragment()
            FragmentType.PRODUCT -> ProductsFragment()
            FragmentType.PROFILE -> ProfileFragment()
            FragmentType.SETTINGS -> SettingsFragment()

            FragmentType.NEW,
            FragmentType.ACCEPTED,
            FragmentType.COMPLETED,
            FragmentType.IN_PROGRESS,
            FragmentType.READY_FOR_DELIVERY,
            FragmentType.PICKUP,

            FragmentType.IN_PROGRESS_DETAIL,
            FragmentType.COMPLETED_DETAIL,
            FragmentType.ACCEPTED_DETAIL,
            FragmentType.PICK_UP_DETAIL -> OrdersFragment()

            else -> {
                // if this condition is triggered then you might have missed adding a fragment in above block
                ProductsFragment()
            }
        }.apply { navigate = this@DashboardActivity }
        if (navigationData.replaceContainer) {
            replaceFragment(fragment, fragBundle)
        } else {
            addFragment(fragment, fragBundle)
        }
    }

    private fun replaceFragment(fragment: Fragment, fragBundle: Bundle? = null) {
        fragment.arguments = fragBundle
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, fragment)
            .commit()
    }

    private fun addFragment(fragment: Fragment, fragBundle: Bundle? = null) {
        fragment.arguments = fragBundle
        supportFragmentManager.beginTransaction()
            .add(binding.container.id, fragment)
            .addToBackStack("")
            .commit()
    }

    override fun moveToFragment(navigationData: NavigationData) {
        loadFragment(navigationData)
    }
    companion object {
        fun launch(activity: Activity) =
            activity.startActivity(Intent(activity, DashboardActivity::class.java).apply {
                this.data = activity.intent.data
                activity.intent.extras?.let {
                    putExtras(it)
                }
            })
    }
}