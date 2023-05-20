package com.live.lukastore.LogInSignUpSection.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.R
import com.live.lukastore.databinding.FragmentForgotPasswordBinding


class ForgotPasswordFragment : Fragment() {
    lateinit var binding: FragmentForgotPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tb.apply {
            tvHeading.visibility=View.VISIBLE
            tvHeading.text="Forgot password"
        }
    }
}