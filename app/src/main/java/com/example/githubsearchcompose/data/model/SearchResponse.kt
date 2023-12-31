package com.example.githubsearchcompose.data.model

import androidx.compose.runtime.Stable

@Stable
data class SearchResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<Users>
)

@Stable
data class Users(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean,
    val score: Int,
    var favorite: Boolean = false
)