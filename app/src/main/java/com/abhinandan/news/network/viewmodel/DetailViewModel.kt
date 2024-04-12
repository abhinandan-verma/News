package com.abhinandan.news.network.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinandan.news.network.model.NewsItem
import com.abhinandan.news.network.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository : Repository,
                                          private val savedStateHandle: SavedStateHandle)
    : ViewModel() {
    val news : StateFlow<List<NewsItem>>
        get() = repository.news

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Books"
            repository.getNews(category)
        }
    }
}