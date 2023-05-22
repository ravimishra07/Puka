package com.live.lukastore.model

import java.io.Serializable

data class OrderItem(
    val orderId: Int,
    val orderStatus: String,
    val orderItemCount: Int,
    val dateLabel: Long,
    val itemImageUrl: String
):Serializable
