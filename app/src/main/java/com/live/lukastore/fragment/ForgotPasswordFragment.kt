package com.live.lukastore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.NavigationData
import com.live.lukastore.R
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentForgotPasswordBinding
import com.live.lukastore.util.FragmentType

class ForgotPasswordFragment : BaseFragment<FragmentForgotPasswordBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentForgotPasswordBinding {
        return FragmentForgotPasswordBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners(){
        binding.btnSubmit.setOnClickListener{
            navigate?.moveToFragment(NavigationData(FragmentType.VERIFICATION, true, getString(R.string.verification)))
        }
    }
}