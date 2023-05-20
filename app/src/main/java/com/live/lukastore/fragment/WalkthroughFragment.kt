package com.live.lukastore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.R
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentWalkthroughBinding

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
        with(binding){
            btnSignIn.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_login_signUp, SignInFragment()).addToBackStack(null).commit()
            }
            tvSignUp.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_login_signUp, SignUpFragment()).addToBackStack(null).commit()
            }
        }
    }
}