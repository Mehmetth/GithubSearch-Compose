package com.example.githubsearchcompose.features.screens.home

import androidx.lifecycle.viewModelScope
import com.example.githubsearchcompose.domain.UsersUseCase
import com.example.githubsearchcompose.features.base.BaseViewModel
import com.example.githubsearchcompose.features.base.IEffect
import com.example.githubsearchcompose.features.base.IEvent
import com.example.githubsearchcompose.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>() {

    init {
        search("Mehmetth", "1")
    }

    override fun setInitialState() = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            else -> {}
        }
    }

    private fun search(query: String, page: String) {
        viewModelScope.launch {
            usersUseCase.invoke(query, page).collect {
                when (it) {
                    is UsersUseCase.UsersState.Success -> {
                        setState(HomeState(isLoading = false))
                    }

                    UsersUseCase.UsersState.NotFoundUsers -> {
                        setState(HomeState(isLoading = false))
                    }

                    is UsersUseCase.UsersState.Error -> {
                        setState(HomeState(isLoading = false))
                    }
                }
            }
        }
    }
}


data class HomeState(
    val isLoading: Boolean = true,
) : IState

sealed interface HomeEffect : IEffect

sealed interface HomeEvent : IEvent