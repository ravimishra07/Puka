package com.live.lukastore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentVerificationBinding


class VerificationFragment : BaseFragment<FragmentVerificationBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentVerificationBinding {
        return FragmentVerificationBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}