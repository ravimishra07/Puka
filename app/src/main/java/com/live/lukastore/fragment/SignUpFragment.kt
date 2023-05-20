package com.live.lukastore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.live.lukastore.Navigation
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentSignInBinding
import com.live.lukastore.databinding.FragmentSignUpBinding


class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignUpBinding {
        return FragmentSignUpBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}