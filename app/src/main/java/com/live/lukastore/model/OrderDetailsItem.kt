package com.live.lukastore.model

import java.io.Serializable

data class OrderDetailsItem(
    val itemTitle: String,
    val itemId: Int,
    val itemPrice: String,
    val ItemCount: Int,
    val itemImageUrl: String
): Serializable
