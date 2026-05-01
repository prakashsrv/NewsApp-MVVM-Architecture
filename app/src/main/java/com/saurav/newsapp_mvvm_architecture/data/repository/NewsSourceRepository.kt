package com.saurav.newsapp_mvvm_architecture.data.repository

import com.saurav.newsapp_mvvm_architecture.data.api.NetworkService
import com.saurav.newsapp_mvvm_architecture.data.model.Source
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NewsSourceRepository@Inject constructor(
    private val networkService: NetworkService
) {
    fun getNewsSource(): Flow<List<Source>> = flow {

        val response = networkService.getNewsSources()
        if(response.status == "ok")
        {
            emit(response.sources?: emptyList())
        }
        else{
            throw Exception(response.message?:"Unknown error")
        }


    }
}