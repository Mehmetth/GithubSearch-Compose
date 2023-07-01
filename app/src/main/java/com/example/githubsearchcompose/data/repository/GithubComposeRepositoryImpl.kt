package com.example.githubsearchcompose.data.repository

import com.example.githubsearchcompose.data.GithubComposeDataSource
import com.example.githubsearchcompose.data.model.Resource
import com.example.githubsearchcompose.data.model.SearchResponse
import com.example.githubsearchcompose.data.model.UserDetailResponse
import com.example.githubsearchcompose.domain.GithubComposeRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class GithubComposeRepositoryImpl @Inject constructor(private val githubComposeDataSource: GithubComposeDataSource) :
    GithubComposeRepository {

    override fun search(
        query: String, page: String
    ): Flow<Resource<SearchResponse>> =
        callbackFlow {
            val response = githubComposeDataSource.search(query, page)
            if (response.isSuccessful) {
                response.body()?.let {
                    trySend(Resource.Success(it))
                } ?: kotlin.run {
                    trySend(Resource.Fail(null))
                }
            } else {
                trySend(Resource.Error(null))
            }
            awaitClose { cancel() }
        }

    override fun userDetail(login: String): Flow<Resource<UserDetailResponse>> =
        callbackFlow {
            val response = githubComposeDataSource.userDetail(login)
            if (response.isSuccessful) {
                response.body()?.let {
                    trySend(Resource.Success(it))
                } ?: kotlin.run {
                    trySend(Resource.Fail(null))
                }
            } else {
                trySend(Resource.Error(null))
            }
            awaitClose { cancel() }
        }
}