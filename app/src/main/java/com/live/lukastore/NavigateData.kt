package com.live.lukastore

import com.live.lukastore.util.FragmentType
import java.io.Serializable

data class NavigationData(
    val fragmentType: FragmentType,
    val showToolbar: Boolean = true,
    val fragmentTitle: String = "",
    val showBackButton: Boolean = false,
    val replaceContainer:Boolean = false
): Serializable
