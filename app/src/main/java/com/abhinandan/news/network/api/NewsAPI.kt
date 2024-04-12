package com.abhinandan.news.network.api



import com.abhinandan.news.network.model.NewsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface NewsAPI {
    @GET("/v3/b/6597c06b1f5677401f17c305?meta=false")
    suspend fun getNews(@Header("X-JSON-Path") category: String): Response<List<NewsItem>>

    @GET("/v3/b/6597c06b1f5677401f17c305?meta=false")
    @Headers("X-JSON-Path:news..category")
    suspend fun getCategories(): Response<List<String>>
}