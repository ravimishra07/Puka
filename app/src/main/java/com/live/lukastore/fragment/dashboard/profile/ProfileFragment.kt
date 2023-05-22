package com.live.lukastore.fragment.dashboard.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
    }
}