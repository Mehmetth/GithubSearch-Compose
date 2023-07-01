package com.example.githubsearchcompose.data

import javax.inject.Inject

class GithubComposeDataSource @Inject constructor(private val githubComposeService: GithubComposeService) {

    suspend fun search(query: String, page: String) = githubComposeService.search(
        query, page
    )

    suspend fun userDetail(login: String) = githubComposeService.userDetail(login)
}