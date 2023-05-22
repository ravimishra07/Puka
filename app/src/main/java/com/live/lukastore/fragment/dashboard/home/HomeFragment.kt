package com.live.lukastore.fragment.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.live.lukastore.NavigationData
import com.live.lukastore.OrderListeners
import com.live.lukastore.activity.DashboardActivity
import com.live.lukastore.adapter.HomeItemAdapter
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentHomeBinding
import com.live.lukastore.model.ButtonInfo
import com.live.lukastore.model.HomeItem
import com.live.lukastore.model.OrderItem
import com.live.lukastore.util.Constants
import com.live.lukastore.util.FragmentType

class HomeFragment : BaseFragment<FragmentHomeBinding>(), OrderListeners {
    var items = emptyList<HomeItem>()
    private val homeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {

        return FragmentHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateRecyclerView()
    }

    private fun populateRecyclerView() {
        items = listOf(
            HomeItem("New Order", 1, Constants.Colors.BLUE),
            HomeItem("Accepted Order", 2, Constants.Colors.RED),
            HomeItem("In Progress", 3, Constants.Colors.YELLOW),
            HomeItem("Ready For Delivery", 4, Constants.Colors.BLUE),
            HomeItem("Ready For Pickup", 5, Constants.Colors.RED),
            HomeItem("Completed", 6, Constants.Colors.YELLOW),
        )

        val homeAdapter = HomeItemAdapter(items, this)
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = homeAdapter
        }
    }

    override fun onItemClicked(position: Int, orderItem: OrderItem?, orderDetailItem: OrderItem?) {

    }

    override fun onItemClicked(position: Int) {
        val fragmentType = getFragmentTypeFromID(position)
        if (fragmentType == FragmentType.NONE) return
        val navigationData = NavigationData(
            fragmentType,
            true,
            replaceContainer = false,
            fragmentTitle = items[position].title,
            showBackButton = true
        )
        (requireActivity() as? DashboardActivity)?.binding?.containerFrame?.removeAllViews()
        navigate?.moveToFragment(navigationData)
    }

    private fun getFragmentTypeFromID(pos: Int): FragmentType { // or could be from index?
        return when (pos) {
            0 -> FragmentType.NEW
            1 -> FragmentType.ACCEPTED
            2 -> FragmentType.IN_PROGRESS
            3 -> FragmentType.READY_FOR_DELIVERY
            4 -> FragmentType.PICKUP
            5 -> FragmentType.COMPLETED
            else -> FragmentType.NONE
        }
    }

    override fun onDestroyView() {
        (requireActivity() as? DashboardActivity)?.binding?.container?.removeAllViews()
        super.onDestroyView()
    }
}
