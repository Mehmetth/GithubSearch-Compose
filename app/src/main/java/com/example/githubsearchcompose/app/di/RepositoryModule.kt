package com.example.githubsearchcompose.app.di

import com.example.githubsearchcompose.data.GithubComposeDataSource
import com.example.githubsearchcompose.data.GithubComposeService
import com.example.githubsearchcompose.data.repository.GithubComposeRepositoryImpl
import com.example.githubsearchcompose.domain.GithubComposeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubComposeDataSource(
        githubComposeService: GithubComposeService,
    ): GithubComposeDataSource = GithubComposeDataSource(githubComposeService)

    @Provides
    @Singleton
    fun provideGithubComposeRepository(
        githubComposeDataSource: GithubComposeDataSource,
    ): GithubComposeRepository = GithubComposeRepositoryImpl(githubComposeDataSource)

}