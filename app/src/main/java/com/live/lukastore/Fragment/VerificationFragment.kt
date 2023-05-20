package com.live.lukastore.LogInSignUpSection.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.lukastore.R
import com.live.lukastore.databinding.FragmentVerificationBinding


class VerificationFragment : Fragment() {
    lateinit var binding:FragmentVerificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentVerificationBinding.inflate(layoutInflater)
         return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tb.apply {
            tvHeading.visibility=View.VISIBLE
            tvHeading.text ="Verification"
        }
    }
}