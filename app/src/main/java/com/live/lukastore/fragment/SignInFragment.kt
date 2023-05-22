package com.live.lukastore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.NavigationData
import com.live.lukastore.fragment.ForgotPasswordFragment
import com.live.lukastore.R
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentSignInBinding
import com.live.lukastore.util.Constants
import com.live.lukastore.util.FragmentType

class SignInFragment : BaseFragment<FragmentSignInBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignInBinding {
       return FragmentSignInBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.apply {
            tvForgotPassword.setOnClickListener {
                navigate?.moveToFragment(NavigationData(FragmentType.FORGOT_PASSWORD,true,getString(R.string.forgot_password),true))
            }
            btnLoginIn.setOnClickListener{
                navigate?.moveToFragment(NavigationData(FragmentType.VERIFICATION,true,getString(R.string.verification),true))
            }
        }
    }
}