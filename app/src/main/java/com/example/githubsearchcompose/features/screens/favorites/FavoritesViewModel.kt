package com.example.githubsearchcompose.features.screens.favorites

import com.example.githubsearchcompose.features.base.BaseViewModel
import com.example.githubsearchcompose.features.base.IEffect
import com.example.githubsearchcompose.features.base.IEvent
import com.example.githubsearchcompose.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
) : BaseViewModel<FavoritesState, FavoritesEvent, FavoritesEffect>() {

    override fun setInitialState() = FavoritesState()

    override fun handleEvents(event: FavoritesEvent) {
        when (event) {
            else -> {}
        }
    }
}


data class FavoritesState(
    val isLoading: Boolean = true,
) : IState

sealed interface FavoritesEffect : IEffect

sealed interface FavoritesEvent : IEvent