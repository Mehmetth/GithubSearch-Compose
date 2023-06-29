package com.example.githubsearchcompose.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.githubsearchcompose.features.screens.settings.SettingsScreenRoute
import com.google.accompanist.navigation.animation.composable

const val settingsNavigationRoute = "settings_route"

fun NavController.navigateToSettings(
    navOptions: NavOptions? = null
) {
    this.navigate(settingsNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingsScreen() {
    composable(route = settingsNavigationRoute) {
        SettingsScreenRoute()
    }
}