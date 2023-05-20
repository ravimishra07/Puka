package com.live.lukastore.LogInSignUpSection.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.R
import com.live.lukastore.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tb.apply {
            tvHeading.visibility = View.VISIBLE
            tvHeading.text = "sign In"
            ivBack.setOnClickListener {
            }
        }
        initListener()
    }

    private fun initListener() {
        with(binding) {
            tvForgotPassword.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_login_signUp, ForgotPasswordFragment()).addToBackStack(null)
                    .commit()
            }

        }
    }
}