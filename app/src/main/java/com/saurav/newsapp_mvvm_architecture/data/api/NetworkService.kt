package com.saurav.newsapp_mvvm_architecture.data.api


import com.saurav.newsapp_mvvm_architecture.data.model.SourcesResponse
import com.saurav.newsapp_mvvm_architecture.data.model.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String = "us",
                                @Query("sources") sources: String = "",
                                @Query("language") language: String = "en",
    ): TopHeadlinesResponse

    @GET("sources")
    suspend fun getNewsSources(): SourcesResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("pageSize") pageSize: Int = 20,
        @Query("page") page: Int = 1,
        @Query("sortBy") sortBy: String = "publishedAt"
    ): TopHeadlinesResponse
}