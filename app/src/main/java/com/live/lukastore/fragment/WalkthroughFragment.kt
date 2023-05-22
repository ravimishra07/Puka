package com.live.lukastore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.NavigationData
import com.live.lukastore.R
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentWalkthroughBinding
import com.live.lukastore.util.FragmentType

class WalkthroughFragment : BaseFragment<FragmentWalkthroughBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWalkthroughBinding {
        return FragmentWalkthroughBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.apply{
            btnSignIn.setOnClickListener {
                navigate?.moveToFragment(NavigationData(FragmentType.LOGIN_FRAGMENT,true,getString(R.string.sign_in),true))
           }
            tvSignUp.setOnClickListener {
                navigate?.moveToFragment(NavigationData(FragmentType.SIGN_UP_FRAGMENT,true,getString(R.string.sign_up),true))
            }
        }
    }
}