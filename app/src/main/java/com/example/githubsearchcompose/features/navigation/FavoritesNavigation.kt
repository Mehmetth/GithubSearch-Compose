package com.example.githubsearchcompose.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.githubsearchcompose.features.screens.favorites.FavoritesScreenRoute
import com.google.accompanist.navigation.animation.composable

const val favoritesNavigationRoute = "favorites_route"

fun NavController.navigateToFavorites(
    navOptions: NavOptions? = null
) {
    this.navigate(favoritesNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.favoritesScreen() {
    composable(route = favoritesNavigationRoute) {
        FavoritesScreenRoute()
    }
}