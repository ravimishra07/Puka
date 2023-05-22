package com.live.lukastore.util

import java.io.Serializable

enum class FragmentType: Serializable {
    //OnbBoarding
    WALK_THROUGH,
    LOGIN_FRAGMENT,
    SIGN_UP_FRAGMENT,
    FORGOT_PASSWORD,
    VERIFICATION,
    //Dashboard
    HOME,
    PRODUCT,
    PROFILE,
    SETTINGS,
    //Orders
    NEW,
    NEW_DETAIL,
    ACCEPTED,
    ACCEPTED_DETAIL,
    IN_PROGRESS,
    IN_PROGRESS_DETAIL,
    READY_FOR_DELIVERY,
    READY_FOR_DELIVERY_DETAIL,
    PICKUP,
    PICK_UP_DETAIL,
    COMPLETED,
    COMPLETED_DETAIL,
    NONE,

    MENU_HOME,
    MENU_PRODUCTS,
    MENU_SETTING,
    MENU_PROFILE,

}
