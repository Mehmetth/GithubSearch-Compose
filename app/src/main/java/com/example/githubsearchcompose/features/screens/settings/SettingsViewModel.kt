package com.example.githubsearchcompose.features.screens.settings

import com.example.githubsearchcompose.features.base.BaseViewModel
import com.example.githubsearchcompose.features.base.IEffect
import com.example.githubsearchcompose.features.base.IEvent
import com.example.githubsearchcompose.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
) : BaseViewModel<SettingsState, SettingsEvent, SettingsEffect>() {

    override fun setInitialState() = SettingsState()

    override fun handleEvents(event: SettingsEvent) {
        when (event) {
            else -> {}
        }
    }
}


data class SettingsState(
    val isLoading: Boolean = true,
) : IState

sealed interface SettingsEffect : IEffect

sealed interface SettingsEvent : IEvent