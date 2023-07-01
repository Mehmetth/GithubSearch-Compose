package com.example.githubsearchcompose.domain

import com.example.githubsearchcompose.data.model.Resource
import com.example.githubsearchcompose.data.model.SearchResponse
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val githubComposeRepository: GithubComposeRepository,
) {
    operator fun invoke(query: String, page: String): Flow<UsersState> = callbackFlow {
        githubComposeRepository.search(query, page).collect { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        if (it.items.isNotEmpty()) {
                            trySend(
                                UsersState.Success(it)
                            )
                        } else {
                            trySend(
                                UsersState.NotFoundUsers
                            )
                        }
                    } ?: kotlin.run {
                        trySend(
                            UsersState.NotFoundUsers
                        )
                    }
                }

                is Resource.Error,
                is Resource.Fail -> {
                    trySend(UsersState.Error(result.message))
                }
            }
        }
        awaitClose { cancel() }
    }

    sealed interface UsersState {
        class Success(val searchResponse: SearchResponse) : UsersState
        object NotFoundUsers : UsersState
        class Error(val throwable: Throwable?) : UsersState
    }
}
