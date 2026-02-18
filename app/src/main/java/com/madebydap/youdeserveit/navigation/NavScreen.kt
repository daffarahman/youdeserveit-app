package com.madebydap.youdeserveit.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface NavScreen : NavKey {
    @Serializable
    data object OnBoardingNavScreen : NavScreen
    @Serializable
    data object HomeNavScreen : NavScreen
    @Serializable
    data object RegisterNavScreen : NavScreen
}