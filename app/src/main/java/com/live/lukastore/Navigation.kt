package com.live.lukastore

import com.live.lukastore.util.FragmentType

interface Navigation {
    fun moveToFragment(navigationData: NavigationData)
}