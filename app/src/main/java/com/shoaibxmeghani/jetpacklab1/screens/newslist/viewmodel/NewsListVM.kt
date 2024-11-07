package com.shoaibxmeghani.jetpacklab1.screens.newslist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoaibxmeghani.jetpacklab1.models.NewsItem
import com.shoaibxmeghani.jetpacklab1.repository.NewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListVM @Inject constructor(private val newsRepo: NewsRepo): ViewModel() {

    val newsList: StateFlow<List<NewsItem>>
        get() = newsRepo.newsList

    init {
        viewModelScope.launch {
            newsRepo.getNews()
        }
    }
}