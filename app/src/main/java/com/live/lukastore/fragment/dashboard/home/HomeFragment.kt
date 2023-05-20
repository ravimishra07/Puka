package com.live.lukastore.fragment.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.live.lukastore.adapter.HomeItemAdapter
import com.live.lukastore.core.BaseActivity
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentHomeBinding
import com.live.lukastore.model.HomeItem
import com.live.lukastore.util.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private  val homeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
      return  FragmentHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateRecyclerView()
    }
    private fun populateRecyclerView(){
        val items = listOf(
            HomeItem("New Order", 1, Constants.Colors.BLUE),
            HomeItem("Accepted Order", 2, Constants.Colors.RED),
            HomeItem("In Progress", 3, Constants.Colors.YELLOW),
            HomeItem("Ready For Delivery", 4, Constants.Colors.BLUE),
            HomeItem("Ready For Pickup", 5, Constants.Colors.RED),
            HomeItem("Completed", 6, Constants.Colors.YELLOW),

        )

        val homeAdapter = HomeItemAdapter(items)
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = homeAdapter
        }
    }

}
