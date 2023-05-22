package com.live.lukastore.fragment.dashboard.products

import android.view.LayoutInflater
import android.view.ViewGroup
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentProductBinding

class ProductsFragment : BaseFragment<FragmentProductBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProductBinding {
        return FragmentProductBinding.inflate(layoutInflater)
    }
}