package com.live.lukastore

import com.live.lukastore.model.OrderItem
import com.live.lukastore.util.FragmentType
import java.text.FieldPosition

interface OrderListeners {
    fun onItemClicked(position: Int,orderItem: OrderItem?=null,orderDetailItem: OrderItem?=null )
    fun onItemClicked(position: Int)

}