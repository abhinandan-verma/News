package com.abhinandan.news.network.repository

import androidx.compose.runtime.MutableState
import com.abhinandan.news.network.api.NewsAPI
import com.abhinandan.news.network.model.NewsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class Repository @Inject constructor(private val newsAPI: NewsAPI){

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: MutableStateFlow<List<String>>
        get() = _categories

    private val _news = MutableStateFlow<List<NewsItem>>(emptyList())
    val news: MutableStateFlow<List<NewsItem>>
        get() = _news

    suspend fun getCategories(){
        val response = newsAPI.getCategories()
        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)
        }
    }
    suspend fun getNews(category: String){
        val response = newsAPI.getNews("news[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null){
            _news.emit(response.body()!!)
        }
    }
}