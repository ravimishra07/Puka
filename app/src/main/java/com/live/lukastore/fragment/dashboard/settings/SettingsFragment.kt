package com.live.lukastore.fragment.dashboard.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentProfileBinding
import com.live.lukastore.databinding.FragmentSettingsBinding
import com.live.lukastore.fragment.dashboard.home.HomeViewModel

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(layoutInflater)
    }
}