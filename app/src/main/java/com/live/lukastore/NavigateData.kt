package com.live.lukastore

import com.live.lukastore.model.ButtonInfo
import com.live.lukastore.model.OrderDetailsItem
import com.live.lukastore.model.OrderItem
import com.live.lukastore.util.FragmentType
import java.io.Serializable

data class NavigationData(
    val fragmentType: FragmentType,
    val showToolbar: Boolean = true,
    val fragmentTitle: String = "",
    val showBackButton: Boolean = false,
    val replaceContainer: Boolean = false,
    val isDetailScreen: Boolean = false,
    val orderItem: OrderItem? = null,
    val orderDetailsItem: OrderDetailsItem? = null,
    val buttonInfo: ButtonInfo? = null
) : Serializable
