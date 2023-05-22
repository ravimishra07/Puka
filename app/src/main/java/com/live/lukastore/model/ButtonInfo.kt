package com.live.lukastore.model

import com.live.lukastore.R
import java.io.Serializable

data class ButtonInfo(
    val pColor: Int = R.drawable.bg_btn_accept,
    val nColor: Int = R.drawable.bg_btn_decline,
    val pTitle: String = "Accept",
    val nTitle: String = "Decline",
    val showP:Boolean = false,
    val showN:Boolean = false
): Serializable
