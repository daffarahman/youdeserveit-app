package com.madebydap.youdeserveit.model

import com.madebydap.youdeserveit.R

data class OnBoardingModel(
    val imageRes: Int,
    val title: String,
    val description: String
)

val onBoardingList = listOf<OnBoardingModel>(
    OnBoardingModel(
        imageRes = R.drawable.ic_onboarding_1,
        title = "It's never about money",
        description = "Spending isn't always about money"
    ),
    OnBoardingModel(
        imageRes = R.drawable.ic_onboarding_2,
        title = "Spent without guilt",
        description = "Never felt guilty about what you deserve"
    ),
    OnBoardingModel(
        imageRes = R.drawable.ic_onboarding_3,
        title = "You deserve it",
        description = "Your effort, energy, money it'll eventually goes to a good thing"
    )
)