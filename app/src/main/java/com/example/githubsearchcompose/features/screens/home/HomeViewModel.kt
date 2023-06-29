package com.example.githubsearchcompose.features.screens.home

import com.example.githubsearchcompose.features.base.BaseViewModel
import com.example.githubsearchcompose.features.base.IEffect
import com.example.githubsearchcompose.features.base.IEvent
import com.example.githubsearchcompose.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>() {

    override fun setInitialState() = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            else -> {}
        }
    }
}


data class HomeState(
    val isLoading: Boolean = true,
) : IState

sealed interface HomeEffect : IEffect

sealed interface HomeEvent : IEvent