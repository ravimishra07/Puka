package com.live.lukastore.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.NavigationData
import com.live.lukastore.R
import com.live.lukastore.activity.DashboardActivity
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentVerificationBinding
import com.live.lukastore.util.FragmentType


class VerificationFragment : BaseFragment<FragmentVerificationBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentVerificationBinding {
        return FragmentVerificationBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }
    private fun initListener() {
        binding.apply{
            btnVerify.setOnClickListener {
                startActivity(Intent(requireActivity(),DashboardActivity::class.java))
            }
        }
    }

}