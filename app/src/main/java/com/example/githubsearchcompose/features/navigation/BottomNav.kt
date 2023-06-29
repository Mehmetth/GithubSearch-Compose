package com.example.githubsearchcompose.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.githubsearchcompose.R


enum class BottomNav(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {
    HOME(
        homeNavigationRoute,
        R.drawable.ic_home,
        R.string.home,
    ),
    FAVORITES(
        favoritesNavigationRoute,
        R.drawable.ic_favorites,
        R.string.favorites,
    ),
    SETTINGS(
        settingsNavigationRoute,
        R.drawable.ic_settings,
        R.string.settings
    )
}