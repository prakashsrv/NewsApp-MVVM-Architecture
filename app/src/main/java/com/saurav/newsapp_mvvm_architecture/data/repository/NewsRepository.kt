package com.saurav.newsapp_mvvm_architecture.data.repository

import com.saurav.newsapp_mvvm_architecture.data.api.NetworkService
import com.saurav.newsapp_mvvm_architecture.data.model.Article
import com.saurav.newsapp_mvvm_architecture.data.model.Source
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NewsRepository @Inject constructor(
    private val networkService: NetworkService
) {
    suspend fun getNews(
        source: String? = null,
        country: String? = null,
        language: String? = null,
    ): Flow<List<Article>> = flow {
        try {
            val response = networkService.getTopHeadlines(
                country = country?:"",
                language = language?:"",
                sources = source?:"",
            )
            emit(response.articles)
        }catch (e: Exception)
        {
            throw e
        }
    }
}