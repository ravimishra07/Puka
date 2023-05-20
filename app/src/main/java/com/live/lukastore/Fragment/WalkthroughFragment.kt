package com.live.lukastore.LogInSignUpSection.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.R
import com.live.lukastore.databinding.FragmentWalkthroughBinding

class WalkthroughFragment : Fragment() {
    lateinit var binding:FragmentWalkthroughBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding =  FragmentWalkthroughBinding.inflate(layoutInflater)
        return binding.root
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