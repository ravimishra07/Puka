package com.live.lukastore.LogInSignUpSection.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.live.lukastore.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
   ): View? {     binding = FragmentSignUpBinding.inflate(layoutInflater)
       return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tb.apply {
            tvHeading.visibility = View.VISIBLE
            tvHeading.text ="Sign Up"
            ivBack.setOnClickListener {

            }
        }

    }


}