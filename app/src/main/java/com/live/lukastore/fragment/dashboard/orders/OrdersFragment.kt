package com.live.lukastore.fragment.dashboard.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.live.lukastore.Navigation
import com.live.lukastore.NavigationData
import com.live.lukastore.OrderListeners
import com.live.lukastore.R
import com.live.lukastore.activity.DashboardActivity
import com.live.lukastore.adapter.HomeItemAdapter
import com.live.lukastore.adapter.OrderAdapter
import com.live.lukastore.adapter.OrderDetailsAdapter
import com.live.lukastore.core.BaseFragment
import com.live.lukastore.databinding.FragmentOrdersBinding
import com.live.lukastore.model.ButtonInfo
import com.live.lukastore.model.HomeItem
import com.live.lukastore.model.OrderDetailsItem
import com.live.lukastore.model.OrderItem
import com.live.lukastore.util.Constants
import com.live.lukastore.util.FragmentType
import com.live.lukastore.util.hide
import com.live.lukastore.util.serializable
import com.live.lukastore.util.setColoredCard
import com.live.lukastore.util.shouldShow
import com.live.lukastore.util.show

class OrdersFragment : BaseFragment<FragmentOrdersBinding>(), OrderListeners {
    private var items = emptyList<OrderItem>()
    var orderListItems = emptyList<OrderDetailsItem>()
    var isDetailFragment = false
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOrdersBinding {
        return FragmentOrdersBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tb.customToolbar.hide()
        initListeners()
        val navigationData = arguments?.serializable(Constants.NAVIGATION_DATA) as? NavigationData
        val buttonInfo = navigationData?.buttonInfo
        if (navigationData?.showToolbar == true) {
            binding.tb.customToolbar.show()
            binding.tb.toolbarTitle.text = navigationData.fragmentTitle
            binding.tb.backButton.show()
        }
        navigationData?.let {
            populateRecyclerView(navigationData)
        }
        buttonInfo?.let {
            setButtons(it)
        }
    }

    private fun setButtons(buttonInfo: ButtonInfo) {
        binding.apply {
            positiveButton.text = buttonInfo.pTitle
            negativeButton.text = buttonInfo.nTitle
            positiveButton.shouldShow(buttonInfo.showP)
            negativeButton.shouldShow(buttonInfo.showN)
            positiveButton.setBackgroundResource(buttonInfo.pColor)
            negativeButton.setBackgroundResource(buttonInfo.nColor)
        }
    }

    private fun initListeners() {
        binding.tb.backButton.setOnClickListener {
            popCurrentFragment()
        }
    }

    private fun populateRecyclerView(navigationData: NavigationData) {

//         isDetailFragment = navigationData.fragmentType == FragmentType.PICK_UP_DETAIL ||
//                navigationData.fragmentType == FragmentType.ACCEPTED_DETAIL ||
//                navigationData.fragmentType == FragmentType.COMPLETED_DETAIL ||
//                navigationData.fragmentType == FragmentType.IN_PROGRESS_DETAIL
        isDetailFragment = navigationData.isDetailScreen
        if (isDetailFragment) populateDetailAdapter(navigationData) else populateOrderAdapter(
            navigationData
        )
    }

    private fun populateOrderAdapter(navigationData: NavigationData) {
        val orderStatus = navigationData.fragmentTitle
        val items = listOf(
            OrderItem(2453534, orderStatus, 3, 1510500494, ""),
            OrderItem(2453534, orderStatus, 3, 1510500494, ""),
        )

        val orderAdapter = OrderAdapter(items, this)
        binding.rvContainer.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = orderAdapter
        }
    }

    private fun populateDetailAdapter(navigationData: NavigationData) {

        orderListItems = listOf(
            OrderDetailsItem("E-Juice", 132434, "$50.00", 2, ""),
            OrderDetailsItem("Hookah Tobacco", 762434, "$30.00", 5, ""),
            OrderDetailsItem("Hookah Tobacco", 186034, "$20.50", 1, ""),
        )

        val orderAdapter = OrderDetailsAdapter(orderListItems, this)
        binding.rvContainer.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = orderAdapter
        }
    }

    override fun onItemClicked(position: Int, orderItem: OrderItem?, orderDetailItem: OrderItem?) {
    }

    override fun onItemClicked(position: Int) {
        // isDetailFragment = true
        val fragmentType = getFragmentTypeFromID(position)
        if (fragmentType == FragmentType.NONE) return
        val buttonInfo = ButtonInfo(showP = true, showN = true)
        val navigationData = NavigationData(
            fragmentType,
            true,
            replaceContainer = false,
            fragmentTitle = binding.tb.toolbarTitle.text.toString(),
            showBackButton = true,
            isDetailScreen = true,
            buttonInfo = buttonInfo
        )

        (requireActivity() as? DashboardActivity)?.binding?.containerFrame?.removeAllViews()
        navigate?.moveToFragment(navigationData)
    }

    private fun getFragmentTypeFromID(
        pos: Int
    ): FragmentType { // or could be from index?
        return when (pos) {
            0 -> if (isDetailFragment) FragmentType.NEW_DETAIL else FragmentType.NEW
            1 -> if (isDetailFragment) FragmentType.ACCEPTED_DETAIL else FragmentType.ACCEPTED
            2 -> if (isDetailFragment) FragmentType.IN_PROGRESS_DETAIL else FragmentType.IN_PROGRESS
            3 -> if (isDetailFragment) FragmentType.READY_FOR_DELIVERY_DETAIL else FragmentType.READY_FOR_DELIVERY
            4 -> if (isDetailFragment) FragmentType.PICK_UP_DETAIL else FragmentType.PICKUP
            5 -> if (isDetailFragment) FragmentType.COMPLETED_DETAIL else FragmentType.COMPLETED
            else -> FragmentType.NONE
        }
    }
}