package com.madebydap.youdeserveit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.madebydap.youdeserveit.ui.authentication.RegisterScreen
import com.madebydap.youdeserveit.ui.home.HomeScreen
import com.madebydap.youdeserveit.ui.onboarding.OnBoardingScreen

@Composable
fun RootNavigation(
    modifier: Modifier = Modifier
) {
    // No generics needed anymore!
    val navController = rememberNavBackStack(NavScreen.OnBoardingNavScreen)

    NavDisplay(
        backStack = navController,
        onBack = { navController.removeLastOrNull() },
        entryProvider = { key ->
            // Cast the key to your sealed class to make the 'when' statement exhaustive
            when (key as NavScreen) {
                is NavScreen.OnBoardingNavScreen -> NavEntry(key) {
                    OnBoardingScreen(
                        onFinished = {
                            navController.add(NavScreen.RegisterNavScreen)
                        }
                    )
                }
                is NavScreen.HomeNavScreen -> NavEntry(key) {
                    HomeScreen()
                }
                is NavScreen.RegisterNavScreen -> NavEntry(key) {
                    RegisterScreen(
                        onNextClicked = {
                            navController.clear()
                            navController.add(NavScreen.HomeNavScreen)
                        }
                    )
                }
            }
        }
    )
}