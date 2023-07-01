package com.example.githubsearchcompose.domain

import com.example.githubsearchcompose.data.model.Resource
import com.example.githubsearchcompose.data.model.SearchResponse
import com.example.githubsearchcompose.data.model.UserDetailResponse
import kotlinx.coroutines.flow.Flow

interface GithubComposeRepository {
    fun search(query: String, page: String): Flow<Resource<SearchResponse>>
    fun userDetail(login: String): Flow<Resource<UserDetailResponse>>
}