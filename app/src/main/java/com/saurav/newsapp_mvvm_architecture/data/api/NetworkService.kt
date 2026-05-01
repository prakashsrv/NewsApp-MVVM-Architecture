package com.saurav.newsapp_mvvm_architecture.data.api

import androidx.room.Query

interface NetworkService {


    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String = "us",
                                @Query("sources") sources: String = "",
                                @Query("language") language: String = "en",
    ): TopHeadlinesResponse


}