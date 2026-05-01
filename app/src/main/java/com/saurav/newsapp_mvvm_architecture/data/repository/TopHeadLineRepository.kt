package com.saurav.newsapp_mvvm_architecture.data.repository

import com.saurav.newsapp_mvvm_architecture.data.api.NetworkService
import com.saurav.newsapp_mvvm_architecture.data.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TopHeadLineRepository@Inject constructor(
    private val networkService: NetworkService
) {
    fun getTopHeadLine(country: String): Flow<List<Article>> = flow {

        val response = networkService.getTopHeadlines(country)
        emit(response.articles)
    }
}